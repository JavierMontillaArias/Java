package Libreta;
import java.io.*;
import java.util.*;

public class LibretaDirecciones {
    private ArrayList<Contacto> contactos;
    private Scanner sc;

    LibretaDirecciones(){
        contactos = new ArrayList<Contacto>();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        LibretaDirecciones ld = new LibretaDirecciones();
        ld.mostrarMenu();
    }

    public void mostrarMenu(){
        int opcion;
        do {
            System.out.print("\033[H\033[2J");
            System.out.println("\n--- Libreta de Direcciones ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Guardar libreta");
            System.out.println("6. Cargar libreta");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(sc.nextLine()); 
            
            switch (opcion) {
                case 1:     añadirContacto(); break;
                case 2:     buscarContacto(); break;
                case 3:     listarContactos(); break;
                case 4:     eliminarContacto(); break;
                case 5:     guardarLibreta(); break;
                case 6:     cargarLibreta(); break;
                case 7:     System.out.println("Saliendo..."); break;
                default:    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        } while (opcion != 7);
    }

    public void añadirContacto(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Añadir Contacto ------------");
        System.out.print("Intruduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el teléfono: ");
        String telefono = sc.nextLine();

        contactos.add(new Contacto(nombre, telefono));

        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }

    public void buscarContacto(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Buscar Contacto ------------");
        System.out.print("Intruduce el nombre: ");
        String nombre = sc.nextLine();
        boolean encontrado = false;
        for(Contacto cont : contactos){
            if(cont.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                System.out.println(cont);
                encontrado = true;
            }
        }

        if(!encontrado)
            System.out.println("Contacto no encontrado.");
        
        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }

    public void listarContactos(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Listado de Contactos ------------");
        for(Contacto cont : contactos){
            System.out.println(cont);
        }
        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }

    public void eliminarContacto(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Eliminar Contacto ------------");
        System.out.print("Intruduce el nombre: ");
        String nombre = sc.nextLine();
        Contacto encontrado = null;
        for(Contacto cont : contactos){
            if(cont.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                System.out.println(cont);
                encontrado = cont;
                break;
            }
        }

        if(encontrado != null) {
            contactos.remove(encontrado);
            System.out.println("Contacto eliminado.");
        }
        else {
            System.out.println("No se ha encontrado.\nContacto NO eliminado.");
        }
        
        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
        
    }

    public void guardarLibreta(){
        System.out.print("\033[H\033[2J");
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(new File("libreta.bin")))) {
            for(Contacto cont : contactos){
                escritor.writeObject(cont);
            }
            escritor.writeObject(null);
            System.out.println("Guardada correctamente");
        } catch (IOException ioe) {
            System.out.println("No se ha podido guardar");
        }
    
        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }

    public void cargarLibreta(){
        System.out.print("\033[H\033[2J");
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(new File("libreta.bin")))) {
            contactos.clear();
            Contacto cont;
            while((cont = (Contacto) lector.readObject()) != null){
                contactos.add(cont);
            }
            System.out.println("Cargada correctamente.");
            
        } catch (EOFException eofe) {
            System.out.println("No se ha podido cargar.\n" + eofe.getMessage());
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se ha podido cargar.\n" + fnfe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("No se ha podido cargar.\n" + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("No se ha podido cargar.\n" + ioe.getMessage());
        }

        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }
}