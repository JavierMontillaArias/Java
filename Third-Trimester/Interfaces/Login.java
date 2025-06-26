import java.awt.*;
import java.awt.event.*;

public class Login {
    public static void main(String[] args) {
        Frame frame = new Frame("Formulario de Registro");

        Label lblNombre = new Label("Nombre:");
        TextField tfNombre = new TextField();
        Label lblPassword = new Label("Contraseña:");
        TextField tfPassword = new TextField();
        Label lblEmail = new Label("Email:");
        TextField tfEmail = new TextField();
        Button btnValidar = new Button("Validar");

        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));

        tfNombre.setPreferredSize(new Dimension(200,20));
        tfPassword.setEchoChar('*');
        tfPassword.setPreferredSize(new Dimension(200,20));
        tfEmail.setPreferredSize(new Dimension(200,20));

        btnValidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isValid = true;

                if(tfNombre.getText() == "") { isValid = false;}
                if(tfPassword.getText().length() < 8) {isValid = false;}
                if(!tfEmail.getText().contains("@")) {isValid = false;}

                Dialog dialog = new Dialog(frame,"Atención",true);

                dialog.setSize(200,200);
                Label lblMessage = new Label();
                if (isValid) {
                    lblMessage.setText("Registrado correctamente " + tfNombre.getText());
                }
                else {
                    lblMessage.setText("Hay campos incorrectos");
                }
                dialog.add(lblMessage);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        dialog.dispose();
                    }
                });     
                dialog.setVisible(true);  
        
            }
        });

        frame.add(lblNombre);
        frame.add(tfNombre);
        frame.add(lblPassword);
        frame.add(tfPassword);
        frame.add(lblEmail);
        frame.add(tfEmail);
        frame.add(btnValidar);

        frame.setResizable(false);
        frame.setSize(330, 160);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });        
    }
}