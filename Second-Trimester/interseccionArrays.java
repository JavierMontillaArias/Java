import java.util.Random;
import java.util.Scanner;
public class interseccionArrays {
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
    public static int[] rellenarArray(int array []){
        Random rd = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = rd.nextInt(0,9);
        }
        return array;
    }
    public static void comprobarCoincidencia(int array1 [], int array2 []){
        for (int i = 0; i < array1.length; i++){
            int contador = 0;
            for (int j = 0; j < array2.length; j++){
                if(array1[i] == array2[j]){
                    contador++;
                }
            }
            if(contador != 0){
                System.out.println("El número " + array1[i] + " se repite " + contador + " veces");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce la longitud de las arrays: ");
        int longitud = sc.nextInt();
        int lista1 [] = new int[longitud];
        rellenarArray(lista1);
        System.out.println("------------------------------------------------");
        System.out.print("Array 1: ");
        escribirArray(lista1);
        int lista2 [] = new int[longitud];
        rellenarArray(lista2);
        System.out.println("------------------------------------------------");
        System.out.print("Array 2: ");
        escribirArray(lista2);
        System.out.println("------------------------------------------------");
        comprobarCoincidencia(lista1, lista2);
        sc.close();
    }
}