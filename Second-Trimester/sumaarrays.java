import java.util.Scanner;
public class sumaarrays {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double [] venta = new double [7];
        String [] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        double total = 0;

        for (int i = 0; i < venta.length; i++){
            System.out.print("Cuanto dinerico has hecho el " + dias[i] + ": ");
            venta[i] = sc.nextInt(); 
            total += venta[i];
        }

        System.out.println("Has sacado " + total + " euros de ganancia");

        sc.close();
    }
}