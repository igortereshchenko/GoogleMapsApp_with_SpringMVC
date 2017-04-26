package com.dao;

import com.Connection.Connection;
import com.model.PlacePoint;
import java.sql.*;

import java.sql.SQLException;

import static com.Connection.Connection.getDBConnection;

/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class PlacePointDaoImpl {
/*

    public void dss(){

        try {
            PreparedStatement preparedStatement = null;
            Connection connection = null;
            connection = getDBConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO " +
                    "CUSTOMERS (CUST_NALOGCODE,CUST_PASS,CUST_NAME,CUST_EMAIL,CUST_PHONE) " +
                    "VALUES (?,?,?,?,?)");

            preparedStatement.setString(1, "jk");
            preparedStatement.setString(2, "jhsd");
            preparedStatement.setString(3, "dfsd");
            preparedStatement.setString(4, "df");
            preparedStatement.setString(5, "sdfd");
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
*/
}
