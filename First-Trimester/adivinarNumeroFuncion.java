import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class adivinarNumeroFuncion {
    public static void main(String[] args) {
        int num = 0, intentos = 0;
        Random rand = new Random();
        Scanner teclado = new Scanner(System.in);

        int numAleatorio = rand.nextInt(1, 100);

        do {
            System.out.println("Dime qué número crees que es: ");
            num = teclado.nextInt();
            if (num < numAleatorio) {
                System.out.println("Lo siento, el número que estoy pensando es mayor");
            } else if (num > numAleatorio) {
                System.out.println("Lo siento, el número que estoy pensando es menor");
            }
            intentos++;
        } while (num != numAleatorio);

        System.out.print("!!Enhorabuena has acertado en " + intentos + " intentos!!");
        teclado.close();

    }
}