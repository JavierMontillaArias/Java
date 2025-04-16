import java.util.Scanner;
public class esFibo {
    public static boolean primo(int n) 
    {
        boolean f=false;
        int a, b, suma = 0;
        a = 0;
        b = 1;
        if (n == 0 || n == 1) 
        {
            f=true;
        } 
        else 
        {
            for (int i = 1; i <= n; i++) 
            {
                suma = a + b;
                a = b;
                b = suma;
                if (suma == n) 
                {
                    f=true;
                }
            }
        }
        return f;
    }

    public static void main(String[] args) 
    {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero para comprobar que esta en la serie de Fibonacci: ");
        num = sc.nextInt();
        if (primo(num)) 
        {
            System.out.println("Esta en Fibonacci");
        } else 
        {
            System.out.println("No esta en Fibonacci");
        }
        sc.close();
    }

}