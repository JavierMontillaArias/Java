import java.util.Scanner;

public class numerosRomanosNoArrays {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.print("Dime un número: ");
        num = sc.nextInt();

        System.out.println(num + " en romano sería " + intToRom(num));
        sc.close();
    }

    public static String intToRom(int n) {
        int uni, dec, cen, mil;
        String uniStr="", decStr="", cenStr="", milStr="";

        uni = n % 10;
        dec = (n / 10) % 10;
        cen = (n / 100) % 10;
        mil = (n / 1000) % 10;
        
        switch (uni) {
            case 1: uniStr = "I"; break;
            case 2: uniStr = "II"; break;
            case 3: uniStr = "III"; break;
            case 4: uniStr = "IV"; break;
            case 5: uniStr = "V"; break;
            case 6: uniStr = "VI"; break;
            case 7: uniStr = "VII"; break;
            case 8: uniStr = "VIII"; break;
            case 9: uniStr = "IX"; break;
        }
        switch (dec) {
            case 0: decStr = ""; break;
            case 1: decStr = "X"; break;
            case 2: decStr = "XX"; break;
            case 3: decStr = "XXX"; break;
            case 4: decStr = "XL"; break;
            case 5: decStr = "L"; break;
            case 6: decStr = "LX"; break;
            case 7: decStr = "LXX"; break;
            case 8: decStr = "LXXX"; break;
            case 9: decStr = "XC"; break;
        }
        switch (cen) {
            case 0: cenStr = ""; break;
            case 1: cenStr = "C"; break;
            case 2: cenStr = "CC"; break;
            case 3: cenStr = "CCC"; break;
            case 4: cenStr = "CD"; break;
            case 5: cenStr = "D"; break;
            case 6: cenStr = "DC"; break;
            case 7: cenStr = "DCC"; break;
            case 8: cenStr = "DCCC"; break;
            case 9: cenStr = "CM"; break;
        }
        switch (mil) {
            case 0: milStr = ""; break;
            case 1: milStr = "M"; break;
            case 2: milStr = "MM"; break;
            case 3: milStr = "MMM"; break;
        }

        return milStr + cenStr + decStr + uniStr;
    }
}
