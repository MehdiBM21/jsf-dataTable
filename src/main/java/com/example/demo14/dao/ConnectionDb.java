package com.example.demo14.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    private static Connection connection = null;

    private ConnectionDb(){
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://mysql-37ee7df0-mehdibm-b7be.a.aivencloud.com:22846/defaultdb", "avnadmin", "AVNS_3cj9R0sBwi6h5V0Ancs");
//                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
            System.out.println("Connexion établie");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(connection == null){
            new ConnectionDb();
        }
        return connection;
    }
}
