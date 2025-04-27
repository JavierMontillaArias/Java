import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NombreEdadMapa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la cantidad de personas que quieres registrar: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        HashMap <String, Integer> personas = new HashMap<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce el nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Introduce la edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            personas.put(nombre,edad);
        }
        System.out.println("");
        System.out.println("Personas: ");
        for (Map.Entry<String, Integer> persona : personas.entrySet()) {
            System.out.println("- " + persona.getKey() + " tiene " + persona.getValue() + " años");
        }
        sc.close();
    }
}
