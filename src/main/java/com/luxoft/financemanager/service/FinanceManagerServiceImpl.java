package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.FinanceManagerDAO;
import com.luxoft.financemanager.dao.FinanceManagerDAOImpl;
import com.luxoft.financemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by BSzewczyk on 2015-07-19.
 */
public class FinanceManagerServiceImpl implements FinanceManagerService {


    private FinanceManagerDAO financeManagerDAO = new FinanceManagerDAOImpl();

    public FinanceManagerDAO getFinanceManagerDAO() {
        return financeManagerDAO;
    }

    public void setFinanceManagerDAO(FinanceManagerDAO financeManagerDAO) {
        this.financeManagerDAO = financeManagerDAO;
    }

    @Override
    public User getUserByUserName(String userName) {
        return financeManagerDAO.getUserByUserName(userName);
    }
}
