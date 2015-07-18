package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.CurrencyDao;
import com.luxoft.financemanager.model.City;
import com.luxoft.financemanager.model.Currency;
import org.hibernate.Session;

import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyDao dao;

    public void setDao(CurrencyDao dao) {
        this.dao = dao;
    }

    @Override
    public void addCurrency(Currency currency) {
        this.dao.addCurrency(currency);
    }

    @Override
    public void updateCurrency(Currency currency) {
        this.dao.updateCurrency(currency);
    }

    @Override
    public List<Currency> listCurrencies() {
        return this.dao.listCurrencies();
    }

    @Override
    public Currency getCurrencyById(int id) {
        return this.dao.getCurrencyById(id);
    }

    @Override
    public void removeCurrency(int id) {
        this.dao.removeCurrency(id);
    }
}
