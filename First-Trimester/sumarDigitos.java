import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class sumarDigitos {
    public static void main(String[] args) {

        int num, suma = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime un número: ");
        num = teclado.nextInt();

        while (num>0) {
            suma = suma + (num%10);
            num = (num/10);
        } 

        System.out.println("La suma de los digitos es " + suma);
        teclado.close();

    }
}