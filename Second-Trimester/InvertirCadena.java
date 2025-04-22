import java.util.Scanner;
import java.util.Stack;

public class InvertirCadena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();
        System.out.print("Dame una expresión: ");
        String frase = sc.nextLine();
        for(int i = 0; i < frase.length(); i++){
            pila.push(frase.charAt(frase.length() - 1 - i));
        }

        for (Character character : pila) {
            System.out.print(character);
        }

        sc.close();
    }
}
