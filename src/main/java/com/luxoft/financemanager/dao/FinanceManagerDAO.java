package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.*;

import java.util.List;

public interface FinanceManagerDAO {
    void addCity(City p);

    void updateCity(City p);

    List<City> listCities();

    City getCityById(int id);

    void removeCity(int id);

    void addShoppingItemToDB(ShoppingItem shoppingItem);

    public User getUserByUserName(String userName);

    List<Shop> listShops();

    void addCurrency(Currency currency);

    void updateCurrency(Currency currency);

    List<Currency> listCurrencies();

    Currency getCurrencyById(int id);

    void removeCurrency(int id);
}

