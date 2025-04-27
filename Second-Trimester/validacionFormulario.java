import java.util.Scanner;

public class validacionFormulario {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Dame el nombre completo: ");
        String nombre = teclado.nextLine();
        if (isNombre(nombre)) {
            System.out.println("Formato correcto");
        }else{
            System.out.println("Formato incorrecto");
        }

        System.out.print("Dame tu fecha de nacimiento (dd/mm/aaaa): ");
        String fecha = teclado.nextLine();
        if (isFecha(fecha)) {
            System.out.println("Formato correcto");
        }else{
            System.out.println("Formato incorrecto");
        }

        System.out.print("Dame tu email: ");
        String email = teclado.nextLine();
        if (isEmail(email)) {
            System.out.println("Formato correcto");
        }else{
            System.out.println("Formato incorrecto");
        }

        System.out.print("Dame tu dni: ");
        String dni = teclado.nextLine();
        if (isDni(dni)) {
            System.out.println("Formato correcto");
        }else{
            System.out.println("Formato incorrecto");
        }

        



        teclado.close();
    }
    public static boolean isNombre (String nombre){
        
        boolean ok = false;
        String patron = "([A-Z]{1}[a-z]+) ([A-Z]{1}[a-z]+) ([A-Z]{1}[a-z]+)";

        if (nombre.matches(patron)) {
            ok = true;
        }
        
        return ok;
    }

    public static boolean isFecha (String fecha){
        boolean ok = false;
        String patron = "(3[01]|[012][0-9])/(1[0-2]|0[1-9])/(20[0-9]{2}|19[0-9]{2})";

        if (fecha.matches(patron)) {
            ok = true;
        }
        return ok;
    }

    public static boolean isEmail(String email){
        boolean ok = false;
        String patron = "[a-z]{1}[a-z0-9]{5,}@[a-z0-9.-_]{3,}.[a-z]{2,}";

        if (email.matches(patron)) {
            ok = true;
        }
        return ok;
    }

    public static boolean isDni (String dni){
        boolean ok = false;
        String patron = "[0-9]{8}[A-Z]{1}";

        if (dni.matches(patron)) {
            ok = true;
        }
        return ok;
    }
}