package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Date;
import java.util.GregorianCalendar;

public class FinanceManagerDBInitializer {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static void main(String[] args) {
        initDB();
    }

    private static void initDB() {
        sessionFactory = getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();

//===============  CITIES ==============================
        City cityKrakow = addCityToDB("Krakow");

        City cityWarszawa = addCityToDB("Warszawa");

        City cityWroclaw = addCityToDB("Wroclaw");

//===============  SHOP BRANCHES ==============================
        ShopBranch tesco = addShopBranchToDB("Tesco");

        ShopBranch lidl = addShopBranchToDB("Lidl");

//===============  CURRENCY ==============================
        Currency pln = addCurrencyToDB("PLN");

        Currency eur = addCurrencyToDB("EUR");

        Currency usd = addCurrencyToDB("USD");

//===============  SHOPPING CATEGORIES ==============================
        ShoppingCategory grocery = addShoppingCategoryToDB("grocery");

        ShoppingCategory electronics = addShoppingCategoryToDB("electronics");

        ShoppingCategory services = addShoppingCategoryToDB("services");

        ShoppingCategory entertainment = addShoppingCategoryToDB("entertainment");

        ShoppingCategory householdChemicals = addShoppingCategoryToDB("household chemicals");

        ShoppingCategory other = addShoppingCategoryToDB("other");

//===============  SHOPS -> TESCO ==============================
        Shop tescoKrakow1 = addShopToDB(cityKrakow, tesco, "Kapelanka 54");

        Shop tescoKrakow2 = addShopToDB(cityKrakow, tesco, "Dobrego Pasterza 67");

        Shop tescoKrakow3 = addShopToDB(cityKrakow, tesco, "Jozefa Wybickiego 10");

//===============  SHOPS -> LIDL ==============================
        Shop lidlKrakow1 = addShopToDB(cityKrakow, lidl, "Josepha Conrada 79");

        Shop lidlKrakow2 = addShopToDB(cityKrakow, lidl, "Henryka Pachonskiego 5B");

        Shop lidlKrakow3 = addShopToDB(cityKrakow, lidl, "Samuela Bogumila Lindego 1c");

//===============  USER -> defaultUser ==============================
        User defaultUser = addUserToDB("username", "password", "default.user@gmail.com", new Date());

//===============  SHOPPING ITEMS  ==============================
        addShoppingItemToDB(lidlKrakow1, other, defaultUser, pln, 1000,
                new GregorianCalendar(2014, 11, 1).getTime(), "shoes Lasocki, Jacket C&A, wallet", null);

        addShoppingItemToDB(lidlKrakow1, grocery, defaultUser, pln, 20,
                new GregorianCalendar(2014, 11, 1).getTime(), "4 rolls, bread, eggs, potatoes", null);

        addShoppingItemToDB(tescoKrakow1, electronics, defaultUser, pln, 2500,
                new GregorianCalendar(2014, 11, 3).getTime(), "Samsung TV", null);


        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void addShoppingItemToDB(Shop shop, ShoppingCategory shoppingCategory, User user, Currency currency,
                                            float amount, Date shoppingDate, String description, byte[] receiptScan) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setCurrency(currency);
        shoppingItem.setAmount(amount);
        shoppingItem.setDate(shoppingDate);
        shoppingItem.setUser(user);
        shoppingItem.setShop(shop);
        shoppingItem.setDescription(description);
        shoppingItem.setReceipt(receiptScan);
        shoppingItem.setShoppingCategory(shoppingCategory);
        session.save(shoppingItem);
    }

    private static User addUserToDB(String userName, String password, String email, Date defaultReportDate) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setDefaultReportDate(defaultReportDate);
        session.save(user);

        return user;
    }

    private static Shop addShopToDB(City city, ShopBranch shopBranch, String street) {
        Shop shop = new Shop();
        shop.setCity(city);
        shop.setShopBranch(shopBranch);
        shop.setStreet(street);
        session.save(shop);

        return shop;
    }

    private static ShoppingCategory addShoppingCategoryToDB(String categoryName) {
        ShoppingCategory shoppingCategory = new ShoppingCategory();
        shoppingCategory.setShoppingCategoryName(categoryName);
        session.save(shoppingCategory);

        return shoppingCategory;
    }

    private static Currency addCurrencyToDB(String currencyName) {
        Currency currency = new Currency();
        currency.setCurrencyName(currencyName);
        session.save(currency);

        return currency;
    }

    private static ShopBranch addShopBranchToDB(String shopBranchName) {
        ShopBranch shopBranch = new ShopBranch();
        shopBranch.setBranchName(shopBranchName);
        session.save(shopBranch);

        return shopBranch;
    }

    private static City addCityToDB(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        session.save(city);

        return city;
    }
}
