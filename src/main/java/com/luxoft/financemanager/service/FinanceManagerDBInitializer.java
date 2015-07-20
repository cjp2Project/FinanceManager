package com.luxoft.financemanager.service;

public class FinanceManagerDBInitializer {

    public static void main(String[] args) {
        DBLoader loader = new DBLoader();
        loader.initDB();
    }
}
