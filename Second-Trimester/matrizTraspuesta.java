import java.util.Random;
import java.util.Scanner;

public class matrizTraspuesta {
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

    public static int[][] traspuestaMatriz(int mat[][]) {
        int aux[][] = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                aux[j][i] = mat[i][j];
            }
        }
        return aux;
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
        int tras [][] = new int[n][n];
        tras = traspuestaMatriz(mat);
        leerMatriz(tras);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
