import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class encontrarFecha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto = "La historia de la empresa comenzó el 15/03/1985, cuando María Sánchez abrió su primera tienda en Valencia. El éxito fue inmediato y para el 22/07/1987 ya había inaugurado tres sucursales más. La expansión continuó durante los años noventa, y el 03/12/1998 la compañía celebró la apertura de su tienda número 50. El momento más significativo llegó el 18/04/2005 con la internacionalización del negocio. Hoy, tras la última apertura del 09/01/2025, la empresa cuenta con más de 200 establecimientos en 12 países y sigue creciendo.";
        // Suponemos que la variable "texto" contiene el texto que se desea analizar
        Pattern patron = Pattern.compile("(3[01]|[012][0-9])/(1[0-2]|0[1-9])/(20[0-9]{2}|19[0-9]{2})"); // Patrón de búsqueda
        Matcher acoplamiento = patron.matcher(texto); // Texto donde buscar o "acoplar"
        boolean patronEncontrado; // Si el patron ha sido encontrado
        int inicio=0;
        int fin = 0;
        int numVeces= 0; // Contador para saber cuántas veces aparece el patrón
        do {
            patronEncontrado = acoplamiento.find(); // Buscamos el patrón en el texto
            if ( patronEncontrado ) { // Si lo encontramos, lo contabilizamos, ubicamos y extraemos
                numVeces++;
                inicio= acoplamiento.start();
                fin= acoplamiento.end();
                System.out.printf ("%2d.- Patrón numérico encontrado. Ubicado entre las posiciones %d y %d: %s\n",
                numVeces, inicio, fin, texto.substring(inicio, fin));
            }
        } while (patronEncontrado);
        if (numVeces == 0) {
            System.out.println ("Patrón numérico entero no encontrado en el texto.");
        } else {
            System.out.printf ("Encontrado %d veces.", numVeces);
        }
        sc.close();
    }
}
