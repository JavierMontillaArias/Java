import java.util.Scanner;

class Vuelo {
    String numeroVuelo, origen, destino;
    int asientosDisponibles;
    //Constructor
    Vuelo(String numeroVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroVuelo=numeroVuelo;
        this.origen=origen;
        this.destino=destino;
        this.asientosDisponibles=asientosDisponibles;
    }
    //Reservar asientos quita uno de asientos disponibles
    public boolean reservarAsiento() {
        if(this.asientosDisponibles>0){
            this.asientosDisponibles--;
            return true;
        }
        return false;
    }
    //Imprime por pantalla la informacion del vuelo
    public void mostrarInformacionVuelo() {
        System.out.println("Numero vuelo: "+this.numeroVuelo);
        System.out.println("Origen: "+this.origen);
        System.out.println("Destino: "+this.destino);
        System.out.println("Asientos disponible: "+this.asientosDisponibles);
    }
}
class Reserva {
    String nombrePasajero, numeroPasaporte;
    Vuelo v;
    //Constructor
    Reserva(String nombrePasajero, String numeroPasaporte, Vuelo v) {
        this.nombrePasajero=nombrePasajero;
        this.numeroPasaporte=numeroPasaporte;
        this.v=v;
    }
    //Imprimir por pantalla los datos de la reserva
    public void mostrarInformacionReserva() {
        System.out.println("Nombre pasajero: "+this.nombrePasajero);
        System.out.println("Pasaporte: "+this.numeroPasaporte);
        v.mostrarInformacionVuelo();
    }
}
public class CitasVuelos {
    public static void main(String[] args) {
        Vuelo v1 = new Vuelo("ABC1234", "Malaga", "Antequera", 45);
        Vuelo v2 = new Vuelo("XYZ9876", "Dubai", "Pionyang", 0);
        Scanner sc = new Scanner(System.in);
        int eleccion;
        String nombre, pasaporte;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Vuelo 1: ");
        v1.mostrarInformacionVuelo();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Vuelo 2: ");
        v2.mostrarInformacionVuelo();
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Introduce que vuelo quieres (1 o 2): ");
        eleccion=sc.nextInt();
        sc.nextLine();
        switch (eleccion) {
            case 1:
                if(v1.reservarAsiento()) {
                    System.out.print("Introduzca su nombre: ");
                    nombre=sc.nextLine();
                    System.out.print("Introduzca su pasaporte: ");
                    pasaporte=sc.nextLine();
                    System.out.println("-------------------------------------------------------------------------");
                    Reserva res1 = new Reserva(nombre, pasaporte, v1);
                    res1.mostrarInformacionReserva();
                }
                else {
                    System.out.println("No hay asientos disponibles");
                } 
                break;
            case 2:
                if(v2.reservarAsiento()) {
                System.out.print("Introduzca su nombre: ");
                nombre=sc.nextLine();
                System.out.print("Introduzca su pasaporte: ");
                pasaporte=sc.nextLine();
                System.out.println("-------------------------------------------------------------------------");
                Reserva res2 = new Reserva(nombre, pasaporte, v2);
                res2.mostrarInformacionReserva();
            }
            else {
                System.out.println("No hay asientos disponibles");
            } 
                break;
            default:
            System.out.println("No es ninguna de las opciones");
                break;
        }
        sc.close();
    }
}
