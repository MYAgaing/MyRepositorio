package com.miempresa.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/NICOLAS";
    private static final String USER = "Nicolas";
    private static final String PASSWORD = "1793";

    public Connection getNewConnection() {
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de MariaDB.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return connection;
    }
}
