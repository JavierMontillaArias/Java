import java.util.Scanner;
public class mayorDeTres {
    public static void main(String[] args) {
        int num1, num2, num3, numMayor;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        num1 = teclado.nextInt();
        System.out.print("Ingrese un número: ");
        num2 = teclado.nextInt();
        System.out.print("Ingrese un número: ");
        num3 = teclado.nextInt();
        numMayor = (num1 >= num2) ? num1 : num2;
        numMayor = (num3 >= numMayor) ? num3 : numMayor;
        System.out.print(numMayor + " es el número mayor");
        teclado.close();
    }
}