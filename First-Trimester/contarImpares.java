import java.util.Scanner;

public class contarImpares {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num, contador = 0, empezar = 1;
        System.out.println("Dime un número");
        num = teclado.nextInt();
        while (empezar <= num) {
            contador += 1;
            empezar += 2;
        }
        System.out.println("Hasta el " + num + " hay " + contador);
        teclado.close();
    }
}