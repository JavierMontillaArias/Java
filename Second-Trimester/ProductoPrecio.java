import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoPrecio {
    public static HashMap<String, Integer> rellenarMapa(HashMap<String, Integer> mapa, Scanner sc, int tamanio){
        for(int i = 0; i < tamanio; i++){
            System.out.print("Introduce el nombre del producto: ");
            String producto = sc.nextLine();
            if(!mapa.containsKey(producto)){
                System.out.print("Introduce el precio de " + producto + ": " );
                int precio = sc.nextInt();
                sc.nextLine();
                mapa.put(producto, precio);
            } else {
                System.out.println("Ese producto ya existe mete otro.");
                i--;
            }
            
        }
        return mapa;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> mapa = new HashMap<>();
        System.out.print("Introduce el número de productos que tienes: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        mapa=rellenarMapa(mapa, sc, cantidad);
        String productoMasCaro = "";
        int precioMasCaro = 0;
        for (Map.Entry<String, Integer> dict : mapa.entrySet()) {
            if (dict.getValue() > precioMasCaro) {
                productoMasCaro = dict.getKey();
                precioMasCaro = dict.getValue();
            }
        }
        System.out.println("\nEl producto más caro es: " + productoMasCaro + " con un precio de " + precioMasCaro);
        sc.close();
    }
}
