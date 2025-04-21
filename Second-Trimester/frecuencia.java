import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class frecuencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> mapa = new HashMap<>();
        System.out.print("Introduce la frase: ");
        String frase = sc.nextLine().toLowerCase();
        for (String palabra : frase.split(" ")) {
            if(!mapa.containsKey(palabra)){
                mapa.put(palabra, 1);
            } else {
                mapa.put(palabra, mapa.get(palabra) + 1);
            }
        }
        for (Map.Entry<String, Integer> dict : mapa.entrySet()) {
            System.out.println("Palabra: " + dict.getKey() + " | Cantidad de veces repetida: " + dict.getValue());
        }
        sc.close();
    }
}