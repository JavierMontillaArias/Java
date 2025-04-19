import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class palindromo {
    public static void main(String[] args) {

        String cadena1, cadena2 = "";
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime una palabra: ");
        cadena1 = teclado.nextLine();

        for (int i = cadena1.length(); i>=1; i--) {
            //cadena2 = cadena2 + cadena1.charAt(i-1);
            cadena2 = cadena2 + cadena1.substring(i-1,i);
            System.out.println(cadena2);
        }

        if (cadena1.equals(cadena2)) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }
        
        teclado.close();

    }
}