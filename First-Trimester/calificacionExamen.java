import java.util.Scanner;

class Examen {
    String nombre;
    double puntuacion, puntuacionmaxima;
    Examen(String nombre, double punt) {
        this.nombre=nombre;
        this.puntuacion=punt;
        this.puntuacionmaxima=100;
    }
    //Imprime por pantalla el comentario segun la nota
    public void calcularNota() {
        this.puntuacion*=10;
        System.out.println("Su nota es: "+this.puntuacion);
        if(this.puntuacion>=90) {
            System.out.println("Aprobado con excelencia");
        }
        else if(this.puntuacion>=70 & this.puntuacion<90) {
            System.out.println("Aprobado");
        }
        else {
            System.out.println("Suspenso");
        }
    }
}
public class calificacionExamen {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double nota;
        String nombre;
        System.out.print("Introduce el nombre del alumno: ");
        nombre=sc.nextLine();
        System.out.print("Introduce su nota del 1 al 10: ");
        nota=sc.nextInt();
        Examen ex = new Examen(nombre, nota);
        ex.calcularNota();
        sc.close();
    }
}