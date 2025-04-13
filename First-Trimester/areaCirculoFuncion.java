import java.util.Scanner;
import java.lang.Math;

public class areaCirculoFuncion {
    public static void main(String[] args) {
        double radio;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime el radio: ");
        radio = teclado.nextDouble();
        System.out.print("El área es: " + areaCirculo(radio));
        teclado.close();
    }

    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

}