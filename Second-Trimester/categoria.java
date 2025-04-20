import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class categoria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<String>> mapa = new HashMap<>();
        while (true) {
            System.out.print("Introduce la categoría (si quieres salir escribe salir): ");
            String categoria = sc.nextLine().toLowerCase();
            if(categoria.equals("salir")){
                break;
            }
            System.out.print("Introduce los productos de la categoría " + categoria + ": ");
            String producto = sc.nextLine();
            if (!mapa.containsKey(categoria)) {
                mapa.put(categoria, new ArrayList<>());
            }
            mapa.get(categoria).add(producto);
        }
        System.out.println("Graciaaaaas por usar el menú");
        System.out.println("-------------------------------------------------------------");
        System.out.println("La lista: ");
        for(Map.Entry<String, ArrayList<String>> dict : mapa.entrySet()){
            System.out.println(dict.getKey() + " -> " + dict.getValue());
        }
        sc.close();
    }
}
