package com.libraryManagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
        private static final String URL= System.getenv("DB_URL");
        private static final String USERNAME= System.getenv("DB_USERNAME");
        private static final String PASSWORD= System.getenv("DB_PASSWORD");
    public  Connection createConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error establishing a database connection.");
        }
    }
}
