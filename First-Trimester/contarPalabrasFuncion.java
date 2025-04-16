import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class contarPalabrasFuncion {
    public static void main(String[] args) {

        String text, letra;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime una frase: ");
        text = teclado.nextLine();

        System.out.println("Tu frase tiene " + contarPalabras(text) + " palabras");

        teclado.close();

    }

    public static int contarPalabras(String frase) {

        int ret = 1;

        for (int i = 0; i < frase.length(); i++) {
            
            if (frase.substring(i, i + 1).equals(" ")) { //&& !frase.substring(i+1, i + 2).equals(" ")) {
                ret++;
            }

        }

        return ret;
    }
}