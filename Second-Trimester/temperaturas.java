import java.util.Scanner;
public class temperaturas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            double [] temperatura = new double[7];
            String [] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
            int mayor = 0, menor = 0;
            double total = 0;
            for(int i = 0; i < temperatura.length; i++){
                System.out.print("La temperatura que hizo el " + dias[i] + " es: ");
                temperatura[i] = sc.nextDouble();
                if ( temperatura[i] > temperatura[mayor]) mayor = i;
                if ( temperatura[menor] > temperatura[i]) menor = i;
                total += temperatura[i]/temperatura.length;
            }
            System.out.println("La temperatura más baja fue el " + dias[menor] +" con " + temperatura[menor] + "ºC, la temperatura más alta fue " + dias[mayor] + " con " + temperatura[mayor] + "ºC, y el promedio fue " + total + "ºC");
        sc.close();
    }
}