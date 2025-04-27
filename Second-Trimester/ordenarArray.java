import java.util.Random;
import java.util.Scanner;

public class ordenarArray {
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
    public static void rellenarArray(int lista [], int num){
        Random rd = new Random();
        for(int i = 0; i < lista.length; i++){
            lista[i] = rd.nextInt(0, num);
        }
    }
    public static int [] ordenoArray(int array []){
        for(int i = 0; i < array.length ; i++){
            int pos = i;
            for(int j = i + 1; j<array.length; j++){
                if(array[pos] < array[j]){
                    pos = j;
                } 
            }
            
            int aux = array[i];
            array[i] = array[pos];
            array[pos] = aux;
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce el tamaño de las arrays: ");
        int longitud = sc.nextInt();
        System.out.println("------------------------------------------------");
        System.out.print("Introduce hasta que número se rellena: ");
        int num = sc.nextInt();
        int lista [] = new int[longitud];
        rellenarArray(lista, num);
        System.out.println("------------------------------------------------");
        System.out.print("Lista original: ");
        escribirArray(lista);
        System.out.println("------------------------------------------------");
        int list_aux [] = new int[longitud];
        list_aux = ordenoArray(lista);
        escribirArray(list_aux);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
