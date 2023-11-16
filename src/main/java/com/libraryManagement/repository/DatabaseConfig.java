package com.libraryManagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private String url;
    private String username;
    private String password;

    public DatabaseConfig(){
        this.url = System.getenv("DB_URL");
        this.username = System.getenv("DB_USER");
        this.password = System.getenv("DB_PASSWORD");
    }

    public Connection createConnection(){
        try{Connection connection = DriverManager.getConnection(
                    this.url, this.username, this.password
            );
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
