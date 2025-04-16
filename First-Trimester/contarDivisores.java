import java.util.Scanner;
public class contarDivisores {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int contador=0, num;
        String divisores="";
        System.out.println("Dime un número");
        num = teclado.nextInt();
        for (int i=1; i<=num; i++) 
            if (num%i == 0 ) {
                contador += 1;
                divisores = divisores + " " + i;
            }
        System.out.println("El " + num + " tiene " + contador + " divisores \nY son " + divisores);
        teclado.close();
    }
}