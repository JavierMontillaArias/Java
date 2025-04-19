import java.util.Random;
import java.util.Scanner;

public class juegoPiedraPapelTijeras {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        int numUsuario, numCompu = random.nextInt(1, 3);

        System.out.println("Dime qué elijes (1->piedra / 2->papel / 3->tijeras)");
        numUsuario = teclado.nextInt();


        
        if (numUsuario == numCompu)
            System.out.println("Los dos hemos elegido lo mismo , HEMOS EMPATADO");
        else {
            switch (numUsuario) {
                case 1:
                    if (numCompu == 2)
                        System.out.println("Yo tengo papel que gana a piedra");
                    else
                        System.out.println("Yo tengo tijeras que pierde con piedra");
                    break;
                case 2:
                    if (numCompu == 1)
                        System.out.println("Yo tengo piedra que pierde con papel");
                    else
                        System.out.println("Yo tengo tijeras que gana a papel");
                    break;

                case 3:
                    if (numCompu == 1)
                        System.out.println("Yo tengo piedra que gana a tijeras");
                    else
                        System.out.println("Yo tengo papel que pierde con tijera");
                    break;
                default:
                    break;
            }
        }

    }
}
