package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.User;

/**
 * Created by BSzewczyk on 2015-07-19.
 */
public interface FinanceManagerDAO {

    public User getUserByUserName(String userName);
}
