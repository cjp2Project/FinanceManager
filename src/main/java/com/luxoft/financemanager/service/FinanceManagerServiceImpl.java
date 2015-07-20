package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.FinanceManagerDAO;
import com.luxoft.financemanager.model.Shop;
import com.luxoft.financemanager.model.ShoppingItem;
import com.luxoft.financemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FinanceManagerServiceImpl implements FinanceManagerService {
    @Autowired
    private FinanceManagerDAO financeManagerDAO;

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

    public void setFinanceManagerDAO(FinanceManagerDAO financeManagerDAO) {
        this.financeManagerDAO = financeManagerDAO;
    }


}
