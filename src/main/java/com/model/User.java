package com.model;

import java.util.Date;

/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class User {

    private String user_phone;
    private String user_name;
    private String user_email;
    private Date user_birthdy;

    public User() {
    }

    public String getUser_phone() {
        return user_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public Date getUser_birthdy() {
        return user_birthdy;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_birthdy(Date user_birthdy) {
        this.user_birthdy = user_birthdy;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_phone='" + user_phone + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_birthdy=" + user_birthdy +
                '}';
    }
}
