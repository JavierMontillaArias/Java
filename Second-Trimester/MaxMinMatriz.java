import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
public class MaxMinMatriz {
    public static void leerMatriz(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public static void rellenarMatriz(int mat[][], Scanner sc) {
        Random rd = new Random();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = rd.nextInt(0, 9);
            }
        }
    }
    public static TreeSet<Integer> obtenerValoresOrdenados(int mat[][]) {
        TreeSet<Integer> valores = new TreeSet<>();
        for (int[] fila : mat) {
            for (int num : fila) {
                valores.add(num);
            }
        }
        return valores;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.print("Introduce el tamaño de las arrays: ");
        int n = sc.nextInt();
        System.out.println("------------------------------------------------");
        int mat [][] = new int[n][n];
        rellenarMatriz(mat, sc);
        leerMatriz(mat);
        System.out.println("------------------------------------------------");
        TreeSet<Integer> matriz = obtenerValoresOrdenados(mat);
        System.out.println("Le número mayor es " + matriz.last() + " y el menor es " + matriz.first());
        System.out.println("------------------------------------------------");
        sc.close();
    }
}