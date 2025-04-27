import java.util.ArrayList;
import java.util.Scanner;
public class SumarElementos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        int contador = 0;
        System.out.print("Introduce el tamaño de la lista: ");
        int cantidad = sc.nextInt();
        for(int i = 0; i < cantidad; i++){
            System.out.print("Introduce el numero: ");
            int num = sc.nextInt();
            lista.add(num);
            contador += num;
        }
        System.out.println("La suma de la lista es: " + contador);
        sc.close();
    }
}