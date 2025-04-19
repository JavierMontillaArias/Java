import java.util.Scanner;

public class numeroPerfecto {
    public static boolean perfecto(int n) {
        boolean f=false;
        int suma=0;
        for (int i=1; i<n; i++) {
            if(n%i==0) {
                suma+=i;
            }
        }
        if(suma==n) {
            f=true;
        }
        return f;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.print("Dame un numero para comprobar si es perfecto: ");
        num=sc.nextInt();
        if(perfecto(num)) {
            System.err.println("El numero es perfecto");
        }
        else {
            System.out.println("No es perfecto");
        }
        sc.close();
    }
}