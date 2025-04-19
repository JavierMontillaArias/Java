public class OperadoresLogicos {

    public static void main(String[] args) {
        System.out.println("EJEMPLOS DE USO DE OPERADORES LÓGICOS");
        System.out.println("-------------------------------------");
        System.out.println("Negacion:\n !false es : " + (!false));
        System.out.println(" !true es : " + (!true));
        System.out.println("Operador AND (&):");
        System.out.println(" false & false es : " + (false & false));
        System.out.println(" false & true es : " + (false & true));
        System.out.println(" true & false es : " + (true & false));
        System.out.println(" true & true es : " + (true & true));
        System.out.println("Operador OR (|):");
        System.out.println(" false | false es : " + (false | false));
        System.out.println(" false | true es : " + (false | true));
        System.out.println(" true | false es : " + (true | false));
        System.out.println(" true | true es : " + (true | true));
        System.out.println("Operador OR Exclusivo o XOR (^):");
        System.out.println(" false ^ false es : " + (false ^ false));
        System.out.println(" false ^ true es : " + (false ^ true));
        System.out.println(" true ^ false es : " + (true ^ false));
        System.out.println(" true ^ true es : " + (true ^ true));
        System.out.println("Operador AND (&&):");
        System.out.println(" false && false es : " + (false && false));
        System.out.println(" false && true es : " + (false && true));
        System.out.println(" true && false es : " + (true && false));
        System.out.println(" true && true es : " + (true && true));
        System.out.println("Operador OR (||):");
        System.out.println(" false || false es : " + (false || false));
        System.out.println(" false || true es : " + (false || true));
        System.out.println(" true || false es : " + (true || false));
        System.out.println(" true || true es : " + (true || true));
    }
}