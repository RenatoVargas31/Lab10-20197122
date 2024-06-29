package com.example.lab1020197122.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseDao {
    public Connection getConection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Falla conexion");
        }

        String username = "root";
        String password = "root";
        String database = "lab7";
        String params = "serverTimezone=America/Lima&useSSL=false&allowPublicKeyRetrieval=true";
        String url = "jdbc:mysql://localhost:3306/" + database + "?" + params;

        return DriverManager.getConnection(url, username, password);

    }
}
