import java.util.Scanner;
public class conversorHoras {
    public static void main(String[] args) {
        int minutos;
        char pruralHoras, pruralMinutos;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca los minutos: ");
        minutos = teclado.nextInt(); 
        pruralHoras = ((minutos - minutos % 60) / 60) > 1 ? 's' : ' ';
        pruralMinutos = (minutos % 60) > 1 ? 's' : ' ';
        System.out.print( (minutos % 60 == 0) ? minutos + " minuto"+ pruralMinutos +" son " + (minutos / 60) + " hora" + pruralHoras
        : minutos + " minuto" + pruralMinutos + " son " + ((minutos - minutos % 60) / 60) + " hora" + pruralHoras + " y " + (minutos % 60) + " minuto" + pruralMinutos);
        teclado.close();
    }
}