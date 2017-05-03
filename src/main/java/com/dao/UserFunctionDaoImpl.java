package com.dao;

import java.sql.*;

import static com.Connection.ConDB.getDBConnection;

/**
 * Created by Ichanskiy on 2017-05-04.
 */
public class UserFunctionDaoImpl implements UserFunctionDao {
    @Override
    public void addUser(String name, String email, int phone, Date birthday) {

    }

    @Override
    public boolean LogInUser(String email, int phone) {

        boolean a = false;

        try {
            Statement statement;
            statement = getDBConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT USER_EMAIL, USER_PHONE FROM USERS");
            while (rs.next()) {

                String select_email = rs.getString(1);
                System.out.println("select_email " + select_email);
                int select_phone = rs.getInt(2);
                System.out.println("select_phone " + select_phone);


                if ((select_email.equals(email)) && (select_phone == phone)) {
                    System.out.println("phone ");
                    System.out.println("email ");
                    a = true;
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }
}
