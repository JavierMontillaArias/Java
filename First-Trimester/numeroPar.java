import java.util.Scanner;

public class numeroPar {
    public static void main(String[] args) {
        float numero;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el número: ");
        numero = teclado.nextInt();
        System.out.println((numero%2 == 0) ? "El número es par" : "El número es impar");
        teclado.close();
    }
}