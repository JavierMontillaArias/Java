import java.util.Scanner;

class Vuelo {
    String numeroDeVuelo;
    String origen;
    String destino;
    int asientosDisponibles;
    //Constructor
    Vuelo(String numeroDeVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroDeVuelo=numeroDeVuelo;
        this.origen=origen;
        this.destino=destino;
        this.asientosDisponibles=asientosDisponibles;
    }
    //Este programa resta a los asientos disponibles 1, si no es posible te dirá que no es posible.
    public boolean reservarAsiento() {
        Scanner teclado = new Scanner(System.in);
        String eleccion;
        if(this.asientosDisponibles>0) {
            System.out.println("Hay "+this.asientosDisponibles+" asientos disponibles");
            System.out.println("¿Vas a realizar una reserva? (SI/NO)");
            eleccion=teclado.nextLine();
            if (eleccion.equals("SI")) {
                this.asientosDisponibles--;
            }
            return true;
        }
        else {
            System.out.print("No hay asientos disponibles. ");
            return false;
        }
    }
    //Muestra por pantalla toda la información
    public void mostrarInformacionVuelo() {
        System.out.println("Numero de vuelo: "+this.numeroDeVuelo);
        System.out.println("Origen: "+this.origen);
        System.out.println("Destino: "+this.destino);
        System.out.println("Asientos disponibles: "+(this.asientosDisponibles));
    }
}
class Reserva {
    String nombrePasajero;
    String numeroPasaporte;
    Vuelo v1;
    Vuelo v2;
    //Constructor
    Reserva() {
        this.nombrePasajero="";
        this.numeroPasaporte="";
        //Creacion de vuelos
        v1 = new Vuelo("PNR1234","Malaga", "Nueva York",45);
        v2 = new Vuelo("PNR4896","Malaga", "Paris",0);
    }
    //Meter información del pasajero
    public void informacionPasajero () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        this.nombrePasajero=sc.nextLine();
        System.out.print("Pasaporte: ");
        this.numeroPasaporte=sc.nextLine();
        sc.close();
    }
    //Mostrar informacion del pasajero y su vuelo
    public void mostrarInformacionReserva() {
        System.out.println("Nombre: "+this.nombrePasajero);
        System.out.println("Pasaporte: "+this.numeroPasaporte);
    }
    //Menu para que el usuario escoja entre los dos vuelos
    public void menu() {
        Scanner tec = new Scanner (System.in);
        int num;
        System.out.println("--------------------------------------------------------------------------------");
        v1.mostrarInformacionVuelo();
        System.out.println("--------------------------------------------------------------------------------");
        v2.mostrarInformacionVuelo();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Introduce el vuelo que quieres escoger: (1) Malaga-Nueva York, (2) Malaga-Paris: ");
        num=tec.nextInt();
        switch(num) {
            case 1:
                if(v1.reservarAsiento()) {
                    System.out.println("--------------------------------------------------------------------------------");
                    //Aqui metes la informacion del pasajero
                    this.informacionPasajero();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("Datos despues de la reserva: ");
                    this.mostrarInformacionReserva();
                    v1.mostrarInformacionVuelo();
                    System.out.println("--------------------------------------------------------------------------------");
                }
                else {
                    System.out.print("Intente otro vuelo");
                    menu();
                }
                break;
            case 2:
                if(v2.reservarAsiento()) {
                    System.out.println("--------------------------------------------------------------------------------");
                    this.informacionPasajero();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("Datos: ");
                    this.mostrarInformacionReserva();
                    v2.mostrarInformacionVuelo();
                    System.out.println("--------------------------------------------------------------------------------");
                }
                else {
                    System.out.println("Intente otro vuelo");
                    menu();
                }
                break;
        }
        tec.close();
    }
}
public class Montilla_Arias_Javier {
    public static void main(String[] args) {
        Reserva reserva = new Reserva();
        reserva.menu();
    }
}
