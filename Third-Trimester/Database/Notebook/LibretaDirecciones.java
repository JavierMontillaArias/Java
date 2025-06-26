package Libreta;

import java.sql.*;
import java.util.*;

public class LibretaDirecciones {
    private Scanner sc;

    LibretaDirecciones(){
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
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(sc.nextLine()); 
            
            switch (opcion) {
                case 1:     añadirContacto(); break;
                case 2:     buscarContacto(); break;
                case 3:     listarContactos(); break;
                case 4:     eliminarContacto(); break;
                case 0:     System.out.println("Saliendo..."); break;
                default:    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    public void añadirContacto(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Añadir Contacto ------------");
        System.out.print("Intruduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el teléfono: ");
        String telefono = sc.nextLine();

        try {
            Statement stmt =  BBDD.conectarDB();
            BBDD.addContacto(stmt, new Contacto(nombre, telefono));
            BBDD.cerrarDB(stmt);
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }

    public void buscarContacto(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Buscar Contacto ------------");
        System.out.print("Intruduce el nombre: ");
        String nombre = sc.nextLine();

        try {
            Statement stmt =  BBDD.conectarDB();
            BBDD.findContacto(stmt, nombre);
            BBDD.cerrarDB(stmt);
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        
        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }

    public void listarContactos(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Listado de Contactos ------------");

        try {
            Statement stmt =  BBDD.conectarDB();
            BBDD.showContacto(stmt);
            BBDD.cerrarDB(stmt);
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
    }

    public void eliminarContacto(){
        System.out.print("\033[H\033[2J");
        System.out.println("------------ Eliminar Contacto ------------");
        System.out.print("Intruduce el nombre: ");
        String nombre = sc.nextLine();

        try {
            Statement stmt =  BBDD.conectarDB();
            BBDD.deleteContacto(stmt, nombre);
            BBDD.cerrarDB(stmt);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        System.out.println("\n\n\tPulse intro para continuar.");
        sc.nextLine();
        
    }

    
}