package Empleados;

import java.sql.*;

public class GestorDB  {
   
    public static Statement conectarDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/empleadosdb";
        String user = "root";
        String password = "root";
        Connection conn = null;

        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Conectado a la base de datos!");

        Statement stmt = conn.createStatement();

        return stmt;
    }

    public static void cerrarDB(Statement stmt) throws SQLException {
        Connection conn = stmt.getConnection();
        conn.close();
        stmt.close();
    }

    public static void addEmpleado(Statement stmt, String nombre, String apellido, Double salario) throws SQLException {
        String sql = "INSERT INTO empleados (nombre, apellido, salario) VALUES ('"+nombre+"', '"+apellido+"', "+salario+")";
        if(stmt.executeUpdate(sql) != 0){
            System.out.println("Añadido correctamente");
        }
        else{
            System.out.println("No se pudo añadir");

        }
    }

    public static void deleteEmpleado (Statement stmt, int id) throws SQLException {
        String sql = "DELETE FROM empleados WHERE id = " + id;
        if(stmt.executeUpdate(sql) != 0){
            System.out.println("Eliminado correctamente");
        }
        else{
            System.out.println("No se pudo eliminar");

        }
    }

    public static void updateEmpleado (Statement stmt, int id, String nombre, String apellido, Double salario) throws SQLException {
        String sql = "UPDATE empleados SET nombre='"+nombre+"', apellido='"+apellido+"', salario="+salario+" WHERE id = "+id;
        if(stmt.executeUpdate(sql) != 0){
            System.out.println("Modificado correctamente");
        }
        else{
            System.out.println("No se pudo modificar");

        }           
    }

    public static void listEmpleados(Statement stmt) throws SQLException {
        String sql = "SELECT id, nombre, apellido, salario FROM empleados";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.print(rs.getInt("id")+"\t");
            System.out.print(rs.getString("nombre")+"\t\t");
            System.out.print(rs.getString("apellido")+"\t\t");
            System.out.println(rs.getDouble("salario"));
            }
    }
 
}