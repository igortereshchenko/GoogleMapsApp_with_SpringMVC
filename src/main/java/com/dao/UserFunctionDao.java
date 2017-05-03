package com.dao;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-04.
 */
public interface UserFunctionDao {

    public void addUser(String name, String email, int phone, Date birthday);
    public boolean LogInUser(String email, int phone);
}
