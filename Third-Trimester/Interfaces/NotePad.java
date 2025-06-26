import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotePad {
    public static void main(String[] args) {
        Frame frame = new Frame("NotePad con AWT");
        TextArea taTexto = new TextArea();

        MenuBar menuBar = new MenuBar();
        Menu mArchivo = new Menu("Archivo");
        MenuItem miAbrir = new MenuItem("Abrir");
        MenuItem miGuardar = new MenuItem("Guardar");
        MenuItem miSalir = new MenuItem("Salir");

        mArchivo.add(miAbrir);
        mArchivo.add(miGuardar);
        mArchivo.addSeparator(); 
        mArchivo.add(miSalir);
        menuBar.add(mArchivo);
        frame.setMenuBar(menuBar);

        frame.add(taTexto);
        frame.setLayout(new GridLayout(1,1));

        miSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        miAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    File archivo = new File("fichero.txt");
                    FileReader lector = new FileReader(archivo);
                    BufferedReader lectorConBuffer = new BufferedReader(lector);   
                    String txt ="";

                    txt = lectorConBuffer.readLine();
                    while(txt != null)
                    {
                        taTexto.setText(taTexto.getText() + txt + "\n");
                        txt = lectorConBuffer.readLine();
                    }
                    lectorConBuffer.close();
                   
                } catch (IOException ioe) {
                    // TODO: handle exception
                }

            }
        });

        miGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String archivo = "fichero.txt";
                    FileWriter escritor = new FileWriter(archivo);
                    BufferedWriter escritorConBuffer = new BufferedWriter(escritor); 
                    
                    escritorConBuffer.write(taTexto.getText());
                    escritorConBuffer.close();
                } catch (IOException ioe) {
                    // TODO: handle exception
                }

            }
        });

//----------------------------------------------------------------
        frame.setSize(500,500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }); 
        }
}