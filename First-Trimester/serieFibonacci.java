import java.util.Scanner;
public class serieFibonacci {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num, a=0, b=1, suma;
        System.out.print("Hasta qué número quieres las serie (a partir del 3):");
        num = teclado.nextInt();
        System.out.print(a +", " + b);
        for (int i=3; i<= num; i++) {
            suma = a + b;
            System.out.print(", " + suma);
            a = b;
            b = suma;
        }
        System.out.println("");
        teclado.close();
    }
}