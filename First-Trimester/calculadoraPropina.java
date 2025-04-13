import java.util.Scanner;

public class calculadoraPropina {
    public static void main(String[] args) {

        float euros;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Dime la cantidad en euros: ");
        euros = teclado.nextFloat(); 
        System.out.println(" \n");
        System.out.println(" Euros son " + euros * 62.93 + " pesos");
        System.out.println(" Euros son " + euros * 1.09 + " dólares");
        System.out.println(" Euros son " + euros * 0.84 + " libras");

        teclado.close();
    }
}
