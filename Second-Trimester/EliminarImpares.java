import java.util.ArrayList;
import java.util.Scanner;
public class EliminarImpares {
    public static void imprimirLista(ArrayList<Integer> lista){
        for(int num : lista){
            System.out.print(num + " ");
        }
    }
    public static void rellenarLista(Scanner sc, ArrayList<Integer> lista){
        System.out.print("Introduce el tamaño de la lista: ");
        int cantidad = sc.nextInt();
        for(int i = 0; i < cantidad; i++){
            System.out.print("Introduce el numero en la posición " + (i+1) +" de la lista: ");
            int num = sc.nextInt();
            lista.add(num);
        }
    }
    public static ArrayList<Integer> eliminarImpares(ArrayList<Integer> lista){
        ArrayList<Integer> impares = new ArrayList<>();
        for(Integer num : lista){
            if(num % 2 != 0){
                impares.add(num);
            }
        }
        lista.removeAll(impares);
        return lista;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        rellenarLista(sc, lista);
        System.out.print("Lista original: ");
        imprimirLista(lista);
        System.out.println("");
        lista = eliminarImpares(lista);
        System.out.println("");
        System.out.print("Lista sin impares: ");
        if(lista.size()==0){
            System.out.print("no tiene números pares");
        } else {
            imprimirLista(lista);
        }
        sc.close();
    }
}