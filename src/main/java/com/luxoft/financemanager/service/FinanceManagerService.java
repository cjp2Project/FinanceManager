package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.Shop;
import com.luxoft.financemanager.model.ShoppingItem;

import java.util.List;

public interface FinanceManagerService {
    void addShoppingItemToDB(ShoppingItem shoppingItem);

    List<Shop> listShops();
}
