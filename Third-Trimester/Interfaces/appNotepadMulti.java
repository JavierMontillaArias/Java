import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class appNotepadMulti {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad Multiventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        JMenu mArchivo = new JMenu("Archivo");
        JMenuItem miNuevo = new JMenuItem("Nuevo");
        JMenuItem miAbrir = new JMenuItem("Abrir");
        JMenuItem miGuardar = new JMenuItem("Guardar");
        JMenuItem miSalir = new JMenuItem("Salir");

        mArchivo.add(miNuevo);
        mArchivo.add(miAbrir);
        mArchivo.add(miGuardar);
        mArchivo.addSeparator();;
        mArchivo.add(miSalir);

        mb.add(mArchivo);

        frame.setJMenuBar(mb);
        frame.setLayout(new BorderLayout());

        JDesktopPane jdp = new JDesktopPane();
        frame.add(jdp,BorderLayout.CENTER);

        miSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });

        miNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                JInternalFrame jif = new JInternalFrame("Sin título...",true,true,true,true);
                JTextArea jta = new JTextArea();
                jif.add(jta);
                jdp.add(jif);
                jif.setSize(200,200);
                jif.setVisible(true);
            }
        });

       miAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                JFileChooser jfc = new JFileChooser();
                jfc.showOpenDialog(jdp);
                File archivo = jfc.getSelectedFile();

                JInternalFrame jif = new JInternalFrame(archivo.getAbsolutePath(),true,true,true,true);
                JTextArea jta = new JTextArea();
                jif.add(jta);

                try {
                    FileReader lector = new FileReader(archivo);
                    BufferedReader lectorConBuffer = new BufferedReader(lector);   
                    String txt ="";

                    txt = lectorConBuffer.readLine();
                    while(txt != null)
                    {
                        jta.setText(jta.getText() + txt + "\n");
                        txt = lectorConBuffer.readLine();
                    }
                    lectorConBuffer.close();
                   
                } catch (IOException ioe) {
                    // TODO: handle exception
                }                

                jdp.add(jif);
                jif.setSize(200,200);
                jif.setVisible(true);
            }                

            }
       );

        miGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JInternalFrame jif = jdp.getSelectedFrame();
                if (jif != null) {
                    Container contenedor = jif.getContentPane();
                    JTextArea jta = (JTextArea) contenedor.getComponent(0);
                        
                    JFileChooser jfc = new JFileChooser();
                    jfc.showSaveDialog(jdp);
                    File archivo = jfc.getSelectedFile();
                    try {
                        FileWriter escritor = new FileWriter(archivo);
                        BufferedWriter escritorConBuffer = new BufferedWriter(escritor); 
                        
                        escritorConBuffer.write(jta.getText());
                        escritorConBuffer.close();
                    } catch (IOException ioe) {
                        // TODO: handle exception
                    }  
                    jif.setTitle(archivo.getAbsolutePath());              
                }
            }
        });


        frame.setSize(400,400);
        frame.setVisible(true);
    }
}