import java.util.ArrayList;
import java.util.Scanner;

public class ListaTareas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        while(true){
            System.out.print("Agregar, eliminar, mostrar lista o salir: ");
            String opcion = sc.nextLine().toLowerCase();
            switch (opcion) {
                case "agregar":
                    System.out.print("Introduce la tarea: ");
                    String g = sc.nextLine();
                    lista.add(g);
                    break;
                case "eliminar":
                    System.out.println("Lista de tareas: ");
                    for(String tarea : lista){
                        System.out.println("- " + tarea);
                    }
                    System.out.print("Introduce la tarea que quieres eliminar: ");
                    String e = sc.nextLine();
                    lista.remove(e);
                    break;
                case "mostrar lista":
                    System.out.println("Lista de tareas: ");
                    for(String tarea : lista){
                        System.out.println("- " + tarea);
                    }
                    break;
                case "salir":
                    System.out.println("Graciaaaaaas");
                    sc.close();
                    return;
                default:
                System.out.println("No es ninguna de las opciones");
                    break;
            }
        }
    }
}
