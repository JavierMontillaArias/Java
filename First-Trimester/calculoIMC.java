import java.util.Scanner;
public class calculoIMC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int peso;
        float altura, imc;
        System.out.print("Dime tu peso en kg: ");
        peso=sc.nextInt();
        System.out.print("Dime tu altura en cm: ");
        altura=sc.nextInt();
        altura=altura/100;
        imc=peso/(altura*altura);
        System.err.println(+imc);
        if(imc<18.5)
        {
            System.out.println("Peso insuficiente");
        }
        else if((imc>18.9) & (imc<24.9))
        {
            System.out.println("Peso saludable");
        }
        else if((imc>25) & (imc<29.9))
        {
            System.out.println("Sobrepeso");
        }
        else
        {
            System.out.println("Obesidad");
        }
        sc.close();
    }
}