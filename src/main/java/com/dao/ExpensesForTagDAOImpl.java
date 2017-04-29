package com.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static com.Connection.ConDB.getDBConnection;

/**
 * Created by Ichanskiy on 2017-04-29.
 */
public class ExpensesForTagDAOImpl implements ExpnsesForTagDAO {
    @Override

    public Map<String, Integer> getExpensesForTag(Date date_first, Date date_second) {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        try {

            System.out.println("F = " + date_first);
            System.out.println("S = " + date_second);

            Statement statement = null;
            statement = getDBConnection().createStatement();
            System.out.println("1");
            PreparedStatement preparedStatement = getDBConnection().prepareStatement("select USEREXPERSESCOUNT, TAG_NAME from TABLE(userExpenses_pkg.GetUserExpenses1(?, ?, ?))");
            preparedStatement.setDate(1,date_first);
            preparedStatement.setDate(2,date_second);
            preparedStatement.setInt(3,777);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("2");
            while (rs.next()) {
                int count = rs.getInt(1);
                String tag = rs.getString(2);
                System.out.println("count " + count);
                System.out.println("tag " + tag);
                hashMap.put(tag, count);
            }
            System.out.println();
            System.out.println();
            System.out.println();

            for (Map.Entry entry : hashMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + " Value: "
                        + entry.getValue());
            }

            System.out.println("3");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hashMap;
    }
}
