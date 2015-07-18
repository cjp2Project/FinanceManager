package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.CityDao;
import com.luxoft.financemanager.model.City;

import java.util.List;

public class CityServiceImpl implements CityService {
    private CityDao cityDao;

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public void addCity(City city) {
        this.cityDao.addCity(city);
    }

    @Override
    public void updateCity(City city) {
        this.cityDao.updateCity(city);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<City> listCities() {
        return this.cityDao.listCities();
    }

    @Override
    public City getCityById(int id) {
        return this.cityDao.getCityById(id);
    }

    @Override
    public void removeCity(int id) {
        this.cityDao.removeCity(id);
    }
}
