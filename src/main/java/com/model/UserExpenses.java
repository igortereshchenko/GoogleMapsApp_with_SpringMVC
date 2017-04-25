package com.model;

import java.util.Date;
/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class UserExpenses {

    private Date userExpenses_date;
    private int userExpenses_count;

    public UserExpenses() {
    }

    public UserExpenses(Date userExpenses_date, int userExpenses_count) {
        this.userExpenses_date = userExpenses_date;
        this.userExpenses_count = userExpenses_count;
    }

    public Date getUserExpenses_date() {
        return userExpenses_date;
    }

    public void setUserExpenses_date(Date userExpenses_date) {
        this.userExpenses_date = userExpenses_date;
    }

    public int getUserExpenses_count() {
        return userExpenses_count;
    }

    public void setUserExpenses_count(int userExpenses_count) {
        this.userExpenses_count = userExpenses_count;
    }

    @Override
    public String toString() {
        return "UserExpenses{" +
                "userExpenses_date=" + userExpenses_date +
                ", userExpenses_count=" + userExpenses_count +
                '}';
    }
}
