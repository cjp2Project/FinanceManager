package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.*;

import java.sql.Date;
import java.util.List;

public interface FinanceManagerService {
    void addShoppingItemToDB(ShoppingItem shoppingItem);

    public User getUserByUserName(String userName);

    List<Shop> listShops();

    void addCurrency(Currency currency);

    void updateCurrency(Currency currency);

    List<Currency> listCurrencies();

    Currency getCurrencyById(int id);

    void removeCurrency(int id);

    void addCity(City p);

    void updateCity(City p);

    List<ShoppingCategory> listCategories();

    ShoppingCategory getShoppingCategoryById(int id);

    List<City> listCities();

    City getCityById(int id);

    void removeCity(int id);

    Shop getShop(int id);
    public ShoppingItem getShoppingItemByID(int id);

    void removeShoppingItemByID(int id);

    Shop getShopById(int shopId);

    void updateShoppingItemToDB(ShoppingItem shoppingItem);
     List<Object[]> getUserShoppingCategoriesByDate(int id, String fromDate, String toDate);
}
