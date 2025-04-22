import java.util.Random;
import java.util.Scanner;

public class matriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumaPrincipal = 0, sumaSecundaria = 0;
        System.out.print("Introduce las filas y columnas de la matriz: ");
        int n = sc.nextInt();
        int mat [][] = new int[n][n];
        Random rd = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = rd.nextInt(0, 9);
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print("[ ");
            for(int j = 0; j < n; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("]");
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    sumaPrincipal += mat[i][j];
                }
                if((j==n-i-1)){
                    sumaSecundaria += mat[i][j];
                }
            }
        }

        System.out.println("La suma de la diagonal principal: " + sumaPrincipal + " y la suma de la diagonal secundaria es: " +sumaSecundaria);

        sc.close();
    }
}