package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.City;
import com.luxoft.financemanager.model.Shop;
import com.luxoft.financemanager.model.ShoppingItem;
import com.luxoft.financemanager.model.User;

import java.util.List;

public interface FinanceManagerDAO {
    void addShoppingItemToDB(ShoppingItem shoppingItem);
    public User getUserByUserName(String userName);
}    List<Shop> listShops();
}

