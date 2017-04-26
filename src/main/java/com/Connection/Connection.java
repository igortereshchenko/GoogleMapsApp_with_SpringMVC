package com.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class Connection {

    public static Connection getDBConnection() throws SQLException {

        try {
            //реєструємо драйвео
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //встановлюємо з'єднання з БД
        java.sql.Connection dbConnection = null;
        dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "root", "1111");
        return (Connection) dbConnection;
    }

}
