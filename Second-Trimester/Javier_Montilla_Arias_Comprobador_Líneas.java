import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Javier_Montilla_Arias_Comprobador_Líneas {
    public static void leerMatriz(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print("Fila " + (i + 1) + ": [ ");
            for (int j = 0; j < mat[i].length; j++) { 
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("]");
        }
    }
    public static void rellenarMatriz(int mat[][], Scanner sc) {
        Random rd = new Random();
        // Uso Set para comprobar que no haya repetidos en la matriz.
        Set<Integer> usados = new HashSet<>();
        int num;

        for (int i = 0; i < 9; i++) {
            // Genero cuántas columnas puede tener la matriz en cada una de sus filas, entre 1 y 4.
            int columnas = rd.nextInt(1, 5); 
            mat[i] = new int[columnas]; 

            for (int j = 0; j < columnas; j++) {
                // Compruebo si está repetido con el Set de usados.
                do {
                    num = rd.nextInt(1, 100);
                }while(usados.contains(num));
                // Si no está en el Set de usados lo añado.
                usados.add(num);
                // Lo añado a la matriz.
                mat[i][j] = num;
            }
        }
    }

    public static TreeSet<Integer> listaDeNumeros(int n){
        // Uso TreeSet para que salgan todos los números ordenados para comprobarlos en la matriz
        TreeSet<Integer> lista = new TreeSet<>();
        Random rd = new Random();
        while(lista.size() < n){
            lista.add(rd.nextInt(1,100));
        }
        return lista;
    }
    public static int comprobarLineas(int mat [][], TreeSet<Integer> lista){
        int numLineas=0;
        for(int i = 0; i < mat.length; i++){
            int contador = 0;
            for(int j = 0; j < mat[i].length; j++){
                for(int k = 0; k < lista.size(); k++){
                    // Si la lista de números contiene el número que hay en la matriz el contador se incrementa en 1.
                    if(lista.contains(mat[i][j])){
                        contador++;
                        break;
                    }
                }
            }
            // Si el contador es igual al número de columnas que hay en la fila es BINGO.
            if(contador==mat[i].length){
                numLineas++;
                System.out.print("Linea | ");
            } else {
                System.out.print("No | ");
            }
        }
        return numLineas;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        int mat [][] = new int[9][];
        System.out.println("Su cartón: ");
        rellenarMatriz(mat, sc);
        leerMatriz(mat);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce el cantidad de números que quieres que salgan: ");
        int num = sc.nextInt();
        TreeSet<Integer> lista = new TreeSet<>();
        lista = listaDeNumeros(num);
        System.out.print("Números que han salido: [ ");
        int contador = 0;
        for (int numero : lista) {
            System.out.print(numero);
            contador++;
            if (contador < lista.size()) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
        System.out.println("------------------------------------------------");
        int lineas = comprobarLineas(mat, lista);
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.println("Hay " + lineas + " lineas en tu cartón");
        System.out.println("------------------------------------------------");
        sc.close();
    }
}