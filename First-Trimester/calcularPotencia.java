import java.util.Scanner;
public class calcularPotencia {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int base, exponente, resultado = 1;
        System.out.print("Dime la base: ");
        base = teclado.nextInt();
        System.out.print("Dime el exponente: ");
        exponente = teclado.nextInt();
        for (int i = 1; i <= exponente; i++) resultado *= base;
        System.out.println(base + " elevado a " + exponente + " es igual a " + resultado);
    }
}