import java.io.*;
import java.util.Scanner;

public class EscribirFichero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame una frase: ");
        String frase = sc.nextLine();

        File archivo = new File("fichero.txt");

        try (PrintWriter pw = new PrintWriter(archivo); ) {
            pw.println(frase);
        } catch (Exception e) {
            // TODO: handle exception
        }
/*
        try {
            PrintWriter pw = new PrintWriter(archivo); 
            pw.println(frase);
            pw.close();

        } catch (Exception e) {
            // TODO: handle exception
        } */
       sc.close();
    }
}