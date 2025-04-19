import java.util.Scanner;
public class tablaMultiplicar {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int num;
        
        System.out.println("Dime un número");
        num = teclado.nextInt();
        
        for (int i=10; i>=1; i--) {
            System.out.println(num + " x " + i + " = " + num*i);
        }

        teclado.close();
    }
}