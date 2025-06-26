import java.io.*;
import java.util.Scanner;

public class ListarFicheros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dime la ruta: ");
        String ruta = sc.nextLine();

        listar(ruta);
        sc.close();
    }

    public static void listar(String ruta){
        File fichero = new File(ruta);

        try {
            File[] ficheros = fichero.listFiles();
            for(int i = 0; i < ficheros.length; i++){
                if(ficheros[i].isFile())
                    System.out.println("- " + ficheros[i].getName().toLowerCase());
                else {
                    System.out.println("+ " + ficheros[i].getName().toUpperCase());
                    listar(ficheros[i].getPath());
                }
                    

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}