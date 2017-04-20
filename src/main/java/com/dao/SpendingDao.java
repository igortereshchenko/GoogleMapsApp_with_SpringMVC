package com.dao;


import java.util.List;

public interface SpendingDao<T> {

    public void addSpending(T t);
    public List<T> listSpending();

}
