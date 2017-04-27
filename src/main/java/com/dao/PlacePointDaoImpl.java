package com.dao;

import java.sql.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.Connection.ConDB.getDBConnection;


/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class PlacePointDaoImpl implements PlacePointDao{

    public Date getDate(){
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        Date date = null;
        try {
            date = format1.parse(String.valueOf(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public void addPlacePoint(String addres_str, double lat_double, double long_double, int amount_int, String tagNameFk, String tagName, java.sql.Date date_sql) {


        try {
            PreparedStatement preparedStatement = null;
            Connection connection = null;
            connection = getDBConnection();
            System.out.println("1");
           // connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            preparedStatement =  connection.prepareStatement("INSERT INTO " +
                    "PLACEPOINT (PLACEPOINT_ID,PLACEPOINT_ADDRESS,PLACEPOINT_LONG,PLACEPOINT_LAT) " +
                    "VALUES (?,?,?,?)");
            System.out.println("2");

            preparedStatement.setInt(1,1);
            System.out.println("3");

            preparedStatement.setString(2, addres_str);
            System.out.println("4");

            preparedStatement.setDouble(3, long_double);
            System.out.println("5");

            preparedStatement.setDouble(4, lat_double);
            System.out.println("6");

            preparedStatement.executeUpdate();
            System.out.println("7");

            preparedStatement.close();
            System.out.println("insert into PlacePoint");
            connection.close();


            System.out.println("9");
            Connection connection1 = getDBConnection();
            System.out.println("10");
            CallableStatement callableStatement = connection1.prepareCall("CALL GETPLACEPOINTID(?,?)");
            System.out.println("10.1.1");
            callableStatement.setDouble(1, long_double);
            System.out.println("10.2 set log");
            callableStatement.setDouble(1, lat_double);
            System.out.println("10.3 lat");
            callableStatement.registerOutParameter(1, Types.DOUBLE);
            System.out.println("10.4 register out");
            callableStatement.executeUpdate();
            System.out.println("executeUpdate");
            double result = callableStatement.getDouble(1);
            System.out.println(result);
            callableStatement.close();
            System.out.println("long " +long_double);
            System.out.println("lat " + lat_double);
           /* preparedStatement = null;
            preparedStatement = connection1.prepareStatement("INSERT INTO " +
                    "USEREXPENSES (USER_PHONE_FK,PLACEPOINT_ID_FK,USEREXPERSES_DATE,COLUMNUSEREXPERSES_COUNT, USEREXPENSES_ID) " +
                    "VALUES (?,?,?,?,?)");
            System.out.println("11");
            preparedStatement.setInt(1, 777);
            System.out.println("11.1");

            preparedStatement.setInt(2, 1);
            System.out.println("11.2");

            preparedStatement.setDate(3, date_sql);
            System.out.println("11.3");

            preparedStatement.setInt(4, amount_int);
            System.out.println("11.4");

            preparedStatement.setInt(5, 1);
            System.out.println("12");

            System.out.println(addres_str);
            System.out.println(lat_double);
            System.out.println(long_double);
            System.out.println(amount_int);
            System.out.println(date_sql);
            System.out.println(tagName);
            System.out.println(tagNameFk);
            System.out.println("13");

            preparedStatement.executeUpdate();
            System.out.println("14");

            preparedStatement.close();
            System.out.println("15");
*/
          //  connection1.close();
            System.out.println("16");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
