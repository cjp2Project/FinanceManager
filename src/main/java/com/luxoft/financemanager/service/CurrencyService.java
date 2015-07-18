package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.Currency;

import java.util.List;

public interface CurrencyService {
    void addCurrency(Currency currency);

    void updateCurrency(Currency currency);

    List<Currency> listCurrencies();

    Currency getCurrencyById(int id);

    void removeCurrency(int id);
}
