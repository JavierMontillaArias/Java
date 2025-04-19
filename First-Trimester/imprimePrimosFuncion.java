import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class imprimePrimosFuncion {
    public static void main(String[] args) {
        int num, contador, primo = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime un número: ");
        num = teclado.nextInt();

        System.out.println("Hasta " + num + " los números primos son ");

        for (int i=1; i <= num; i++) {
            contador = 0;
            for (int j=1; j <= primo; j++) {
                if (primo %j == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                System.out.println(primo + " ");
            }
            primo++;
        }

        teclado.close();

    }
}