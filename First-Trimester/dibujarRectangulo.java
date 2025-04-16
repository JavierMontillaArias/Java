import java.util.Scanner;
class Rectangulo {
    private double base;
    private double altura;
    //Inicializar a cero
    Rectangulo() {
        base=0.0;
        altura=0.0;
    }
    //Setters
    public void setBase(double b) {this.base=b;}
    public void setAltura(double a) {this.altura=a;}
    //Funciones
    public double area(double b, double h) {
        setBase(b);
        setAltura(h);
        return this.base*this.altura;
    }
    public double perimetro(double b, double h) {
        setBase(b);
        setAltura(h);
        return 2*this.altura+2*this.base;
    }
    public void dibujar (double b, double h) {
        setAltura(h);
        setBase(b);
        String rec="";
        for (int i=0; i< (int) this.altura; i++) {
            for (int j=0; j<(int) this.base; j++) {
                rec+="*";
            }
            System.out.println(rec);
            rec="";
        }
    }
    //Menu
    public void menu () {
        int eleccion;
        Scanner sc = new Scanner (System.in);
        System.out.print("Introduce que quieres calcular (1)Area, (2)Perimetro, (3)Dibujar o (4)Salir del menu: ");
        eleccion=sc.nextInt();
        //Opcion para salir del menu
        if(eleccion==4) {
            System.out.println("Gracias por usar el menu de Rectangulos!");
            System.exit(0);
        }
        System.out.print("Dame la base: ");
        this.base=sc.nextDouble();
        System.out.print("Dame la altura: ");
        this.altura=sc.nextDouble();
        //Comprobacion de que la base o la altura son positivas
        if(this.base<0 | this.altura<0) {
            System.out.println("La base o la altura es negativa");
            menu();
        }
        switch (eleccion) {
            case 1:
            //Calculo del area
                System.out.println("Area: "+this.base+ " * "+ this.altura+ " = "+area(this.base, this.altura)); 
                break;
            case 2:
            //Calculo del perimetro
                System.out.println("Perimetro: 2*"+this.base+ " + 2*"+ this.altura+ " = "+perimetro(this.base, this.altura)); 
                break;
            case 3:
            //Dibujar el rectangulo
                dibujar(this.base, this.altura);
                break;
            default:
            //En caso de que ponga ninguna de las opciones
                System.out.println("No es ninguna de las opciones");
                break;
        }
        //Volver a iniciar el menu
        menu();
        sc.close();
    }
}
public class dibujarRectangulo {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo();
        r.menu();
    }
}