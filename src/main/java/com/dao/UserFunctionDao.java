package com.dao;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-04.
 */
public interface UserFunctionDao {

    boolean addUser(String name, String email, int phone, Date birthday);
    boolean LogInUser(String email, int phone);
}
