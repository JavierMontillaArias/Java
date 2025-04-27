import java.util.Scanner;
public class ordenAscendente {
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
    public static boolean esAscendente(int array []){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la longitud de la array: ");
        int longitud = sc.nextInt();
        int ascendente [] = new int[longitud];
        rellenarArray(sc, ascendente);
        escribirArray(ascendente);
        if(esAscendente(ascendente)){
            System.out.println("Es ascendente");
        } else {
            System.out.println("Es descendente");
        }
        int descendente [] = new int[longitud];
        rellenarArray(sc, descendente);
        escribirArray(descendente);
        if(esAscendente(descendente)){
            System.out.println("Es ascendente");
        } else {
            System.out.println("Es descendente");
        }
        sc.close();
    }
}