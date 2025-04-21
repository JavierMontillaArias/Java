import java.util.Random;
import java.util.Scanner;

public class enterosATexto {
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
    public static void rellenarArray(int lista []){
        Random rd = new Random();
        for(int i = 0; i < lista.length; i++){
            lista[i] = rd.nextInt(0, 9);
        }
    }
    public static void pasarATexto(int array []){
        String[] numCadena = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez"};
        for (int i = 0; i < array.length; i++){
            System.out.print(numCadena[array[i]] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce el tamaño de las arrays: ");
        int longitud = sc.nextInt();
        int lista [] = new int[longitud];
        rellenarArray(lista);
        System.out.println("------------------------------------------------");
        System.out.print("Lista original: ");
        escribirArray(lista);
        System.out.println("------------------------------------------------");
        pasarATexto(lista);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
