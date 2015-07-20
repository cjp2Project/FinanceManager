package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.User;

public interface FinanceManagerService {
    public User getUserByUserName(String userName);
}
