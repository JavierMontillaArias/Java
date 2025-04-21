import java.util.Scanner;

public class indexar {

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
    public static boolean hayDuplicados(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] indexarArray(int lista [], int [] posiciones){
        int aux [] = new int[lista.length];
        for ( int i = 0; i< lista.length; i++){
            int pos = posiciones[i] - 1;
            aux[pos] = lista [i];
        }
        return aux;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        System.out.println("------------------------------------------------");
        System.out.print("Introduce la longitud de la array: ");
        int longitud = sc.nextInt();
        System.out.println("------------------------------------------------");
        int lista [] = new int[longitud];
        for(int i = 0; i < longitud; i++){
            System.out.print("Array de numeros en la posicion " + (i + 1) +": ");
            lista[i] = sc.nextInt();
        }
        System.out.println("------------------------------------------------");
        System.out.print("La lista de valores es: ");
        escribirArray(lista);
        System.out.println("------------------------------------------------");
        System.out.println("");
        int posicion [] = new int[longitud];
        while (!ok) {
            for(int i = 0; i < longitud; i++){
                System.out.print("Array de posiciones en la posicion  (La array empieza en 1) " + (i + 1) +": ");
                posicion[i] = sc.nextInt();
            }
            if(hayDuplicados(posicion)){
                System.out.println("------------------------------------------------");
                System.out.println("Hay repetidos en la array de indexados");
                System.out.println("------------------------------------------------");
            } else {
                ok = true;
            }
        }
        System.out.println("------------------------------------------------");
        System.out.print("La lista de indexados es: ");
        escribirArray(posicion);
        System.out.println("------------------------------------------------");
        System.out.println("");
        int aux [] = new int[longitud];
        System.out.println("------------------------------------------------");
        aux = indexarArray(lista, posicion);
        System.out.print("La lista indexada es: ");
        escribirArray(aux);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
