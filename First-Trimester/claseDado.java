import java.util.Random;
import java.util.Scanner;

class Dado {
    private int numeroCaras;
    private int actual;
    private int ultimoValor;

    //Inicializo a cero
    Dado() {
        this.numeroCaras=0;
        this.actual=0;
        this.ultimoValor=0;
    }

    //Setters
    public void setNumeroCaras (int numCara) {this.numeroCaras=numCara;}
    public void setActual (int act) {this.actual=act;}
    public void setUltimoValor (int ultVal) {this.ultimoValor=ultVal;}

    //Lanzar dado
    public int lanzarDado () {
        Random rand = new Random();
        this.numeroCaras=rand.nextInt(this.numeroCaras);
        return this.numeroCaras+1;
    }

    //Obtener valor actual
    public int valorActual () {
        return this.actual=this.lanzarDado();
    }

    //Comprobar si es par
    public boolean esPar () {
        if(this.actual%2==0) {
            return true;
        }
        return false;
    }

    //Resetear
    public void reset () {
        this.actual=0;
        this.numeroCaras=0;
        this.ultimoValor=0;
    }
}
public class claseDado {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        int caras, tirada1, tirada2;
        System.out.println("¿Cuantas caras tiene el dado?");
        caras=sc.nextInt();
        dado1.setNumeroCaras(caras);
        dado2.setNumeroCaras(caras);
        tirada1=dado1.valorActual();
        System.out.print("Tirada 1: "+tirada1);
        if(dado1.esPar()) {
            System.out.print(". ES PAR");
        }
        else {
            System.out.print(". ES IMPAR");
        }
        tirada2=dado2.valorActual();
        System.out.print("\nTirada 2: "+tirada2);
        if(dado2.esPar()) {
            System.out.print(". ES PAR");
        }
        else {
            System.out.print(". ES IMPAR");
        }
        if (tirada1>tirada2) {
            System.out.println("\nGano el jugador 1.");
        }
        else {
            System.out.println("\nGano el jugador 2.");
        }
        sc.close();
    }
}
