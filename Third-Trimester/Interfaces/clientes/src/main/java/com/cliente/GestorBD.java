package com.cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {
    private Connection connection;
    private String[] columnNames;

    public boolean connect(String host, String database, String user, String password) {
        try {
            String url = "jdbc:mysql://" + host + "/" + database;
            connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object[][] executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            
            int columnCount = metaData.getColumnCount();
            
            // Obtener nombres de columnas
            columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i-1] = metaData.getColumnName(i);
            }
            
            // Obtener datos
            List<Object[]> rows = new ArrayList<>();
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i-1] = rs.getObject(i);
                }
                rows.add(row);
            }
            
            // Convertir List a array bidimensional
            Object[][] data = new Object[rows.size()][columnCount];
            for (int i = 0; i < rows.size(); i++) {
                data[i] = rows.get(i);
            }
            
            rs.close();
            stmt.close();
            return data;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}