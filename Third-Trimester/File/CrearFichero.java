import java.io.File;
import java.util.Scanner;

public class CrearFichero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pulse intro para crear el archivo" );
        String r = sc.nextLine();

        File fichero = new File("miArchivo.txt");
        try {
            if(fichero.createNewFile())
                System.out.println("Archivo creado correctamente");
            else    
                System.out.println("Error al crear el archivo");

            System.out.println("Pulse intro para crear el archivo" );
            r = sc.nextLine();
            
            if(fichero.delete())
                System.out.println("Archivo borrado correctamente");
            else    
                System.out.println("Error al borrar el archivo");


        } catch (Exception e) {
            // TODO: handle exception
        }
        sc.close();
    }
}