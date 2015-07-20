package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.City;
import com.luxoft.financemanager.model.Shop;
import com.luxoft.financemanager.model.ShoppingItem;

import java.util.List;

public interface FinanceManagerDAO {
    void addShoppingItemToDB(ShoppingItem shoppingItem);
    List<Shop> listShops();
}

