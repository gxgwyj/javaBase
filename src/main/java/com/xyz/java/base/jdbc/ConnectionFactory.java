package com.xyz.java.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/eshop?characterEncoding=utf8";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "root";

    /**
     * 获取数据库谅解
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
