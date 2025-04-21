import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Meter un número en hexadecimal y que detecte si está bien, números hexadecimales = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F}, luego pasaremos el número hexadecimal a decimal.

public class hexadecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numHex;
        boolean ok =false;

        //Con Pattern y Matcher

        System.out.print("Introduce un número en hexadecimal: ");
        numHex=sc.nextLine();
        Pattern patron = Pattern.compile("[0-9A-F]+");
        Matcher texto = patron.matcher(numHex);
        if(texto.matches()){
            System.out.println("Es un número hexadecimal");
        } else {
            System.out.println("No es un número hexadecimal");
        }
        System.out.println("-----------------------------------------------");

        // Ahora con String

        String patronStr = "[0-9A-F]{1,}";
        while (!ok) {
            System.out.print("Introduce un número en hexadecimal: ");
            numHex=sc.nextLine().toUpperCase();
            if( numHex.matches(patronStr)) {
                ok=true;
                System.out.println("Es un número hexadecimal");
            } else {
                System.out.println("No es un número hexadecimal");
            }
        }
        System.out.println("-----------------------------------------------");

        //Pasar a decimal

        int decimal = Integer.valueOf(numHex, 16);
        System.out.printf("El numero %s, en decimal es %d", numHex, decimal);
        sc.close();
    }
}