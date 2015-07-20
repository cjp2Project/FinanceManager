package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.ShoppingItem;
import com.luxoft.financemanager.model.User;

public interface FinanceManagerService {
    void addShoppingItemToDB(ShoppingItem shoppingItem);
    public User getUserByUserName(String userName);
}