import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ejemploString {
    public static void main(String[] args) {
        Pattern patron=Pattern.compile("[01]+"); // Creamos el patrón: objeto de tipo Pattern
        Matcher texto=patron.matcher("00001010"); // Creamos un caso de posible acoplamiento, encaje o matching: objeto de tipo Matcher
        if (texto.matches()) // Se produce "matching" o "acoplamiento"
        System.out.println("\nLa cadena encaja con el patrón.");
        else // No se produce "matching"
        System.out.println("\nLa cadena no encaja con el patrón.");

        //Ahora con string
        String patronStr = "[01]+";
        String textoStr = "10100011";
        if ( textoStr.matches(patronStr))
            System.out.println("\nLa cadena encaja con el patrón String");
        else 
            System.out.println("\nLa cadena no encaja con el patrón String");
    }
}