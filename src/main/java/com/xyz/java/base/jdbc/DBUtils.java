package com.xyz.java.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBUtils {

    /**
     * 保存数据
     * @param inserSql
     * @param args
     */
    public void insert(String inserSql,Object[] args) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(inserSql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
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


    /**
     * 批量保存数据
     * @param inserSql
     * @param paramList
     */
    public void insertBatch(String inserSql, List<Object[]> paramList) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(inserSql);
            for (int i = 0; i < paramList.size(); i++) {
                for (int j = 0; j < paramList.get(i).length; j++) {
                    preparedStatement.setObject(j + 1, paramList.get(i)[j]);
                }
                preparedStatement.addBatch();
            }
            // 批量执行insert
            preparedStatement.executeBatch();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
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


    public static void main(String[] args) {
        final DBUtils dbUtils = new DBUtils();
        final  String inserSql = "insert into user(code,name,tel,balance) values(?,?,?,?)";

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    ArrayList<Object[]> datas = new ArrayList<>(10000);
                    for (int j = 0; j < 10000; j++) {
                        Object[] params = new Object[]{UserMock.createCode(), UserMock.createName(), UserMock.createTel(), UserMock.createBalance()};
                        datas.add(params);
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "执行" + datas.size() + "条数据插入");
                    dbUtils.insertBatch(inserSql, datas);
                }
            });
        }
    }

}
