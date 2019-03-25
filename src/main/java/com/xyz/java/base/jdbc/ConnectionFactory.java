package com.xyz.java.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/workplatform?characterEncoding=utf8";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "root";

    public static Connection getConnection()  {
        try {
            Class.forName(DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 20 ; i++) {
            Connection connection = getConnection();
            connection.close();
        }
        while (true){

        }
    }


}
