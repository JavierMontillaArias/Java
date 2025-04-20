import java.util.Scanner;
public class compararArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce el tamaño de la primera array: ");
        int n = sc.nextInt();
        int lista1 [] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Introduce en la array 1 la posicion " + (i+1) + ": ");
            lista1[i] = sc.nextInt();
        }
        System.out.print("\nIntroduce el tamaño de la segunda array: ");
        int m = sc.nextInt();
        if(n != m){
            System.out.println("\nNo son del mismo tamaño");
            sc.close();
            return;
        }
        int lista2 [] = new int[m];
        for(int i = 0; i < m; i++){
            System.out.print("Introduce en la array 2 la posicion " + (i+1) + ": ");
            lista2[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(lista1[i] != lista2[i]){
                System.out.println("\nLas arrays son diferentes");
                sc.close();
                return;
            }
        }
        System.out.println("\nLas arrays son iguales MÁQUINA");
        sc.close();
    }
}