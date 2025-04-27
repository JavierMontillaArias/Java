import java.util.Scanner;
public class repeticion {
    public static int repetido(int n, int [] array){
        int contador = 0;
        for (int i = 0; i < array.length; i++){
            if(n == array[i])  contador++;
        }
        return contador;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("De cuántos números es la lista: ");
        int n = sc.nextInt();
        int [] lista = new int[n];
        for (int i = 0; i < n; i++){
            System.out.print("Añade a la lista en la posicion " + (i+1) + ": ");
            lista[i] = sc.nextInt();
        }
        System.out.print("Qué número busco: ");
        int num = sc.nextInt();
        System.out.print("Se repite el número " + num + " ha sido encontrado " + repetido(num, lista) + " veces");
        sc.close();
    }
}