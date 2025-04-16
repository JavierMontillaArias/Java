import java.util.Random;
import java.util.Scanner;

class Factura {
    private String numeroFactura;
    private String fecha;
    private String concepto;
    private double base;
    private double IVA;
    //Inicializacion
    Factura() {
        numeroFactura="";
        fecha="";
        concepto="";
        base=0.0;
        IVA=0.0;
    }
    //Setters
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura;}
    public void setFecha(String fecha) { this.fecha = fecha;}
    public void setConcepto(String concepto) { this.concepto = concepto;}
    public void setBase(double base) {this.base=base;}
    public void setIVA(double IVA) { this.IVA=IVA;}
    
    @Override
    public String toString() {
        return "Numero Factura: " +numeroFactura+ "\nFecha: " +fecha+ "\nConcepto: " +concepto+ "\nBase: " +base+ "\nIVA: "+IVA;
    }
    //Calculo el precio de un producto con el IVA
    public double calcularIVA (double bass, double IVA) {
       setBase(bass);
       setIVA(IVA);
        return this.base + this.base*(this.IVA/100);
    }
    //Calculo el precio final con un descuento
    public double descuento (double bass, int descuento) {
        setBase(bass);
        return this.base-this.base*(descuento/100);
    }
    //Genero de forma random un numero de factura
    public String numeroFactura () {
        Random rand=new Random();
        int num=rand.nextInt(1,9999);
        return Integer.toString(num);
    }
    //Imprimir la factura
    public void Imprimir() {
        Scanner sc = new Scanner (System.in);
        String eleccion="";
        int descuento;
        System.out.println("¿Cual es el precio base (Sin IVA)?");
        this.base=sc.nextDouble();
        System.out.println("¿Cual es el porcentaje de IVA?");
        this.IVA=sc.nextDouble();
        sc.nextLine();
        System.out.println("¿Cual es el concepto?");
        this.concepto=sc.nextLine();
        System.out.println("¿Cuando se hizo la compra?");
        this.fecha=sc.nextLine();
        System.out.println("¿Se le va a aplicar descuento? (SI/NO)");
        eleccion=sc.nextLine();
        //Si tiene descuento lo imprime por pantalla
        if(eleccion.equals("SI")) {
            System.out.print("Porcentaje de descuento: ");
            descuento=sc.nextInt();
            this.base=+descuento(this.base, descuento);
            System.out.println("Numero de factura: "+numeroFactura());
            System.out.println("\nPrecio con IVA: "+calcularIVA(this.base, this.IVA));
            System.out.println("\nPrecio con descuento: " +this.base);
            System.out.println("\nConcepto: "+this.concepto);
            System.out.println("\nFecha: "+this.fecha);
            System.out.println("");
        }
        else {
            //Si no lo tiene no imprime ese apartado
            System.out.println("Numero de factura: "+numeroFactura());
            System.out.println("\nPrecio con IVA: "+calcularIVA(this.base, this.IVA));
            System.out.println("\nConcepto: "+this.concepto);
            System.out.println("\nFecha: "+this.fecha);
        }
        sc.close();
    }

}
public class claseFactura {
    public static void main(String[] args) {
        Factura f = new Factura();
        f.Imprimir();
    }
}
