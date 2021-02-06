package com.navareno.data.Server;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public String getYyy() {
        return yyy;
    }

    private String yyy;

    private Connection connection;
    public DBWorker() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            yyy="Connnn";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
