import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Producto{
    private String codigo, nombre;
    private double precio;
    private int stock;

    Producto(String codigo, String nombre, double precio, int stock){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters
    public String getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public double getPrecio() {return precio;}
    public int getStock() {return stock;}

    //Setters
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setStock(int stock) {this.stock = stock;}

    //Actualizar producto

    // Alerta de stock bajo
    public boolean comprobarStockMenorA5(int cantidad){
        if (cantidad <= 5){
            System.out.println("El stock de " + this.nombre + " es menor a 5 hace falta restablecerlo");
            return true;
        }
        return false;
    }

    //Vender
    public int venta (int cantidad){
        if(cantidad > this.stock){
            System.out.println("No se puede hacer un pedido tan alto");
            return this.stock;
        }
        int cant = this.stock - cantidad;
         if(comprobarStockMenorA5(cant)){
            return this.stock;
        }
        return this.stock -= cantidad;}
    //Restablecer
    public int restablecer (int cantidad){return this.stock += cantidad;}

    // Calcular el valor del inventario
    public double total(){return this.precio * this.stock;}

    // Mostrar el inventario
    @Override
    public String toString() {
        return "Código: " + this.codigo +
               "\nNombre: " + this.nombre +
               "\nPrecio: " + this.precio +
               "\nStock: " + this.stock;
    }
}
public class InventarioSuper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Producto>> list = new HashMap<>();
        boolean salir = false;
        do{
            System.out.print("Introduce la categoría, si quieres salir pon salir: ");
            String categoria = sc.nextLine();
            if(categoria.equals("salir")){
                salir = true;
                break;
            }
            if(!list.containsKey(categoria)){
                list.put(categoria, new ArrayList<>());
            } 
            System.out.print("Introduce el nombre: ");
            String nombre = sc.nextLine(); 

            boolean encontrado = false;

            for (Producto p : list.get(categoria)) {
                if(p.getNombre().equals(nombre)){
                    encontrado = true;
                    System.out.print("Producto encontrado!!! \nIntroduce 1 si quieres añadir el producto o 2 si quieres vender un producto: ");
                    int eleccion =sc.nextInt();
                    switch (eleccion) {
                        case 1:
                            System.out.print("Introduce la cantidad a añadir: ");
                            int cant = sc.nextInt();
                            p.restablecer(cant);
                            break;

                        case 2:
                            System.out.print("Introduce la cantidad a vender: ");
                            int can = sc.nextInt();
                            p.venta(can);
                            break;
                        default:
                            System.out.println("No es ninguna de las opciones.");
                            break;
                    }
                    sc.nextLine();
                } 
                    
            }
            if (!encontrado) {
                System.out.print("Introduce el código: ");
                String codigo = sc.nextLine();
                System.out.print("Introduce el precio: ");
                double precio = sc.nextDouble();
                System.out.print("Introduce el stock: ");
                int stock = sc.nextInt();
                sc.nextLine();  
                Producto nuevoProducto = new Producto(codigo, nombre, precio, stock);
                list.get(categoria).add(nuevoProducto);
                System.out.println("Producto agregado.");
            }
        }while (!salir);

        System.out.println("Inventario final:");
        System.out.println("-----------------------------------------");
        for (String categoria : list.keySet()) {
            System.out.println("\nCategoría: " + categoria);
            for (Producto p : list.get(categoria)) {
                System.out.println(p);
            }
            System.out.println("-----------------------------------------");
        }

        sc.close();
    }    
}