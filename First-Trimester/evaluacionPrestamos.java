import java.util.Scanner;

class Prestamo {
    private String nombre;
    private int ingreso_mensual;
    private float monto_solicitado;
    private int tiempo;
    //Constructor
    Prestamo(String nombre, int ingreso, float monto, int tiempo) {
        this.nombre=nombre;
        this.ingreso_mensual=ingreso;
        this.monto_solicitado=monto;
        this.tiempo=tiempo;
    }
    //Voy a crear un bool que me devuelva si el préstamo es válido
    public boolean evaluarSolicitud() {
        if(this.monto_solicitado<=(this.ingreso_mensual*10) & (this.ingreso_mensual>2000) & (this.tiempo<5)) {
            System.out.println("Préstamo valido");
            return true;
        }
        else {
            System.out.println("Préstamo no valido");
            return false;
        }
    }
    //Una vez aprobado la solicitud calculará el interes
    public void calcularCuotaMensual(int interes) {
       System.out.println("La cuota mensual será: "+(this.monto_solicitado+(this.monto_solicitado*(interes/100)*(this.tiempo/12)))/this.tiempo);
    }
}
public class evaluacionPrestamos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int interes, tiempo, ingreso;
        String nombre;
        float monto;
        System.out.print("Introduzca su nombre: ");
        nombre=sc.nextLine();
        System.out.print("Introduzca su ingreso mensual: ");
        ingreso=sc.nextInt();
        System.out.print("Introduzca su monto que quiera solicitar: ");
        monto=sc.nextFloat();
        System.out.print("Introduzca el tiempo que estara pagando el préstamo: ");
       tiempo=sc.nextInt();
       Prestamo ps = new Prestamo(nombre, ingreso, monto, tiempo);
        if(ps.evaluarSolicitud()) {
            System.out.print("Introduzca el interes: ");
            interes=sc.nextInt();
            ps.calcularCuotaMensual(interes);
        }
        sc.close();
    }
}