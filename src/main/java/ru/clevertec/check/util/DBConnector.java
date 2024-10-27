package ru.clevertec.check.util;

import ru.clevertec.check.exception.InternalServerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection connection;
    private static final String DRIVER = "org.postgresql.Driver";

    private DBConnector() {
        connect();
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
            return connection;
        } catch (SQLException e) {
            throw new InternalServerException();
        }
    }

    private static void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/check",
                    "postgres",
                    "963Luda963");
//                    System.getProperty("datasource.url"),
//                    System.getProperty("datasource.username"),
//                    System.getProperty("datasource.password"));
        } catch (SQLException | ClassNotFoundException e) {
            throw new InternalServerException();
        }
    }
}