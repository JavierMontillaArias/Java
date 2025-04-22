import java.util.Scanner;

public class mayorMenor {
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
    public static void intercambiarArray(int array []){
        int mayor=array[0], menor=array[0], posicionMayor=0, posicionMenor=0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > mayor){
                mayor = array[i];
                posicionMayor = i;
            }
            if(array[i] < menor){
                menor = array[i];
                posicionMenor = i;
            }
        }
        int aux = array[posicionMayor];
        array [posicionMayor] = array[posicionMenor];
        array[posicionMenor] = aux;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce el tamaño de las arrays: ");
        int longitud = sc.nextInt();
        System.out.println("------------------------------------------------");
        int lista [] = new int[longitud];
        rellenarArray(sc, lista);
        System.out.println("------------------------------------------------");
        System.out.print("Lista original: ");
        escribirArray(lista);
        intercambiarArray(lista);
        System.out.println("------------------------------------------------");
        System.out.print("Lista cambiada el menor y el mayor: ");
        escribirArray(lista);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
