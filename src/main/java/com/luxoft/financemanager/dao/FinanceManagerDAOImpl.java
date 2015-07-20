package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.User;
import com.luxoft.financemanager.service.SessionFactoryCreator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by BSzewczyk on 2015-07-19.
 */
public class FinanceManagerDAOImpl implements FinanceManagerDAO {
    private SessionFactory sessionFactory = SessionFactoryCreator.getSessionFactory();
    private Session session = null;

    @Override
    public User getUserByUserName(String userName) {
        session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userName= :userName");
        query.setString("userName", userName);
        User user = (User) query.uniqueResult();
        return user;
    }
}
