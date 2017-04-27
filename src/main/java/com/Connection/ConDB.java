package com.Connection;

import java.sql.*;
/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class ConDB {

    public static Connection getDBConnection() throws SQLException {

        try {
            //реєструємо драйвео
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //встановлюємо з'єднання з БД
        Connection dbConnection = null;
        dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ich", "1111");
        return dbConnection;
    }

}


