package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.FinanceManagerDAO;
import com.luxoft.financemanager.model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class FinanceManagerServiceImpl implements FinanceManagerService {
    @Autowired
    private FinanceManagerDAO financeManagerDAO;

    @Override
    @Transactional
    public void addShoppingItemToDB(ShoppingItem shoppingItem) {
        financeManagerDAO.addShoppingItemToDB(shoppingItem);
    }

    public void setFinanceManagerDAO(FinanceManagerDAO financeManagerDAO) {
        this.financeManagerDAO = financeManagerDAO;
    }


}
