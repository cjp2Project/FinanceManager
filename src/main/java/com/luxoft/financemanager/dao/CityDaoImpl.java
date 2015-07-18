package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CityDaoImpl implements CityDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
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
        List<City> citiesList = session.createQuery("from City").list();
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
}
