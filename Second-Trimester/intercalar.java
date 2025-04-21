import java.util.Scanner;
public class intercalar {
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
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce la longitud de las arrays: ");
        int longitud = sc.nextInt();
        System.out.println("------------------------------------------------");
        int lista1 [] = new int[longitud];
        rellenarArray(sc, lista1);
        System.out.println("------------------------------------------------");
        escribirArray(lista1);
        System.out.println("------------------------------------------------");
        int lista2 [] = new int[longitud];
        rellenarArray(sc, lista2);
        System.out.println("------------------------------------------------");
        escribirArray(lista2);
        System.out.println("------------------------------------------------");
        int liston [] = new int[2*longitud];
        for(int i = 0; i < liston.length; i++){
            if(i%2==0){
                liston[i] = lista1[i / 2];
            } else {
                liston[i] = lista2[i / 2];
            }
        }
        System.out.print("La array intercalada es: ");
        escribirArray(liston);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
