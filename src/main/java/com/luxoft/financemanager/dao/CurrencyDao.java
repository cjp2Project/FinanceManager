package com.luxoft.financemanager.dao;

import com.luxoft.financemanager.model.City;
import com.luxoft.financemanager.model.Currency;

import java.util.List;

public interface CurrencyDao {
    void addCurrency(Currency currency);

    void updateCurrency(Currency currency);

    List<Currency> listCurrencies();

    Currency getCurrencyById(int id);

    void removeCurrency(int id);
}
