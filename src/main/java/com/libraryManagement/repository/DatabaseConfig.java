package com.libraryManagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
        private static final String URL= "jdbc:postgresql://localhost/library_management";
        private static final String USERNAME= "prog_admin";
        private static final String PASSWORD= "123456";
    public  Connection createConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error establishing a database connection.");
        }
    }
}
