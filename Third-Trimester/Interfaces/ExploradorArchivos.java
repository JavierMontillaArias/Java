import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExploradorArchivos {

    // Componentes principales de la interfaz
    private JFrame ventana;
    private JTree arbol;
    private DefaultTreeModel modeloArbol;
    private JTable tablaArchivos;
    private DefaultTableModel modeloTabla;
    private JLabel barraEstado;
    private JSplitPane panelDividido;

    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) {
        // Crear y mostrar la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ExploradorArchivos explorador = new ExploradorArchivos();
                explorador.crearYMostrarGUI();
            }
        });
    }

    /**
     * Crea y configura la interfaz gráfica principal
     */
    private void crearYMostrarGUI() {
        // Configuración básica de la ventana
        ventana = new JFrame("Explorador de Directorios");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer icono de la aplicación
        ImageIcon icono = new ImageIcon("src/recursos/digitech-ico.png");  
        ventana.setIconImage(icono.getImage());

        // Crear botón para abrir directorio
        JButton btnAbrir = new JButton("Abrir Directorio");
        btnAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarSelectorDirectorio();
            }
        });

        // Configuración del árbol de directorios
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Ningún Directorio Seleccionado");
        modeloArbol = new DefaultTreeModel(raiz);
        arbol = new JTree(modeloArbol);
        arbol.setCellRenderer(new RenderizadorArbolArchivos());
        JScrollPane scrollArbol = new JScrollPane(arbol);

        // Configuración de la tabla de archivos
        String[] nombresColumnas = {"Nombre", "Tamaño", "Fecha Modificación", "Tipo"};
        modeloTabla = new DefaultTableModel(nombresColumnas, 0);
        tablaArchivos = new JTable(modeloTabla);
        tablaArchivos.setFillsViewportHeight(true);
        tablaArchivos.setAutoCreateRowSorter(true);
        JScrollPane scrollTabla = new JScrollPane(tablaArchivos);

        // Configuración del panel dividido
        panelDividido = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollArbol, scrollTabla);
        panelDividido.setDividerLocation(200);
        panelDividido.setOneTouchExpandable(true);

        // Configuración de la barra de estado
        barraEstado = new JLabel("Ningún directorio seleccionado");
        barraEstado.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Agregar escuchador de selección al árbol
        arbol.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) 
                    arbol.getLastSelectedPathComponent();
                if (nodoSeleccionado != null) {
                    actualizarTablaArchivos(nodoSeleccionado);
                }
            }
        });

        // Configuración del layout
        ventana.setLayout(new BorderLayout());
        ventana.add(btnAbrir, BorderLayout.NORTH);
        ventana.add(panelDividido, BorderLayout.CENTER);
        ventana.add(barraEstado, BorderLayout.SOUTH);

        // Ajustes finales de la ventana
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    /**
     * Muestra el diálogo para seleccionar un directorio
     */
    private void mostrarSelectorDirectorio() {
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new java.io.File("."));
        selector.setDialogTitle("Seleccione Directorio");
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selector.setAcceptAllFileFilterUsed(false);

        if (selector.showOpenDialog(ventana) == JFileChooser.APPROVE_OPTION) {
            File directorioSeleccionado = selector.getSelectedFile();
            poblarArbol(directorioSeleccionado);
            barraEstado.setText("Directorio actual: " + directorioSeleccionado.getAbsolutePath());
            arbol.expandRow(0);
        }
    }

    /**
     * Llena el árbol con el contenido del directorio seleccionado
     */
    private void poblarArbol(File directorio) {
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(new NodoArchivo(directorio));
        modeloArbol.setRoot(raiz);
        agregarArchivos(raiz, directorio);
        modeloArbol.reload();
    }

    /**
     * Agrega recursivamente los archivos al árbol
     */
    private void agregarArchivos(DefaultMutableTreeNode nodo, File archivo) {
        if (archivo.isDirectory()) {
            File[] archivos = archivo.listFiles();
            if (archivos != null) {
                for (File f : archivos) {
                    DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(new NodoArchivo(f));
                    nodo.add(nodoHijo);
                    if (f.isDirectory()) {
                        agregarArchivos(nodoHijo, f);
                    }
                }
            }
        }
    }

    /**
     * Actualiza la tabla con el contenido del directorio seleccionado
     */
    private void actualizarTablaArchivos(DefaultMutableTreeNode nodo) {
        modeloTabla.setRowCount(0);
        
        Object objetoUsuario = nodo.getUserObject();
        if (objetoUsuario instanceof NodoArchivo) {
            File archivoSeleccionado = ((NodoArchivo) objetoUsuario).getArchivo();
            barraEstado.setText("Directorio actual: " + archivoSeleccionado.getAbsolutePath());
            
            if (archivoSeleccionado.isDirectory()) {
                File[] archivos = archivoSeleccionado.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        agregarArchivoATabla(archivo);
                    }
                }
            }
        }
    }

    /**
     * Agrega un archivo a la tabla de detalles
     */
    private void agregarArchivoATabla(File archivo) {
        try {
            BasicFileAttributes atributos = Files.readAttributes(archivo.toPath(), BasicFileAttributes.class);
            String nombre = archivo.getName();
            String tamaño = archivo.isDirectory() ? "<DIR>" : formatearTamañoArchivo(archivo.length());
            String modificado = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(
                new Date(atributos.lastModifiedTime().toMillis()));
            String tipo = archivo.isDirectory() ? "Carpeta" : obtenerExtensionArchivo(archivo);
            
            modeloTabla.addRow(new Object[]{nombre, tamaño, modificado, tipo});
        } catch (Exception e) {
            modeloTabla.addRow(new Object[]{archivo.getName(), "Error", "Error", "Error"});
        }
    }

    /**
     * Formatea el tamaño del archivo en unidades legibles
     */
    private String formatearTamañoArchivo(long tamaño) {
        if (tamaño < 1024) {
            return tamaño + " B";
        } else if (tamaño < 1024 * 1024) {
            return Math.round(tamaño / 1024.0) + " KB";
        } else if (tamaño < 1024 * 1024 * 1024) {
            return Math.round(tamaño / (1024.0 * 1024)) + " MB";
        } else {
            return Math.round(tamaño / (1024.0 * 1024 * 1024)) + " GB";
        }
    }

    /**
     * Obtiene la extensión de un archivo
     */
    private String obtenerExtensionArchivo(File archivo) {
        String nombre = archivo.getName();
        int ultimoPunto = nombre.lastIndexOf(".");
        if (ultimoPunto == -1) {
            return "Archivo";
        }
        return nombre.substring(ultimoPunto + 1).toUpperCase() + " Archivo";
    }

    /**
     * Clase interna para representar un nodo de archivo
     */
    private class NodoArchivo {
        private File archivo;
        
        public NodoArchivo(File archivo) {
            this.archivo = archivo;
        }
        
        public File getArchivo() {
            return archivo;
        }
        
        @Override
        public String toString() {
            return archivo.getName();
        }
    }

    /**
     * Clase interna para personalizar la visualización de los nodos en el árbol
     */
