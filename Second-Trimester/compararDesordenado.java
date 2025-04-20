import java.util.Scanner;
public class compararDesordenado {
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
    public static boolean comprobarSiEsta(int array1 [], int array2 []){
        for (int i = 0; i < array1.length; i++) {
            boolean encontrado = false;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tamaño de las arrays: ");
        int longitud = sc.nextInt();
        int lista1[] = new int[longitud];
        rellenarArray(sc, lista1);
        escribirArray(lista1);
        int lista2 [] = new int[longitud];
        rellenarArray(sc, lista2);
        escribirArray(lista2);
        if(comprobarSiEsta(lista1, lista2)){
            System.out.print("Las arrays son iguales en distintas posiciones");
        } else {
            System.out.print("Las arrays son distintas");
        }
        sc.close();
    }
}