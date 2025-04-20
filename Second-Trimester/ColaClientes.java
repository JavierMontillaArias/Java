import java.util.ArrayDeque;
import java.util.Scanner;

public class ColaClientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> clientes = new ArrayDeque<>();
        System.out.print("Introduce el número de clientes: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < cantidad; i++){
            System.out.print("Introduce el nombre del cliente: ");
            String nombre = sc.nextLine();
            clientes.add(nombre);
        }
        for (String cola : clientes) {
            System.out.println("Clientes sin atender: ");
            for (String nombre : clientes) {
                System.out.println(nombre);
            }
            clientes.remove(cola);
        }
        sc.close();
    }
}