private class RenderizadorArbolArchivos extends DefaultTreeCellRenderer {
    private ImageIcon iconoCarpeta;
    private ImageIcon iconoArchivo;
    
    public RenderizadorArbolArchivos() {
        try {
          
            // Cargar los iconos
            ImageIcon tempCarpeta = new ImageIcon("src/recursos/carpeta.png");
            ImageIcon tempArchivo = new ImageIcon("src/recursos/archivo.png");
            
            // Redimensionar a 16x16 píxeles
            Image imgCarpeta = tempCarpeta.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            Image imgArchivo = tempArchivo.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            
            iconoCarpeta = new ImageIcon(imgCarpeta);
            iconoArchivo = new ImageIcon(imgArchivo);
            
        } catch (Exception e) {
            System.out.println("Error al cargar iconos: " + e.getMessage());
            iconoCarpeta = (ImageIcon)UIManager.getIcon("FileView.directoryIcon");
            iconoArchivo = (ImageIcon)UIManager.getIcon("FileView.fileIcon");
        }
    }
    
    @Override
    public Component getTreeCellRendererComponent(JTree arbol, Object valor, 
            boolean seleccionado, boolean expandido, boolean esHoja, int fila, boolean tieneFoco) {
        
        JLabel etiqueta = (JLabel)super.getTreeCellRendererComponent(
            arbol, valor, seleccionado, expandido, esHoja, fila, tieneFoco);
        
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) valor;
        Object objetoUsuario = nodo.getUserObject();
        
        if (objetoUsuario instanceof NodoArchivo) {
            NodoArchivo nodoArchivo = (NodoArchivo) objetoUsuario;
            File archivo = nodoArchivo.getArchivo();
            
            etiqueta.setIcon(archivo.isDirectory() ? iconoCarpeta : iconoArchivo);
        }
        
        return etiqueta;
    }
    
    @Override
    public Icon getClosedIcon() {
        return iconoCarpeta;
    }

    @Override
    public Icon getOpenIcon() {
        return iconoCarpeta;
    }

    @Override
    public Icon getLeafIcon() {
        return iconoArchivo;
    }
}
}