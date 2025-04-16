import java.util.Scanner;

public class esPrimo {
    public static void primo(int n)
    {
        int contador=0;
        for(int i=1; i<=n;i++)
        {
            if(n%i==0)
            {
                contador++;
            }
        }
        if(contador==2)
        {
            System.out.println(+n+ " es primo");
        }
        else
        {
            System.out.println(+n+ " no es primo");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.print("Dame un numero para comprobar si es primo: ");
        num=sc.nextInt();
        primo(num);
        sc.close();
    }
}
