package com.edutecno.final_drilling.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

//    private static final String DB_URL = "jdbc:postgresql://localhost:5433/myapp";
    private static final String DB_URL = "jdbc:postgresql://" + System.getenv("DB_HOST")
        + ":" + System.getenv("DB_PORT") + "/" + System.getenv("DB_NAME");
//    private static final String USER = "postgres";
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        return connection;
    }

    public void closeConnection(){
        if(connection != null) {
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
