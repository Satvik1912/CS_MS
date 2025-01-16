package com.cars24.util;

import com.cars24.config.Dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    public static Connection connection;
    public static Connection getDbConnection() {

            try {
                connection = DriverManager.getConnection(Dbconfig.host, Dbconfig.username, Dbconfig.password);
                System.out.println("Connected to database");

            } catch (SQLException e) {
                System.out.println("Error connecting to the database");
            }

        return connection;
    }


}
