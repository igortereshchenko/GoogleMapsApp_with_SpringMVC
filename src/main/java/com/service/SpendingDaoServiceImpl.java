package com.service;


import com.dao.SpendingDao;
import com.model.Spending;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ichanskiy on 2017-03-14.
 */

@Service
public class SpendingDaoServiceImpl implements SpendingService<Spending> {

    private SpendingDao spendingDao;

    public void setSpendingDao(SpendingDao spendingDao) {
        this.spendingDao = spendingDao;
    }

    @Override
    @Transactional
    public void addSpending(Spending spending) {
        spendingDao.addSpending(spending);
    }

    @Override
    @Transactional
    public List<Spending> listSpending() {
        return spendingDao.listSpending();
    }
}
