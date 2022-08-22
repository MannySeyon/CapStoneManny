package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {

    Connection connection;

   public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://34.68.83.162/SummitFinancialCorp", "root", "1558");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
