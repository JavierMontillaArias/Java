import java.util.Scanner;

public class fusionarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la longitud de las arrays: ");
        int longitud = sc.nextInt();
        int [] lista1 = new int[longitud];
        int [] lista2 = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            System.out.print("Introduce el valor " + (i+1) + " de la array 1: ");
            lista1[i] = sc.nextInt();
        }

        for (int i = 0; i < longitud; i++){
            System.out.print("Introduce el valor " + (i+1) + " de la array 2: ");
            lista2[i] = sc.nextInt();
        }

        int [] total = new int[(2*longitud)];

        for(int i = 0; i < longitud; i++) {
            total[i] = lista1[i];
            total[i+longitud] = lista2[i];
        }

        System.out.print("La lista combinada es: ");

        for (int i = 0; i < total.length; i++) {
            System.out.print(total[i]);
            if (i < total.length - 1) {
                System.out.print(", ");
            }
        }

        sc.close();
    }
}
