import java.util.Scanner;

class Programa {
    String nombre;
    int duracion;
    int temperatura;
    boolean centrifugado;
    //Constructor de la clase
    Programa() {
        this.nombre="";
        this.duracion=0;
        this.temperatura=0;
        this.centrifugado=false;
    }
    //Setters
    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setDuracion(int dur) { this.duracion = dur;}
    public void setTemperatura(int temp) { this.temperatura = temp;}
    public void setCentrifugado(boolean cent) { this.centrifugado = cent;}
    //Mostrar por pantalla
    public void mostrarPantalla() {
        System.out.println("Programa: "+this.nombre);
        System.out.println("Duracion: "+this.duracion);
        System.out.println("Temperatura: "+this.temperatura);
        System.out.println("Centrifugado: "+this.centrifugado);
    }
    //Iniciar
    public void iniciar (String nombre, int temp) {
        this.nombre=nombre;
        this.duracion=0;
        this.temperatura=temp;
        this.centrifugado=false;
    }
    //Pausar
    public int pausar () {
        return this.duracion;
    }
    //Cancelar
    public void cancelar () {
        this.nombre="";
        this.duracion=0;
        this.temperatura=0;
        this.centrifugado=false;
    }
}
class LavadoraPrograma {
    Programa programn;
    boolean encendida;
    boolean cerrarPuerta;
    //Constructor de la clase
    LavadoraPrograma () {
        this.programn=new Programa();
        this.encendida=false;
        this.cerrarPuerta=false;
    }
    //Abrir puerta
    public void abrirPuerta() {
        this.cerrarPuerta=false;
        System.out.println("Puerta abierta \nMeto la ropa");
    }
    //Cerrar puerta
    public void puertaCerrada() {
        this.cerrarPuerta=true;
        System.out.println("Puerta cerrada");
    }
    //Estos son los distintos programas
    public void eleccionPrograma () {
        Scanner sc = new Scanner (System.in);
        Programa p = new Programa();
        int eleccion;
        System.out.println("Escoge programa: ");
        System.out.println("(1)Rapido, (2)Normal, (3)Delicado, (4)Economico, (5)Antialergias");
        eleccion=sc.nextInt();
        switch (eleccion) {
            case 1:
                abrirPuerta();
                puertaCerrada();
                p.setNombre("Rapido");
                p.setDuracion(30);
                p.setTemperatura(40);
                p.setCentrifugado(true);
                p.mostrarPantalla();
                break;
            case 2:
                abrirPuerta();
                puertaCerrada();
                p.setNombre("Normal");
                p.setDuracion(120);
                p.setTemperatura(60);
                p.setCentrifugado(true);
                p.mostrarPantalla();
                break;
            case 3:
                abrirPuerta();
                puertaCerrada();
                p.setNombre("Delicado");
                p.setDuracion(60);
                p.setTemperatura(40);
                p.setCentrifugado(true);
                p.mostrarPantalla();
                break;
            case 4:
                abrirPuerta();
                puertaCerrada();
                p.setNombre("Economico");
                p.setDuracion(120);
                p.setTemperatura(40);
                p.setCentrifugado(true);
                p.mostrarPantalla();
                break;
            case 5:
                abrirPuerta();
                puertaCerrada();
                p.setNombre("Antialergias");
                p.setDuracion(120);
                p.setTemperatura(90);
                p.setCentrifugado(true);
                p.mostrarPantalla();
                break;
            default:
                System.out.println("No es ninguna de las opciones");
                eleccionPrograma();
                break;
        }
        sc.close();
    }
}
public class lavadora {
    public static void main(String[] args) {
        LavadoraPrograma l = new LavadoraPrograma();
        l.eleccionPrograma();
    }
}
