package GestorContactos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GestorDeContactos extends JFrame implements ActionListener {
    private JTextField txtNombre, txtApellido, txtTelefono, txtEmail;
    private JTable tablaContactos;
    private DefaultTableModel modeloTabla;
    private JMenuBar menuBar;
    private JMenuItem itemAgregar, itemModificar, itemEliminar, itemBuscar;
    

    public GestorDeContactos() {
        setTitle("Gestor de Contactos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtNombre = new JTextField(10);
        txtApellido = new JTextField(10);
        txtTelefono = new JTextField(10);
        txtEmail = new JTextField(10);

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Email:"));
        add(txtEmail);

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Email");
        tablaContactos = new JTable(modeloTabla);
        add(new JScrollPane(tablaContactos));

        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        itemAgregar = new JMenuItem("Agregar");
        itemEliminar = new JMenuItem("Eliminar");
        itemBuscar = new JMenuItem("Buscar");
        itemModificar = new JMenuItem("Modificar");

        menu.add(itemAgregar);
        menu.add(itemModificar);
        menu.add(itemEliminar);
        menu.add(itemBuscar);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        itemAgregar.addActionListener(this);
        itemModificar.addActionListener(this);
        itemEliminar.addActionListener(this);
        itemBuscar.addActionListener(this);

        cargarContactos();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemAgregar) {
            agregarContacto();
        } else if (e.getSource() == itemEliminar) {
            eliminarContacto();
        } else if (e.getSource() == itemBuscar) {
            buscarContacto();
        } else if (e.getSource() == itemModificar) {
            modificarContacto();
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/contactosdb";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    private void agregarContacto() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();

        String sql = "INSERT INTO contactos (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, telefono);
            pstmt.setString(4, email);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Contacto agregado exitosamente!");
                limpiarCampos();
                cargarContactos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar contacto: " + ex.getMessage());
        }
    }

    private void eliminarContacto() {
        int filaSeleccionada = tablaContactos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un contacto para eliminar.");
            return;
        }

        Object id = modeloTabla.getValueAt(filaSeleccionada, 0);

        String sql = "DELETE FROM contactos WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, (Integer) id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Contacto eliminado exitosamente!");
                cargarContactos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar contacto: " + ex.getMessage());
        }
    }

    private void modificarContacto() {
        int filaSeleccionada = tablaContactos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un contacto para modificar.");
            return;
        }
    
        Object id = modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
    
        String sql = "UPDATE contactos SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id = ?";
    
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, telefono);
            pstmt.setString(4, email);
            pstmt.setInt(5, (Integer) id);
    
            int affectedRows = pstmt.executeUpdate();
    
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Contacto modificado exitosamente!");
                limpiarCampos();
                cargarContactos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar contacto: " + ex.getMessage());
        }
    }

    private void buscarContacto() {
        String nombreABuscar = txtNombre.getText();
        String sql = "SELECT * FROM contactos WHERE nombre LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nombreABuscar + "%");

            ResultSet rs = pstmt.executeQuery();
            modeloTabla.setRowCount(0); // Limpiar tabla

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email")
                };
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar contactos: " + ex.getMessage());
        }
    }

    private void cargarContactos() {
        String sql = "SELECT * FROM contactos";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            modeloTabla.setRowCount(0); // Limpiar tabla

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email")
                };
                modeloTabla.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar contactos: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GestorDeContactos().setVisible(true);
        });
    }
}