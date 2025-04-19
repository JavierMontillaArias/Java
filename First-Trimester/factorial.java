import java.util.Scanner;

public class factorial {
    public static double factorial (double n)
    {
        double fact=1;
        for (int i=1; i<=n; i++)
        {
            fact*=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        double num;
        Scanner sc=new Scanner(System.in);
        System.out.print("Dame un numero y te doy su factorail: ");
        num=sc.nextInt();
        System.out.println("El factorial es: "+factorial(num));
        sc.close();
    }
}