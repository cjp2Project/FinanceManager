package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FinanceManagerDAOImpl implements FinanceManagerDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addShoppingItemToDB(ShoppingItem shoppingItem) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(shoppingItem);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Shop> listShops() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Shop> shops = session.createQuery("from Shop").list();
        return shops;
    }

    @Override
    public User getUserByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userName= :userName ");
        query.setString("userName", userName);
        User user = (User) query.uniqueResult();
        user.getShoppingItems().size();
        return user;
    }

    @Override
    public void addCity(City city) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(city);
    }

    @Override
    public void updateCity(City city) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(city);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<City> listCities() {
        Session session = this.sessionFactory.getCurrentSession();
        List<City> citiesList = session.createQuery("from city ").list();
        return citiesList;
    }

    @Override
    public City getCityById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        City city = (City) session.load(City.class, new Integer(id));
        return city;
    }

    @Override
    public void removeCity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        City city = (City) session.load(City.class, new Integer(id));
        if (null != city) {
            session.delete(city);
        }
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
    public List<ShoppingCategory> listCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ShoppingCategory> categoriesList = session.createQuery("from shopping_category ").list();
        return categoriesList;
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