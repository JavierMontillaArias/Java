import java.util.Scanner;

class Multa {
    private int velocidad_registrada, limite_velocidad;
    Multa(int vel, int lim){
        this.velocidad_registrada=vel;
        this.limite_velocidad=lim;
    }
    //Dependiendo de la diferencia se pagará distinto dinero
    public int calcularMulta() {
        int diferencia=this.velocidad_registrada-this.limite_velocidad;
        if(diferencia>1 & diferencia<=10) {
            return 50;
        } 
        else if(diferencia>11 & diferencia<=20) {
            return 100;
        } 
        else if (diferencia>20) {
            return 200;
        }
        return 0;
    }
    //Imprime por pantalla la multa
    public void mostrarMulta() {
        System.out.println("Velocidad limite: "+this.limite_velocidad);
        System.out.println("Velocidad registrada: "+this.velocidad_registrada);
        if(calcularMulta()==0) {
            System.out.println("No tienes multa");
        }
        else {
            System.out.println("La multa es de "+this.calcularMulta()+" euros");
        }
    }
}
public class multasTrafico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lim, vel;
        System.out.print("Introduce la velocidad limite: ");
        lim=sc.nextInt();
        System.out.print("Introduce la velocidad registrada: ");
        vel = sc.nextInt();
        Multa m = new Multa(vel, lim);
        m.mostrarMulta();
        sc.close();
    }
}
