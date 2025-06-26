import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class DividirFichero {
    public static void main(String[] args) {
        File archivoLectura = new File("texto-largo.txt");

        try {
            FileReader lector = new FileReader(archivoLectura);
            BufferedReader lectorConBuffer = new BufferedReader(lector);

            int cont = 1;
            int numArchivo = 0;
            String nombreArchivo = "archivo-cortado-" + numArchivo + ".txt";
            String linea = lectorConBuffer.readLine();

            File archivoEscritura = new File(nombreArchivo);
            PrintWriter pw = new PrintWriter(archivoEscritura);  

            while (linea != null) {

                if(cont % 20 == 0)
                {
                    //cambio de archivo
                    pw.close();
                    numArchivo++;
                    nombreArchivo = "archivo-cortado-" + numArchivo + ".txt";
                    archivoEscritura = new File(nombreArchivo);
                    pw = new PrintWriter(archivoEscritura);
                }
                else
                {
                    //escribir en el fichero abierto  
                    pw.println(linea);
                    linea = lectorConBuffer.readLine();
                }
                cont++;                  
            }


        } catch (Exception e) {
            // TODO: handle exception
        }        
    }
}