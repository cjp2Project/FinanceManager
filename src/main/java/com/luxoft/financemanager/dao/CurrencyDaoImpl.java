package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.City;
import com.luxoft.financemanager.model.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CurrencyDaoImpl implements CurrencyDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addCurrency(Currency currency) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(currency);
    }

    @Override
    public void updateCurrency(Currency currency) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(currency);
    }

    @Override
    public List<Currency> listCurrencies() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Currency> currenciesList = session.createQuery("from Currency").list();
        return currenciesList;
    }

    @Override
    public Currency getCurrencyById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Currency currency = (Currency) session.load(Currency.class, new Integer(id));
        return currency;
    }

    @Override
    public void removeCurrency(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Currency currency = (Currency) session.load(City.class, new Integer(id));
        if (null != currency) {
            session.delete(currency);
        }
    }
}
