import java.util.Scanner;

public class factorialRecursivo {

    public static long factorial (long n) {
        long fact;
        if(n==0)
        {
            fact=1;
        }
        else
        {
            fact=n*factorial(n-1);
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long num;
        System.out.print("Dame un numero y calculare su factorial: ");
        num=sc.nextLong();
        System.out.println("El factorial es: "+factorial(num));
        sc.close();
    }
}