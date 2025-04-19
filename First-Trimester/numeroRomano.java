import java.util.Scanner;
public class numeroRomano {
    public static String numero(int n)
    {
        String[] unidades = {"", "I", "II", "III", "IV", "V","VI", "VII", "VIII", "IX"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L","LX", "LXX", "LXXX", "XC"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D","DC", "DCC", "DCCC", "CM"};
        String[] milesimas = {"", "M", "MM", "MMM"};
        int mil=n/1000;
        int cent=(n%1000)/100;
        int dec=(n%100)/10;
        int uni=(n%10);
        return milesimas[mil]+centenas[cent]+decenas[dec]+unidades[uni];
    }

    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame un numero y lo pasaré a romano: ");
        num=sc.nextInt();;
        System.out.println(numero(num));
        sc.close();
    }
}