public class OperadoresBits {
    public static void main(String[] args) {
        int a = 5; // 0101 en binario
        int b = 3; // 0011 en binario

        System.out.println("Operador ~:");
        System.out.println("~a = " + ~a);

        System.out.println("Operador &:");
        System.out.println("a & b = " + (a & b));

        System.out.println("Operador |:");
        System.out.println("a | b = " + (a | b));

        System.out.println("Operador ^:");
        System.out.println("a ^ b = " + (a ^ b));

        System.out.println("Operador <<:");
        System.out.println("a << 1 = " + (a << 1));

        System.out.println("Operador >>:");
        System.out.println("a >> 1 = " + (a >> 1));

        System.out.println("Operador >>>:");
        System.out.println("a >>> 1 = " + (a >>> 1));
    }
}