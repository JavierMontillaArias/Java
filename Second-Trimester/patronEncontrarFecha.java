import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class patronEncontrarFecha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto = "La historia de la empresa comenzó el 15/03/1985, cuando María Sánchez abrió su primera tienda en Valencia. El éxito fue inmediato y para el 22/07/1987 ya había inaugurado tres sucursales más. La expansión continuó durante los años noventa, y el 03/12/1998 la compañía celebró la apertura de su tienda número 50. El momento más significativo llegó el 18/04/2005 con la internacionalización del negocio. Hoy, tras la última apertura del 09/01/2025, la empresa cuenta con más de 200 establecimientos en 12 países y sigue creciendo.";
        Pattern patron = Pattern.compile("(3[01]|[012][0-9])/(1[0-2]|0[1-9])/(20[0-9]{2}|19[0-9]{2})");
        Matcher acoplo = patron.matcher(texto);
        boolean estaEnElTexto;
        int inicio = 0;
        int fin = 0;
        int numVeces = 0;
        do {
            estaEnElTexto = acoplo.find();
            if(estaEnElTexto) {
                numVeces++;
                inicio = acoplo.start();
                fin = acoplo.end();
                System.out.printf("%2d - Patrón encontrado, ubicado en la posición %d y %d: %s\n", numVeces, inicio, fin, texto.substring(inicio, fin));
            } 
        }while (estaEnElTexto);

        if ( numVeces == 0) {
            System.out.println("Patrón no encontrado");
        } else {
            System.out.printf("Se ha encontrado %d veces", numVeces);
        }


        sc.close();
    }
}
