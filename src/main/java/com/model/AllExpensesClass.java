package com.model;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-02.
 */
public class AllExpensesClass {

    private String address;
    private String tag;
    private Date date;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AllExpensesClass{" +
                "address='" + address + '\'' +
                ", tag='" + tag + '\'' +
                ", date=" + date +
                '}';
    }
}
