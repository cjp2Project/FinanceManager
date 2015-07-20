package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.Shop;
import com.luxoft.financemanager.model.ShoppingItem;
import com.luxoft.financemanager.model.User;

import java.util.List;

public interface FinanceManagerService {
    void addShoppingItemToDB(ShoppingItem shoppingItem);
    public User getUserByUserName(String userName);

    List<Shop> listShops();
}
