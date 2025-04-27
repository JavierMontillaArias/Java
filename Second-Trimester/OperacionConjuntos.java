import java.util.Scanner;
import java.util.TreeSet;

public class OperacionConjuntos {
    public static void rellenarHashSet(TreeSet<Integer> conjunto, Scanner sc, int cantidad){
        for(int i = 0; i < cantidad; i++){
            System.out.print("Introduce el número en la posición " + (i+1) + ": ");
            int num = sc.nextInt();
            conjunto.add(num);
        }
    }
    public static void imprimirLista(TreeSet<Integer> conjunto){
        System.out.print("[");
        int contador = 0;
        for (int num : conjunto){
            if(contador < conjunto.size() - 1){
                System.out.print(num + ", ");
                contador++;
            } else {
                System.out.println(num + "]");
            }
        }
    }
    public static TreeSet <Integer> union(TreeSet<Integer> conjunto1, TreeSet<Integer> conjunto2){
        TreeSet<Integer> aux = new TreeSet<>();
        for(int num : conjunto1){
            aux.add(num);
        }
        for(int num : conjunto2){
            aux.add(num);
        }
        return aux;
    }
    public static TreeSet<Integer> interseccion (TreeSet<Integer> conjunto1, TreeSet<Integer> conjunto2){
        TreeSet<Integer> aux = new TreeSet<>();
        for(int num : conjunto1){
            for(int num2 : conjunto2){
                if(num == num2){
                    aux.add(num);
                }
            }
        }
        return aux;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        TreeSet <Integer> conjunto1 = new TreeSet<>();
        System.out.print("Introduce el tamaño de la lista: ");
        int cantidad1 = sc.nextInt();
        System.out.println("-----------------------------------------------------");
        rellenarHashSet(conjunto1, sc, cantidad1);
        System.out.println("-----------------------------------------------------");
        TreeSet <Integer> conjunto2 = new TreeSet<>();
        System.out.print("Introduce el tamaño de la lista: ");
        int cantidad2 = sc.nextInt();
        System.out.println("-----------------------------------------------------");
        rellenarHashSet(conjunto2, sc, cantidad2);
        System.out.println("-----------------------------------------------------");
        TreeSet <Integer> uni = new TreeSet<>();
        uni=union(conjunto1, conjunto2);
        System.out.print("La unión de las listas son: ");
        imprimirLista(uni);
        System.out.println("-----------------------------------------------------");
        TreeSet <Integer> inter = new TreeSet<>();
        inter=interseccion(conjunto1, conjunto2);
        System.out.print("La intersección de las listas son: ");
        imprimirLista(inter);
        System.out.println("-----------------------------------------------------");
        sc.close();
    }
}
