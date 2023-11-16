package com.vti.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
//    public static void main(String[] args) {
//        JdbcUtils.getConect();
//    }
    static Connection connection = null;
    // Tạo 1 method chuyên dùng để conect tới My Sql
    public static Connection getConnect(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/db.properties"));
            // Những thông số để connect -> My SQL
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pass = properties.getProperty("password");
            String driver = properties.getProperty("driver");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
//                System.out.println("Thanh cong1");
            } else {
                System.err.println("That bai");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }
}
