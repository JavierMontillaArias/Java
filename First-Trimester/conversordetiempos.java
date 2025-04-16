import java.util.Scanner;

public class conversordetiempos {
    public static int horasMinutos (int horas)
    {
        return horas*60*7*24;
    }
    public static int diasHoras (int dias)
    {
        return dias*24*7;
    }
    public static int semanasDias (int semanas)
    {
        return semanas*7;
    }
    public static void main(String[] args) {
        int semana, tiempo;
        Scanner sc = new Scanner (System.in);
        System.out.print("Teniendo una semana a que quieres que lo pase a dias(1), horas(2) y minutos(3): ");
        semana=sc.nextInt();
        System.out.println("¿Cuantas semanas tienes?");
        tiempo=sc.nextInt();
        switch (semana) {
            case 1:
                System.out.println(+semana+" semanas son "+semanasDias(semana)+" dias");
                break;
            case 2:
                System.out.println(+semana+" semanas son "+diasHoras(semana)+" horas");
                break;
            case 3:
                System.out.println(+semana+" semanas son "+horasMinutos(semana)+" minutos");
                break;
            default:
                System.out.println("No es ninguna de las opciones");
                break;
        }
        System.out.println(+semana+" semanas son "+semanasDias(semana)+" dias que son "+diasHoras(semana)+" horas que son "+horasMinutos(semana)+" minutos");
        sc.close();
    }
}