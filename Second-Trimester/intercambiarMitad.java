import java.util.Scanner;
public class intercambiarMitad {
    public static void escribirArray(int array []){
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            if(i < array.length - 1){
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
    }
    public static void rellenarArray(int lista [], Scanner sc){
        for(int i = 0; i < lista.length; i++){
            System.out.print("Array de numeros en la posicion " + (i + 1) +": ");
            lista[i] = sc.nextInt();
        }
    }
    public static int [] rellenoArray(int array []){
        int aux [] = new int[array.length];
        if (array.length%2 == 0){
            int mitad = array.length / 2, j = 0;
            for (int i = mitad; i < array.length; i++){
                aux[j] = array[i];
                j++;
            } 
            for (int i = 0; i < mitad; i++){
                aux[j] = array[i];
                j++;
            } 
        } else {
            int mitad = (array.length / 2), j = 0;
            for (int i = mitad + 1; i < array.length; i++){
                aux[j] = array[i];
                j++;
            } 
            if (j == mitad){
                aux[j] = array[mitad];
                j++;
            }
            for (int i = 0; i < mitad; i++){
                aux[j] = array[i];
                j++;
            } 
        }
        return aux;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce el tamaño de las arrays: ");
        int longitud = sc.nextInt();
        System.out.println("------------------------------------------------");
        int lista [] = new int[longitud];
        rellenarArray(lista, sc);
        System.out.println("------------------------------------------------");
        System.out.print("Lista original: ");
        escribirArray(lista);
        System.out.println("------------------------------------------------");
        int lista_final [] = new int[longitud];
        System.out.print("Lista final: ");
        lista_final = rellenoArray(lista);
        escribirArray(lista_final);
        System.out.println("------------------------------------------------");
    }
}