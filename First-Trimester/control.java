import java.util.Scanner;

class Producto {
    String codigo, nombre, proveedor;
    double precio;
    int cantidad;
    Producto(String codigo, String nombre, double precio, int cantidad, String proveedor) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
        this.proveedor=proveedor;
    }
    public void mostrarInformacion() {
        System.out.println("Codigo: "+this.codigo);
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Precio: "+this.precio);
        System.out.println("Cantidad: "+this.cantidad);
        System.out.println("Proveedor: "+this.proveedor);
    }
    public double actualizarPrecio(double precio) {
        return this.precio=precio;
    }
    public int venderProducto(int cantidadVendida) {
        this.cantidad-=cantidadVendida;
        return this.cantidad;
    }
    public int reabastecerProducto(int cantidadNueva) {
       this.cantidad+=cantidadNueva;
       return this.cantidad;
    }
    public double calcularValorTotal() {
        return this.precio*this.cantidad;
    }
    public void verificarStock() {
        if(this.cantidad==0) {
            System.out.println("No hay stock");
        }
        else {
            System.out.println("Quedan "+this.cantidad+" " +this.nombre+"s");
        }
    }
}
public class control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Producto p = new Producto("123", "Mueble", 21.33, 123, "Ikea");
        double precio;
        int cantidad;
        p.mostrarInformacion();
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Introduce el nuevo precio: ");
        precio=sc.nextDouble();
        p.actualizarPrecio(precio);
        p.mostrarInformacion();
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Introduce la cantidad vendida: ");
        cantidad=sc.nextInt();
        p.venderProducto(cantidad);
        p.mostrarInformacion();
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Introduce la cantidad nueva de stock que se va a introducir: ");
        cantidad=sc.nextInt();
        p.reabastecerProducto(cantidad);
        p.mostrarInformacion();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("El valor del stock es: "+p.calcularValorTotal());
        p.verificarStock();
        sc.close();
    }
}
