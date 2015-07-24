package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.comparators.ShoppingItemComparator;
import com.luxoft.financemanager.model.*;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sun.util.calendar.BaseCalendar;

import java.sql.Date;
import java.util.Collections;
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

    @Override
    public void updateShoppingItemToDB(ShoppingItem shoppingItem) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(shoppingItem);
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

        Collections.sort(user.getShoppingItems(), new ShoppingItemComparator());
        user.getRole().toString();
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
        categoriesList.size();
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

    public ShoppingCategory getShoppingCategoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ShoppingCategory shoppingCategory = (ShoppingCategory) session.load(ShoppingCategory.class, new Integer(id));
        return shoppingCategory;
    }

    @Override
    public Shop getShopById(int shopId) {
        Session session = this.sessionFactory.getCurrentSession();
        Shop shop = (Shop) session.load(Shop.class, new Integer(shopId));
        return shop;
    }

    @Override
    public Shop getShop(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Shop shop = (Shop) session.load(Shop.class, new Integer(id));
        if (null != shop) {
            session.delete(shop);
        }
        return shop;
    }

    @Override
    public ShoppingItem getShoppingItemByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingItem shoppingItem = (ShoppingItem) session.load(ShoppingItem.class, new Integer(id));
        shoppingItem.getShop().getShoppingItems().size();
        return shoppingItem;
    }

    public void removeShoppingItemByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ShoppingItem shoppingItem = (ShoppingItem) session.load(ShoppingItem.class, new Integer(id));
        if (null != shoppingItem) {
            session.delete(shoppingItem);
        }
    }

    @Override
    public List<Object[]> getUserShoppingCategoriesByDate(int id, String fromDate, String toDate) {
        Session session = this.sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("select shopping_category.name, sum(shopping_item.amount) from shopping_category inner join " +
                "shopping_item on shopping_category.id = shopping_item.shopping_category_id " +
                "where user_id=" + id + " and date(shopping_item.date) between '2000-01-01' and '2020-01-01' group by shopping_category.id");
        List<Object[]> categories = query.list();
        return categories;
    }
}