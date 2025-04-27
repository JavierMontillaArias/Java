import java.util.HashSet;
import java.util.Scanner;

public class PalabrasUnicasEnFrase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet <String> conjunto = new HashSet<>();
        System.out.print("Mete una frase niño: ");
        String frase = sc.nextLine();
        String [] palabras = frase.split(" ");
        for(String palabra : palabras){
            conjunto.add(palabra);
        }
        System.out.println("Hay " + conjunto.size() + " de palabras diferentes");
        sc.close();
    }
}
