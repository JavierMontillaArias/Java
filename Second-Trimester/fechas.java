import java.util.Scanner;

public class fechas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame una fecha (dd/mm/aaaa): ");
        String fecha = sc.nextLine();
        String patron = "(3[01]|[012][0-9])/(1[0-2]|0[1-9])/(20[0-9]{2}|19[0-9]{2})";
        if(fecha.matches(patron)) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato NO es correcto");
        }
        
        sc.close();
    }
}
