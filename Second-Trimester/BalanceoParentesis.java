import java.util.Scanner;
import java.util.Stack;

public class BalanceoParentesis {
    public static boolean estaBalanceado(String frase){
        Stack<Character> pila = new Stack<>();

        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == '('){
                pila.push('(');
            }
            if(frase.charAt(i) == ')'){
                if(!pila.isEmpty()){
                    pila.pop();
                } else {
                    return false;
                }
            }
        }
        if(pila.isEmpty()){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame una expresión: ");
        String frase = sc.nextLine();

        if(estaBalanceado(frase)){
            System.out.print("La expresión está bien balanceada");
        } else {
            System.out.print("No está balanceada");
        }

        sc.close();
    }
}