package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Date;
import java.util.GregorianCalendar;

public class DBLoader {
    private SessionFactory sessionFactory = SessionFactoryCreator.getSessionFactory();
    private Session session;

    public void initDB() {
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

//===============  ROLE  ==============================
        Role admin = addRoleToDB("admin");

        Role user = addRoleToDB("user");
//===============  USER -> defaultUser ==============================
        User defaultUser = addUserToDB("username", "password", "default.user@gmail.com", new Date(), admin);

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
    private Role addRoleToDB(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        session.save(role);

        return role;
    }

    private void addShoppingItemToDB(Shop shop, ShoppingCategory shoppingCategory, User user, Currency currency,
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

    private User addUserToDB(String userName, String password, String email, Date defaultReportDate, Role role) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setDefaultReportDate(defaultReportDate);
        user.setRole(role);
        session.save(user);

        return user;
    }

    private Shop addShopToDB(City city, ShopBranch shopBranch, String street) {
        Shop shop = new Shop();
        shop.setCity(city);
        shop.setShopBranch(shopBranch);
        shop.setStreet(street);
        session.save(shop);

        return shop;
    }

    private ShoppingCategory addShoppingCategoryToDB(String categoryName) {
        ShoppingCategory shoppingCategory = new ShoppingCategory();
        shoppingCategory.setShoppingCategoryName(categoryName);
        session.save(shoppingCategory);

        return shoppingCategory;
    }

    private Currency addCurrencyToDB(String currencyName) {
        Currency currency = new Currency();
        currency.setCurrencyName(currencyName);
        session.save(currency);

        return currency;
    }

    private ShopBranch addShopBranchToDB(String shopBranchName) {
        ShopBranch shopBranch = new ShopBranch();
        shopBranch.setBranchName(shopBranchName);
        session.save(shopBranch);

        return shopBranch;
    }

    private City addCityToDB(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        session.save(city);

        return city;
    }
}
