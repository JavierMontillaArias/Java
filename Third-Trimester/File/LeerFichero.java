import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerFichero {
    public static void main(String[] args) {
        File archivo = new File("lorem.txt");

        try {
            FileReader lector = new FileReader(archivo);
            BufferedReader lectorConBuffer = new BufferedReader(lector);
            String linea = lectorConBuffer.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = lectorConBuffer.readLine();
            }


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}