package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.City;

import java.util.List;

public interface CityDao {
    void addCity(City p);

    void updateCity(City p);

    List<City> listCities();

    City getCityById(int id);

    void removeCity(int id);
}
