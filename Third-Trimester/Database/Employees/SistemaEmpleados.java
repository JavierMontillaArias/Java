package Empleados;

import java.util.Scanner;
import java.sql.*;

public class SistemaEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Statement stmt = null;

        try {
            stmt = GestorDB.conectarDB();

            int opc = 0;

            do {
                System.out.println("1.- Añadir Empleado");
                System.out.println("2.- Eliminar Empleado");
                System.out.println("3.- Modificar Empleado");
                System.out.println("4.- Listar Empleados");
                System.out.println("0.- Salir");
                System.out.print(">>>>>>> Elija opcición: ");
                opc = Integer.parseInt(scanner.nextLine());

                switch (opc) {
                    case 1:
                        System.out.print("Introduzca Nombre: ");               
                        String nombre = scanner.nextLine();      
                        System.out.print("Introduzca Apellido: ");               
                        String apellido = scanner.nextLine();      
                        System.out.print("Introduzca Salario: ");               
                        double salario = Double.parseDouble(scanner.nextLine());      
                        GestorDB.addEmpleado(stmt, nombre, apellido, salario);
                        break;
                
                    case 2:
                        GestorDB.listEmpleados(stmt);
                        System.out.print("Introduzca ID del empleado a eliminar: ");                  
                        int id2 = Integer.parseInt(scanner.nextLine());   
                        GestorDB.deleteEmpleado(stmt, id2);
                        break;
                    
                    case 3:
                        GestorDB.listEmpleados(stmt);
                        System.out.print("Introduzca ID del empleado a modificar: ");                  
                        int id3 = Integer.parseInt(scanner.nextLine());   
                        System.out.print("Introduzca Nombre: ");               
                        String nombre3 = scanner.nextLine();      
                        System.out.print("Introduzca Apellido: ");               
                        String apellido3 = scanner.nextLine();      
                        System.out.print("Introduzca Salario: ");               
                        double salario3 = Double.parseDouble(scanner.nextLine());   
                        
                        GestorDB.updateEmpleado(stmt, id3, nombre3, apellido3, salario3);
                        break;

                    case 4:
                        GestorDB.listEmpleados(stmt);                        
                        break;

                    case 0:
                        GestorDB.cerrarDB(stmt);
                        break;
                }



            } while (opc != 0);

        } catch (Exception e) {
           e.printStackTrace();
        }  
        scanner.close();
    }
}

