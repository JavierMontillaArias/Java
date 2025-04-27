import java.util.Scanner;

public class pedirUsuario {

    //Comprueba si el nombre sigue el patrón

    public static boolean comprobarNombre (String nombre){
        String patron = "([A-Z]{1}[a-z]+) ([A-Z]{1}[a-z]+) ([A-Z]{1}[a-z]+)";
        if (nombre.matches(patron)) {
            return true;
        }
        return false;
    }

    //Comprueba si la fecha de nacimiento sigue el patrón

    public static boolean comprobarFecha (String fecha){
        String patron = "(3[01]|[012][0-9])/(1[0-2]|0[1-9])/(20[0-9]{2}|19[0-9]{2})";
        if (fecha.matches(patron)) {
            return true;
        }
        return false;
    }

    //Comprueba si el email sigue el patrón

    public static boolean comprobarEmail (String email){
        String patron = "([a-z]{1}[a-z0-9.]{5,})@([a-z0-9._-]+{3,}).[a-z]{2,}";
        if (email.matches(patron)) {
            return true;
        }
        return false;
    }

    //Comprueba si el dni sigue el patrón

    public static boolean comprobarDNI (String dni){
        String patron = "([0-9]{8}[A-Z]{1})";
        if (dni.matches(patron)) {
            return true;
        }
        return false;
    }

    //Comprueba si todos los datos siguen sus patrones

    public static boolean comprobarCorrecto (String nombre, String fecha, String email, String dni){
        if(comprobarNombre(nombre)) {
            if(comprobarFecha(fecha)) {
                if(comprobarEmail(email)) {
                    if(comprobarDNI(dni)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu fecha de nacimiento: ");
        String fecha = sc.nextLine();

        System.out.print("Introduce tu email: ");
        String email = sc.nextLine();

        System.out.print("Introduce tu dni: ");
        String dni = sc.nextLine();

        boolean ok = comprobarCorrecto(nombre, fecha, email, dni);

        if(ok) {

            System.out.println("Toda la información es correcta");

        } else {

            System.out.println("La información no es correcta");
            
        }
        sc.close();
    }
}