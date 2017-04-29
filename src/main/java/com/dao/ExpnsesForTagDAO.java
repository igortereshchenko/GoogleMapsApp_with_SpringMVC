package com.dao;

import java.sql.Date;
import java.util.Map;

/**
 * Created by Ichanskiy on 2017-04-29.
 */
public interface ExpnsesForTagDAO {
    public Map<String, Integer> getExpensesForTag( Date d1, Date d2);
}
