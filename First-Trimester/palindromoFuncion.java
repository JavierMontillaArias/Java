import java.util.Scanner;
public class palindromoFuncion {
    public static String invCadena(String f)
    {
        String cadena="";
        for(int i=f.length();i>0;i--)
        {
            cadena+=f.substring(i-1, i);
        }
        return cadena;
    }
    public static void main(String[] args) {
        String frase;
        Scanner sc=new Scanner(System.in);
        System.out.print("Dame una frase para saber si es palindromo: ");
        frase=sc.nextLine();
        if(frase.equals(invCadena(frase)))
        {
            System.out.println("Es palindromo");
        }
        else
        {
            System.out.println("No es palindromo");
        }
        sc.close();
    }
}