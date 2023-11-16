package com.libraryManagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private String url;
    private String username;
    private String password;

    public DatabaseConfig(){
        this.url = "jdbc: postgresql://localhost/library_management";
        this.username = "postgres";
        this.password = "0000";
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
