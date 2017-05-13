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
    public void addPlacePoint(String addres_str, double lat_double, double long_double, int amount_int, String tagNameFk, String tagName, java.sql.Date date_sql, int phone) {



        try {
/////////////////// addPlacePoint
            PreparedStatement preparedStatement;
            Connection connectionPlacePoint;
            connectionPlacePoint = getDBConnection();

            Statement statement = null;
            statement = getDBConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT GENKEY.NEXTVAL FROM DUAL");
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            statement.close();


            System.out.println("seqence" + count);
            System.out.println("1");
           // connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            preparedStatement =  connectionPlacePoint.prepareStatement("INSERT INTO " +
                    "PLACEPOINT (PLACEPOINT_ID,PLACEPOINT_ADDRESS,PLACEPOINT_LONG,PLACEPOINT_LAT) " +
                    "VALUES (?,?,?,?)");
            System.out.println("2");
            preparedStatement.setInt(1,count);
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
            connectionPlacePoint.commit();
            System.out.println("commit insert into PlacePoint");
            connectionPlacePoint.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

/*/////////////////////////////add Tag
        try {
            Connection connectionTag;
            connectionTag = getDBConnection();
            PreparedStatement preparedStatement;
            preparedStatement =  connectionTag.prepareStatement("INSERT INTO " +
                    "TAG (TAG_NAME,TAG_NAME_PARENT_FK,TAG_DISCRIPTION) " +
                    "VALUES (?,?,?)");
            preparedStatement.setString(1, tagName);
            preparedStatement.setString(2, tagName);
            preparedStatement.setString(3, "dis");
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connectionTag.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        try{
///////////////////// add EXPANSES
            System.out.println("9");
            Connection connection1 = getDBConnection();
            System.out.println("10");
            CallableStatement callableStatement = connection1.prepareCall("{? = call GETPLACEPOINTID(?,?)}");
            System.out.println("10.1.1");
            callableStatement.registerOutParameter(1, Types.DOUBLE);
            System.out.println("10.4 register out" );
            callableStatement.setDouble(2, long_double);
            System.out.println("10.2 set log  " + long_double );
            callableStatement.setDouble(3, lat_double);
            System.out.println("10.3 lat" + lat_double);

            callableStatement.execute();
            System.out.println("executeUpdate");
            int result = callableStatement.getInt(1);
            System.out.println("reeeeeeessssssssulllrrrtttt  "+ result);
            callableStatement.close();
            System.out.println("long " +long_double);
            System.out.println("lat " + lat_double);

            Statement statement = null;
            statement = getDBConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT GENKEY.nextval FROM DUAL");
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            statement.close();

            PreparedStatement preparedStatement = null;
            preparedStatement = connection1.prepareStatement("INSERT INTO " +
                    "USEREXPENSES (USER_PHONE_FK,PLACEPOINT_ID_FK,USEREXPERSES_DATE, userexpenses_count, USEREXPENSES_ID) " +
                    "VALUES (?,?,?,?,?)");
            System.out.println("11");
            preparedStatement.setInt(1, phone);
            System.out.println("11.1");

            preparedStatement.setInt(2, result);
            System.out.println("11.2");

            preparedStatement.setDate(3, date_sql);
            System.out.println("11.3");

            preparedStatement.setInt(4, amount_int);
            System.out.println("11.4");
            int count_new = count-1;
            preparedStatement.setInt(5, count_new);
            System.out.println("12");

            System.out.println(addres_str);
            System.out.println(lat_double);
            System.out.println(long_double);
            System.out.println(amount_int);
            System.out.println(date_sql);
            System.out.println(tagName);
            System.out.println(tagNameFk);
            System.out.println("insert into EXPENSES");

            preparedStatement.executeUpdate();
            System.out.println("14");

            preparedStatement.close();
            System.out.println("15");
            connection1.commit();
            connection1.close();
            System.out.println("16");

        } catch (SQLException e) {
            e.printStackTrace();
        }



/////////////////////add ExpenseTag
        try {
            Connection connectionExpenseTag;
            connectionExpenseTag = getDBConnection();

            CallableStatement callableStatement = connectionExpenseTag.prepareCall("{? = call GETUSEREXPENCESID(?,?,?,?)}");
            System.out.println("21");
            callableStatement.setInt(2, phone);
            System.out.println("22 set log");
            callableStatement.setDouble(3, long_double);
            System.out.println("23 long");
            callableStatement.setDouble(4, lat_double);
            System.out.println("24 lat");
            callableStatement.setDate(5, date_sql);
            System.out.println("25 date");
            callableStatement.registerOutParameter(1, Types.DOUBLE);
            System.out.println("10.4 register out");
            callableStatement.execute();
            System.out.println("executeUpdate");
            double result_id = callableStatement.getDouble(1);
            System.out.println("tag result " + result_id);

            PreparedStatement preparedStatement;
            preparedStatement = connectionExpenseTag.prepareStatement("INSERT INTO USEREXPENSESTAG(USER_EXPENSES_ID_FK, TAG_NAME_FK) " +
                                                                                    "VALUES (?,?)");
            preparedStatement.setDouble(1, result_id);
            System.out.println("result_id " + result_id);
            System.out.println("tagName " + tagName);
            preparedStatement.setString(2, tagName);
            System.out.println("add USEREXPENSESTAG ");
            preparedStatement.executeUpdate();
            System.out.println("USEREXPENSESTAG executeUpdate");
            preparedStatement.close();
            connectionExpenseTag.commit();
            connectionExpenseTag.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
