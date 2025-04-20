import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Contacto{
    String nombre, email, telefono;

    Contacto(String nombre, String email, String telefono){
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Setters
    public void setEmail(String email) {this.email = email;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    // Getters
    public String getEmail() {return email;}
    public String getNombre() {return nombre;}
    public String getTelefono() {return telefono;}

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Email: " + this.email + ", Teléfono: " + this.telefono;
    }

}
public class Agenda {
    public static boolean isEmail(String email){
        boolean ok = false;
        String patron = "[a-z]{1}[a-z0-9]{5,}@[a-z0-9.-_]{3,}.[a-z]{2,}";

        if (email.matches(patron)) {
            ok = true;
        }
        return ok;
    }
    public static boolean isPhone(String phone) {
        if (phone.matches("[0-9]{9}")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Contacto>> mapa = new HashMap<>();
        boolean salir = false;
        do{
            System.out.print("Introduce la categoría del contacto o escribe salir para salir: ");
            String categoria = sc.nextLine();
            boolean encontrado = false;
            if(categoria.equals("salir")){
                salir = true;
                break;
            }
            if(!mapa.containsKey(categoria)){
                mapa.put(categoria, new ArrayList<>());
            }
            System.out.print("Introduce el nombre del contacto: ");
            String nombre = sc.nextLine();

            for(Contacto c : mapa.get(categoria)){
                if(c.getNombre().equals(nombre)){
                    encontrado = true;
                    System.out.println("Encontré el contacto.");
                    System.out.println("Email: " + c.getEmail());
                    System.out.println("Telefono: " + c.getTelefono());
                }
            }
            if (!encontrado) {
                System.out.println("El contacto es nuevo.");
                
                String email;
                do {
                    System.out.print("Introduce el email: ");
                    email = sc.nextLine().trim();
                    if (!isEmail(email)) {
                        System.out.println("Formato incorrecto, vuelve a intentarlo.");
                    }
                } while (!isEmail(email));

                String telefono;
                do {
                    System.out.print("Introduce el número de teléfono (9 dígitos): ");
                    telefono = sc.nextLine().trim();
                    if (!isPhone(telefono)) {
                        System.out.println("Número incorrecto, debe contener exactamente 9 dígitos.");
                    }
                } while (!isPhone(telefono));

                Contacto persona = new Contacto(nombre, email, telefono);
                mapa.get(categoria).add(persona);
                System.out.println("Contacto agregado correctamente.");
            }
        }while(!salir);

        // Mostrar Agenda
        System.out.println("\nAgenda final:");
        System.out.println("-----------------------------------------");
        for (String categoria : mapa.keySet()) {
            System.out.println("Categoría: " + categoria);
            for (Contacto c : mapa.get(categoria)) {
                System.out.println(c);  
            }
            System.out.println("-----------------------------------------");
        }
        sc.close();
    }
}