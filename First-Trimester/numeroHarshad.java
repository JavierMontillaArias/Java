import java.util.Scanner;

public class numeroHarshad {
    public static boolean esHarshad(int n)
    {
        boolean f=false;
        int suma=0;
        int aux=n;
        while(aux>0)
        {
            suma+=aux%10;
            aux/=10;
        }
        if(n%suma==0)
        {
            f=true;
        }
        return f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Dame un numero y te dire si es Harshad: ");
        num=sc.nextInt();
        for(int i=1; i<=num; i++)
        {
            if(esHarshad(i))
            {
                System.out.print(i+ " ");
            }
        }
        sc.close();
    }
}
