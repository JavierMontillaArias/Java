import java.util.Scanner;
public class expandirArray {
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
    public static void escribirArrayFloat(float array []){
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
    public static float [] expandirLista(int array []){
        float aux [] = new float[2*array.length];
        int j=0, sum = 0;
        for (int i = 0; i < aux.length; i++){
            if(i%2==0){
                aux[i] = array[j];
                sum += array[j];
                j++;
            } else {
                if(j < array.length){
                    aux[i] = (float) ((array[j-1] + array[j]) / 2.0);
                } else {
                    aux[i] = sum;
                }
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
        rellenarArray(sc, lista);
        System.out.println("------------------------------------------------");
        System.out.print("Lista original: ");
        escribirArray(lista);
        float lista2 [] = new float[2 * longitud];
        lista2 = expandirLista(lista);
        System.out.println("------------------------------------------------");
        System.out.print("Lista cambiada: ");
        escribirArrayFloat(lista2);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
