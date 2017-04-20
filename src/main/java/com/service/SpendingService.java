package com.service;

import java.util.List;

/**
 * Created by Ichanskiy on 2017-03-14.
 */
public interface SpendingService<T> {

    public void addSpending(T t);
    public List<T> listSpending();

}
