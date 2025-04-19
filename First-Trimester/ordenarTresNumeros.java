import java.util.Scanner;
public class ordenarTresNumeros {
    public static void main(String[] args) {
        int a, b, c, tmp;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Dime el número 1 ");
        a = teclado.nextInt(); 
        System.out.print("Dime el número 2 ");
        b = teclado.nextInt(); 
        System.out.print("Dime el número 3 ");
        c = teclado.nextInt(); 

        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }

        if (a > c) {
            tmp = a;
            a = c;
            c = tmp;
        }
        if (b > c) {
            tmp = b;
            b = c;
            c = tmp;
        }

        System.out.print("Tus números ordenadores son - " + a + " - " + b + " - " + c);
        teclado.close();
    }
}