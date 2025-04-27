import java.util.Scanner;

public class ordenarpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la longitud de la array: ");
        int longitud = sc.nextInt();
        int [] lista = new int[longitud];
        int aux, j=0;
        for (int i = 0; i < longitud; i++) {
            System.out.print("Introduce el valor " + (i+1) + ": ");
            lista[i] = sc.nextInt();
        }
        for(int i = 0; i < longitud; i++){
            if(lista[i]%2 == 0) {
                aux = lista[j];
                lista[j] = lista [i];
                lista[i] = aux;
                j++;
            }
        }
        for(int i = 0; i < longitud; i++){
            if(lista[i]%2 != 0) {
                aux = lista[j];
                lista[j] = lista [i];
                lista[i] = aux;
                j++;
            }
        }
        System.out.print("La lista es: ");
        for(int i = 0; i < longitud; i++){
            System.out.print(lista[i]);
            if (i < lista.length - 1) {
                System.out.print(", ");
            }
        } 
        sc.close();
    }
}
