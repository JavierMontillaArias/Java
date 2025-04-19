import java.util.Scanner;

class Llamada {
    String nombre, tipo_mascota;
    int edad;
    //Constructor
    Llamada(String nombre, String tipo, int edad) {
        this.nombre=nombre;
        this.tipo_mascota=tipo;
        this.edad=edad;
    }
    //Calcula las edades dependiendo la mascota
    public int calcularEdadHumana(int elec) {
        switch (elec) {
            case 1:
                this.edad*=7;
                this.tipo_mascota="perro";
                break;
            case 2:
                this.edad*=5;
                this.tipo_mascota="gato";
                break;
            case 3:
                this.edad*=4;
                this.tipo_mascota="ave";
                break;
        
            default:
            System.out.println("ninguna de las opciones");
                break;
        }
        return this.edad;
    }
    public void mostrarDetalles() {
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Tipo: "+this.tipo_mascota);
        System.out.println("Edad: "+this.edad);
    }
}
public class registroMascota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre, aux="";
        int edad, mascota;
        System.out.print("Introduce el nombre: ");
        nombre=sc.nextLine();
        System.out.print("Introduce el tipo de mascota (perro (1)/gato (2)/ave (3)): ");
        mascota=sc.nextInt();
        switch (mascota) {
            case 1:
                aux="perro";
                break;
            case 2:
                aux="gato";
                break;
            case 3:
                aux="ave";
                break;
            default:
                break;
        }
        System.out.print("Introduce la edad: ");
        edad=sc.nextInt();
        Llamada call = new Llamada(nombre, aux, edad);
        call.calcularEdadHumana(mascota);
        call.mostrarDetalles();
        sc.close();
    }
}
