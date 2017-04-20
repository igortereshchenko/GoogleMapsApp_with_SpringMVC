package com.dao;


import com.model.Spending;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpendingDaoImpl implements SpendingDao<Spending>{

    public static final Logger logger = LoggerFactory.getLogger(SpendingDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSpending(Spending spending) {

        Session session = this.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.persist(spending);
        session.getTransaction().commit();

        logger.info("Spending successfully saved. Details: " + spending);

    }

    @Override
    public List<Spending> listSpending() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Spending> spendingList = session.createQuery("from Spending").list();

        for (Spending spending:spendingList) {
            logger.info("Spending" + spending);
        }

        return spendingList;
    }
}
