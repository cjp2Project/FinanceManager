package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.City;
import com.luxoft.financemanager.model.Shop;
import com.luxoft.financemanager.model.ShoppingItem;
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
}
