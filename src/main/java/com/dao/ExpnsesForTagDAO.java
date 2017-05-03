package com.dao;

import com.model.AllExpensesClass;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ichanskiy on 2017-04-29.
 */
public interface ExpnsesForTagDAO {
    public Map<String, Integer> getExpensesForTag( Date d1, Date d2, int phone);
    public List<AllExpensesClass> getAllExpenses(int phone);
}
