import java.util.Scanner;
class Ascensor {
    private int pisoActual, pisoMaximo;
    private boolean enMovimiento, puertaAbierta;
    //Constructor de la clase
    Ascensor(int piso) {
        this.pisoMaximo=piso;
        this.pisoActual=0;
        this.enMovimiento=false;
        this.puertaAbierta=false;
    }
    //Funciones
    //Verificar estado
    public void verificarEstado () {
      System.out.println("Piso actual: "+this.pisoActual);
      System.out.println("Piso maximo: "+this.pisoMaximo);
      System.out.println("Movimiento: "+this.enMovimiento);
      System.out.println("Puerta Abierta: "+this.puertaAbierta);
    }
    //Emergencia
    public void emergencia () {
       subirBajarPiso(0);
       System.out.println("Ascensor averiado");
    }
    //Subir o bajar en el ascensor
    public void subirBajarPiso (int piso) {
        if(piso>this.pisoMaximo) {
            System.out.println("No se puede el piso mas alto es el "+this.pisoMaximo);
        }
        if(this.puertaAbierta==false){
            if(this.pisoActual>piso){
                this.enMovimiento=true;
                for (int i=this.pisoActual; i>=piso; i--) {
                    System.out.println("Piso: "+i);
                }
                verificarEstado();
                this.enMovimiento=false;
                this.puertaAbierta=true;
                verificarEstado();
            }
            else {
                this.enMovimiento=true;
                for (int i=this.pisoActual; i<=piso;i++) {
                    System.out.println("Piso: "+i);
                }
            }
        }
        else {
            System.out.println("No se puede el ascensor está en movimiento");
        }
    }
        
    //Abrir o cerrar puerta
    public void abrirCerrarPuerta (boolean abrir) {
        if(abrir==true) {
            System.out.println("Puerta abierta");
        }
        else {
            System.out.println("Puerta cerrada");
        }
    }
    //Test
    public void test() {
        Scanner sc = new Scanner (System.in);
        int piso;
        //Comprobaciones para ver si el ascensor se puede mover
        if(this.puertaAbierta==true | this.enMovimiento==true) {
            System.out.println("No se puede usar el ascensor");
        }
        else {
            abrirCerrarPuerta(true);
            abrirCerrarPuerta(false);
            System.out.println("¿A que piso quiere ir?");
            piso=sc.nextInt();
            System.out.println("¿En que piso esta?");
            this.pisoActual=sc.nextInt();
            subirBajarPiso(piso);
            abrirCerrarPuerta(true);
            abrirCerrarPuerta(false);
        }
        sc.close();
    }
}
public class claseAscensor {
    public static void main(String[] args) {
        Ascensor asc = new Ascensor(12);
        asc.test();
    }
}