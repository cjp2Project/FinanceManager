package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.FinanceManagerDAO;
import com.luxoft.financemanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class FinanceManagerServiceImpl implements FinanceManagerService {
    @Autowired
    private FinanceManagerDAO financeManagerDAO;

    public void setFinanceManagerDAO(FinanceManagerDAO financeManagerDAO) {
        this.financeManagerDAO = financeManagerDAO;
    }

    @Override
    @Transactional
    public void updateShoppingItemToDB(ShoppingItem shoppingItem) {
        financeManagerDAO.updateShoppingItemToDB(shoppingItem);
    }

    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        return financeManagerDAO.getUserByUserName(userName);
    }

    @Override
    @Transactional
    public void addShoppingItemToDB(ShoppingItem shoppingItem) {
        financeManagerDAO.addShoppingItemToDB(shoppingItem);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Shop> listShops() {
        return financeManagerDAO.listShops();
    }

    @Override
    @Transactional
    public void addCurrency(Currency currency) {
        this.financeManagerDAO.addCurrency(currency);
    }

    @Override
    @Transactional
    public void updateCurrency(Currency currency) {
        this.financeManagerDAO.updateCurrency(currency);
    }

    @Override
    @Transactional
    public List<Currency> listCurrencies() {
        return this.financeManagerDAO.listCurrencies();
    }

    @Override
    @Transactional
    public Currency getCurrencyById(int id) {
        return this.financeManagerDAO.getCurrencyById(id);
    }

    @Override
    @Transactional
    public void removeCurrency(int id) {
        this.financeManagerDAO.removeCurrency(id);
    }

    @Override
    @Transactional
    public void addCity(City city) {
        this.financeManagerDAO.addCity(city);
    }

    @Override
    @Transactional
    public void updateCity(City city) {
        this.financeManagerDAO.updateCity(city);
    }

    @Override
    @Transactional
    public List<ShoppingCategory> listCategories() {
        return this.financeManagerDAO.listCategories();
    }

    @Override
    @Transactional
    public ShoppingCategory getShoppingCategoryById(int id) {
        return this.financeManagerDAO.getShoppingCategoryById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<City> listCities() {
        return this.financeManagerDAO.listCities();
    }

    @Override
    @Transactional
    public City getCityById(int id) {
        return this.financeManagerDAO.getCityById(id);
    }

    @Override
    @Transactional
    public void removeCity(int id) {
        this.financeManagerDAO.removeCity(id);
    }

    @Override
    @Transactional
    public Shop getShopById(int shopId) {
        return this.financeManagerDAO.getShopById(shopId);
    }

    @Override
    public Shop getShop(int id) {
        return financeManagerDAO.getShop(id);
    }

    @Override
    @Transactional
    public ShoppingItem getShoppingItemByID(int id) {
        return financeManagerDAO.getShoppingItemByID(id);
    }

    @Override
    @Transactional
    public void removeShoppingItemByID(int id) {
        financeManagerDAO.removeShoppingItemByID(id);
    }
    @Override
    @Transactional
    public List<Object[]> getUserShoppingCategoriesByDate(int id, String fromDate, String toDate) {
        return financeManagerDAO.getUserShoppingCategoriesByDate(id, fromDate, toDate);
    }
}