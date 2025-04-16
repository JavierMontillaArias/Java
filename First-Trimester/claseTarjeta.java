import java.util.Scanner;

class Tarjeta {
    String id;
    String propietario;
    boolean activa;
    int nivelAcceso;
    //Constructor
    Tarjeta(String id, String prop, int level) {
        this.id=id;
        this.propietario=prop;
        this.activa=false;
        this.nivelAcceso=level;
    }
    //Hace que la tarjeta active el circuito
    public boolean activar() {
        return this.activa=true;
    }
    //Una vez ya usada la tarjeta el circuito lo desactivará
    public boolean desactivar() {
        return this.activa=false;
    }
    //Verifica cómo está el circuito
    public void verificarAcceso() {
        if(this.activa==true) {
            System.out.println("La tarjeta esta activa");
        }
        else {
            System.out.println("La tarjeta esta desactivada");
        }
    }
}

class Puerta {
    private String ubicacion;
    private boolean abierta;
    private int nivelRequerido;
    //Constructor
    Puerta() {
        this.ubicacion="";
        this.abierta=false;
        this.nivelRequerido=0;
    }

    public void abrir(Tarjeta t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual es su nivel?");
        this.nivelRequerido=sc.nextInt();
        if(t.nivelAcceso==this.nivelRequerido) {
            t.activar();
            t.verificarAcceso();
            this.abierta=true;
            System.out.println("Puerta abierta, asegurese de cerrar");
        }
        else {
            t.desactivar();
            t.verificarAcceso();
            this.abierta=false;
            System.out.println("Incorrecto, no tienes permiso");
        }
        sc.close();
    }

    public boolean cerrar () {
        return this.abierta=false;
    }
}

public class claseTarjeta {
    public static void main(String[] args) {
        Tarjeta per1 = new Tarjeta("1234", "Mario", 3);
        Puerta p = new Puerta();
        p.abrir(per1);
    }
}
