import java.util.Scanner;

class ClaseLibro  {
    private String titulo;
    private String autor;
    private int numeroEjemplares;
    private int ejemplaresPrestados;
    //Inicializar
    ClaseLibro() {
        titulo="";
        autor="";
        numeroEjemplares=0;
        ejemplaresPrestados=0;
    }
    //Setters
    public void setTitulo(String tit) {this.titulo=tit;}
    public void setAutor(String aut) {this.autor=aut;}
    public void setNumeroEjemplares(int num) {this.numeroEjemplares=num;}
    public void setEjemplaresPrestados(int ejem) {this.ejemplaresPrestados=ejem;}
    //Funciones
    public void prestamo(String titulo) {
        if(this.ejemplaresPrestados>=this.numeroEjemplares) {
            System.out.println("No hay libros para hacer el prestamo");
        }
        else {
            this.ejemplaresPrestados+=1;
            System.out.println("Quedan "+(this.numeroEjemplares-this.ejemplaresPrestados)+" ejemplares disponibles");
        }
    }
    public int devolucion (String titulo) {
        if(this.ejemplaresPrestados<0) {
            System.out.println("No hay prestamos para devolver");
        }
        else {
            this.ejemplaresPrestados-=1;
            System.out.println("Hay "+(this.ejemplaresPrestados)+" ejemplares prestados");
        }
        return this.ejemplaresPrestados;
    }
    public void mostrar (String titulo, String autor) {
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Autor: "+this.autor);
        System.out.println("Numero de Ejemplares: "+this.numeroEjemplares);
        System.out.println("Ejemplares prestados: "+this.ejemplaresPrestados);
        System.out.println("Disponibles: "+(this.numeroEjemplares-this.ejemplaresPrestados));
    }
    //Menu
    public void menu() {
        int eleccion;
        Scanner sc = new Scanner (System.in);
        System.out.print("Introduce que quieres hacer (1)Sacar un libro, (2)Devolver un libro, (3)Mostrar informacion o (4)Salir del menu: ");
        eleccion=sc.nextInt();
        sc.nextLine();
        //Opcion para salir del menu
        if(eleccion==4) {
            System.out.println("Gracias por ir a nuestra biblioteca!");
            System.exit(0);
        }
        //Se introduce el titulo
        System.out.println("Introduzca el titulo: ");
        this.titulo=sc.nextLine();
        System.out.println("Introduzca el autor: ");
        this.autor=sc.nextLine();
        switch (eleccion) {
            case 1:
            //Sacar un libro
                prestamo(this.titulo);
                break;
            case 2:
            //Devolver un libro
                devolucion(this.titulo);
                break;
            case 3:
            //Mostrar la informacion
                mostrar(this.titulo, this.autor);
                break;
            default:
                System.out.println("No es ninguna de las opcioines");
                break;
        }
        menu();
        sc.close();
    }
}
public class libro {
    public static void main(String[] args) {
        ClaseLibro l =new ClaseLibro();
        l.setTitulo("Don Quijote de la Mancha");
        l.setAutor("Miguel de Cervantes");
        l.setNumeroEjemplares(8);
        l.setEjemplaresPrestados(2);
        l.menu();
    }
}