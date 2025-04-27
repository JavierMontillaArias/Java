import java.util.Random;
import java.util.Scanner;

public class rotarMatriz {
     public static void leerMatriz(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public static void rellenarMatriz(int mat[][]) {
        Random rd = new Random();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = rd.nextInt(9);
            }
        }
    }
    public static int [][] rotarLaMatriz (int mat [][], boolean izq){
        int n = mat.length;
        int aux [][] = new int[mat.length][mat.length];
        if (izq == true){
            for (int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat.length; j++){
                    aux[n - j - 1][i] = mat[i][j];
                }
            }
        } else {
            for (int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat.length; j++){
                    aux[j][n - i - 1] = mat[i][j];
                }
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
        rellenarMatriz(mat);
        leerMatriz(mat);
        System.out.println("------------------------------------------------");
        int rot [][] = new int[n][n];
        System.out.print("Rota sentido horario o antihorario (H/A): ");
        String opcion = sc.nextLine().toUpperCase();
        boolean izq;
        sc.nextLine();
        if(opcion.equals("H")){
            izq = true;
        } else {
            izq = false;
        }
        System.out.println("------------------------------------------------");
        rot = rotarLaMatriz(mat, izq);
        leerMatriz(rot);
        System.out.println("------------------------------------------------");
        sc.close();
    }
}
