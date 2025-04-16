import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class contarLetrasFuncion {
    public static void main(String[] args) {

        String text, letra;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime una frase: ");
        text = teclado.nextLine();

        System.out.println("Dime una letra: ");
        letra = teclado.nextLine();

        System.out.println("Tu frase tiene " + contarLetras(text, letra) + " " + letra);

        teclado.close();

    }

    public static int contarLetras(String frase, String let) {

        int ret = 0;

        for (int i = 0; i < frase.length(); i++) {
            
            if (frase.substring(i, i + 1).equals(let)) {
                ret++;
            }

        }

        return ret;
    }
}