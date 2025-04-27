import java.util.Scanner;

public class sumaParesImpares {
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
    public static void rellenarArray(Scanner sc, int lista []){
        for(int i = 0; i < lista.length; i++){
            System.out.print("Array de numeros en la posicion " + (i + 1) +": ");
            lista[i] = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce el tamaño de las arrays: ");
        int longitud = sc.nextInt();
        System.out.println("------------------------------------------------");
        int lista [] = new int[longitud];
        rellenarArray(sc, lista);
        System.out.println("------------------------------------------------");
        escribirArray(lista);
        System.out.println("------------------------------------------------");
        int sumaPares=0, sumaImpares=0;
        for (int i = 0; i < longitud; i++){
            if(lista[i]%2==0){
                sumaPares += lista[i];
            } else {
                sumaImpares += lista[i];
            }
        }
        System.out.println("La suma de pares es " + sumaPares + " y la suma de impares " + sumaImpares);
        System.out.println("------------------------------------------------");
    }
}
