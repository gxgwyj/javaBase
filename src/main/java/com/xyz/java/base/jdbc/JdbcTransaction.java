package com.xyz.java.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Administrator
 * @data 2019/7/23
 * @description TODO
 */
public class JdbcTransaction {

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
        String inserSql = "insert into user(id,code,name,tel,balance) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        // 设置非自动提交
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(inserSql);
            preparedStatement.setInt(1,91);
            preparedStatement.setString(2,"3000123aaa");
            preparedStatement.setString(3,"guanyu");
            preparedStatement.setString(4,"18979888900");
            preparedStatement.setInt(5,450);
            preparedStatement.executeUpdate();

            preparedStatement.setInt(1,321);
            preparedStatement.setString(2,"30001233bbb");
            preparedStatement.setString(3,"guanyu1");
            preparedStatement.setString(4,"18979888900");
            preparedStatement.setInt(5,600);

            preparedStatement.executeUpdate();

            // 提交事务
            connection.commit();

            System.out.println("插入数据成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }


}
