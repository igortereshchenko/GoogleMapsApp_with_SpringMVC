package com.dao;

import java.sql.*;

import static com.Connection.ConDB.getDBConnection;

/**
 * Created by Ichanskiy on 2017-05-04.
 */
public class UserFunctionDaoImpl implements UserFunctionDao {
    @Override
    public boolean addUser(String name, String email, int phone, Date birthday) {
        boolean a = false;
        try {
            UserFunctionDaoImpl userFunctionDao = new UserFunctionDaoImpl();
            a = userFunctionDao.LogInUser(email,phone);

            if (!a) {
                Connection connectionAddUser = getDBConnection();
                PreparedStatement preparedStatement = connectionAddUser.prepareStatement("INSERT INTO " +
                        "USERS (USER_PHONE, USER_NAME, USER_EMAIL, USER_BIRTHDATE) " +
                        "VALUES (?,?,?,?)");
                System.out.println("2");
                preparedStatement.setInt(1, phone);
                System.out.println("3");
                preparedStatement.setString(2, name);
                System.out.println("4");
                preparedStatement.setString(3, email);
                System.out.println("5");
                preparedStatement.setDate(4, birthday);
                System.out.println("6");
                preparedStatement.executeUpdate();
                System.out.println("7");
                preparedStatement.close();
                System.out.println("insert into User");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
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
              //  System.out.println("select_email " + select_email);
                int select_phone = rs.getInt(2);
               // System.out.println("select_phone " + select_phone);


                if ((select_email.equals(email)) && (select_phone == phone)) {
                    System.out.println("phone " + phone);
                    System.out.println("email " + email);
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
