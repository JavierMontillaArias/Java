package Libreta;

import java.sql.*;

public class BBDD {

    public static Statement conectarDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/libreta_direcciones";
        String user = "root";
        String password = "root";
        Connection conn = null;

        conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();

        return stmt;
    }

    public static void cerrarDB(Statement stmt) throws SQLException {
        Connection conn = stmt.getConnection();
        conn.close();
        stmt.close();
    }    

    public static void addContacto(Statement stmt, Contacto cont) throws SQLException {
        //String sql = "INSERT INTO contactos (nombre, telefono) VALUES ('" + cont.getNombre() + "', '"+ cont.getTelefono()+"')";
        String sql = "INSERT INTO contactos (nombre, telefono) VALUES ('%s', '%s')";
        sql = String.format(sql, cont.getNombre(), cont.getTelefono());
        stmt.executeUpdate(sql);
    }
    
    public static void deleteContacto(Statement stmt, String nombre) throws SQLException {
        String sql = "DELETE FROM contactos WHERE nombre='%s'";
        sql = String.format(sql, nombre);
        stmt.executeUpdate(sql);       
    }

    public static void findContacto(Statement stmt, String nombre) throws SQLException {
        String sql = "SELECT nombre, telefono FROM contactos WHERE nombre='%s'";
        sql = String.format(sql, nombre);
        ResultSet rs = stmt.executeQuery(sql);              
        while(rs.next()){
            System.out.println(rs.getString("nombre") + " - " + rs.getString("telefono"));
        }
    }

    public static void showContacto(Statement stmt) throws SQLException{
        String sql = "SELECT nombre, telefono FROM contactos";
        ResultSet rs = stmt.executeQuery(sql);              
        while(rs.next()){
            System.out.println(rs.getString("nombre") + " - " + rs.getString("telefono"));
        }        
    }
}