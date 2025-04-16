import java.util.Scanner;

public class contarPrimos {
    public static boolean esPrimo(int n)
    {
        int contador=0;
        for (int i=1; i<=n; i++)
        {
            if(n%i==0)
            {
                contador++;
            }
        }
        if(contador==2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int num;
        System.out.print("Dame un numero y comprobare si es primo: ");
        num=sc.nextInt();
        if(esPrimo(num))
        {
            System.out.println(" "+num+" es primo");
        }
        else
        {
            System.out.println(" "+num+" no es primo");
        }
        sc.close();
    }
}
