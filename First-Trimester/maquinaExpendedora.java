import java.util.Locale;
import java.util.Scanner;

public class maquinaExpendedora {
    public static void calcularCambio(float p, float c) {
        float cambio = c - p;
        int monedas;

        if(cambio < 0) {
            System.out.println("No has pagado suficiente.");
            return;
        }

        System.out.println("El cambio será " + cambio + " euros");

        int cambioInt = (int)(cambio * 100);

        if(cambioInt >= 200) {
            monedas = cambioInt / 200;
            System.out.println( monedas + " monedas de 2 euros");
            cambioInt = cambioInt % 200;
        }
        if(cambioInt >= 100) {
            monedas = cambioInt / 100;
            System.out.println( monedas + " monedas de 1 euros");
            cambioInt = cambioInt % 100;
        }
        if(cambioInt >= 50) {
            monedas = cambioInt / 50;
            System.out.println( monedas + " monedas de 0,50 euros");
            cambioInt = cambioInt % 50;
        }
        if(cambioInt >= 20) {
            monedas = cambioInt / 20;
            System.out.println( monedas + " monedas de 0,20 euros");
            cambioInt = cambioInt % 20;
        }
        if(cambioInt >= 10) {
            monedas = cambioInt / 10;
            System.out.println( monedas + " monedas de 0,10 euros");
            cambioInt = cambioInt % 10;
        }
        if(cambioInt >= 5) {
            monedas = cambioInt / 5;
            System.out.println( monedas + " monedas de 0,05 euros");
            cambioInt = cambioInt % 5;
        }
        if(cambioInt >= 2) {
            monedas = cambioInt / 2;
            System.out.println( monedas + " monedas de 0,02 euros");
            cambioInt = cambioInt % 2;
        }
        if(cambioInt >= 1) {
            monedas = cambioInt / 1;
            System.out.println( monedas + " monedas de 0,01 euros");
            cambioInt = cambioInt % 1;
        }
        
    }
    public static void main(String[] args) {
        float precio, cantidad;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Dime el precio: ");
        precio = sc.nextFloat();
        System.out.print("Dime con qué cantidad vas a pagar: ");
        cantidad = sc.nextFloat();

        calcularCambio(precio, cantidad);
        sc.close();
    }
}
