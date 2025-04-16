import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class contarAes {
    public static void main(String[] args) {

        String frase;
        int contador=0;
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime una frase: ");
        frase = teclado.nextLine();

        for (int i = 0; i<frase.length(); i++) {
            if (frase.substring(i,i+1).equals("a") || frase.substring(i,i+1).equals("á")) {
                contador++;
            }
        }
        System.out.println("En tu frase hay "+contador+" aes");
        
        teclado.close();

    }
}