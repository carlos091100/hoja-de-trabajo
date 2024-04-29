package com.umg.dao;

import com.umg.connection.MariaDBConnection;

import java.sql.*;

public class TestDao {

    private MariaDBConnection mariaDBConnection;

    public TestDao(MariaDBConnection mariaDBConnection) {
        this.mariaDBConnection = mariaDBConnection;
    }

    // método CRUD
    public void crearRegistro(String nombre, String apellido, int edad) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = mariaDBConnection.getConnection();
            String sql = "INSERT INTO tabla_ejemplo (nombre, apellido, edad) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "carlos");
            statement.setString(2, "rustrian");
            statement.setInt(3, 23);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mariaDBConnection.closeConnection(connection);
        }
    }

    
}
