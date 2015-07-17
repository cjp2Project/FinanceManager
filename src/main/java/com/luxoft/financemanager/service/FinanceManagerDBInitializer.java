package com.luxoft.financemanager.service;

import com.luxoft.financemanager.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FinanceManagerDBInitializer {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        initDB();
    }

    private static void initDB() {
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//===============  CITIES ==============================
        City cityKrakow = new City();
        cityKrakow.setCityName("Krakow");
        session.save(cityKrakow);

        City cityWarszawa = new City();
        cityWarszawa.setCityName("Warszawa");
        session.save(cityWarszawa);

        City cityWroclaw = new City();
        cityWroclaw.setCityName("Wroclaw");
        session.save(cityWroclaw);

//===============  SHOP BRANCHES ==============================
        ShopBranch tesco = new ShopBranch();
        tesco.setBranchName("Tesco");
        session.save(tesco);

        ShopBranch lidl = new ShopBranch();
        lidl.setBranchName("Lidl");
        session.save(lidl);

//===============  CURRENCY ==============================
        Currency pln = new Currency();
        pln.setCurrencyName("PLN");
        session.save(pln);

//===============  SHOPPING CATEGORIES ==============================
        ShoppingCategory grocery = new ShoppingCategory();
        grocery.setShoppingCategoryName("grocery");
        session.save(grocery);

        ShoppingCategory electronics = new ShoppingCategory();
        electronics.setShoppingCategoryName("electronics");
        session.save(electronics);

        ShoppingCategory services = new ShoppingCategory();
        services.setShoppingCategoryName("services");
        session.save(services);

        ShoppingCategory entertainment = new ShoppingCategory();
        entertainment.setShoppingCategoryName("entertainment");
        session.save(entertainment);

        ShoppingCategory householdChemicals= new ShoppingCategory();
        householdChemicals.setShoppingCategoryName("household chemicals");
        session.save(householdChemicals);

        ShoppingCategory other = new ShoppingCategory();
        other.setShoppingCategoryName("other");
        session.save(other);

//===============  SHOPS -> TESCO ==============================
        Shop tescoKrakow1 = new Shop();
        tescoKrakow1.setCity(cityKrakow);
        tescoKrakow1.setShopBranch(tesco);
        tescoKrakow1.setStreet("Kapelanka 54");
        session.save(tescoKrakow1);

        Shop tescoKrakow2 = new Shop();
        tescoKrakow2.setCity(cityKrakow);
        tescoKrakow2.setShopBranch(tesco);
        tescoKrakow2.setStreet("Dobrego Pasterza 67");
        session.save(tescoKrakow2);

        Shop tescoKrakow3 = new Shop();
        tescoKrakow3.setCity(cityKrakow);
        tescoKrakow3.setShopBranch(tesco);
        tescoKrakow3.setStreet("Jozefa Wybickiego 10");
        session.save(tescoKrakow3);

//===============  SHOPS -> LIDL ==============================
        Shop lidlKrakow1 = new Shop();
        lidlKrakow1.setCity(cityKrakow);
        lidlKrakow1.setShopBranch(lidl);
        lidlKrakow1.setStreet("Josepha Conrada 79");
        session.save(lidlKrakow1);

        Shop lidlKrakow2 = new Shop();
        lidlKrakow2.setCity(cityKrakow);
        lidlKrakow2.setShopBranch(lidl);
        lidlKrakow2.setStreet("Henryka Pachonskiego 5B");
        session.save(lidlKrakow2);

        Shop lidlKrakow3 = new Shop();
        lidlKrakow3.setCity(cityKrakow);
        lidlKrakow3.setShopBranch(lidl);
        lidlKrakow3.setStreet("Samuela Bogumila Lindego 1c");
        session.save(lidlKrakow3);

//===============  USER -> defaultUser ==============================
        User defaultUser = new User();
        defaultUser.setUserName("username");
        defaultUser.setPassword("password");
        defaultUser.setEmail("default.user@gmail.com");
        defaultUser.setDefaultReportDate(new Date());
        session.save(defaultUser);

//===============  SHOPPING ITEMS  ==============================
        ShoppingItem shoppingItem1 = new ShoppingItem();
        shoppingItem1.setCurrency(pln);
        shoppingItem1.setAmount(1000);
        shoppingItem1.setDate(new GregorianCalendar(2014, 11, 1).getTime());
        shoppingItem1.setUser(defaultUser);
        shoppingItem1.setShop(lidlKrakow1);
        shoppingItem1.setDescription("shoes Lasocki, Jacket C&A, wallet");
        shoppingItem1.setReceipt(null);
        shoppingItem1.setShoppingCategory(other);
        session.save(shoppingItem1);

        ShoppingItem shoppingItem2 = new ShoppingItem();
        shoppingItem2.setCurrency(pln);
        shoppingItem2.setAmount(20);
        shoppingItem2.setDate(new GregorianCalendar(2014, 11, 1).getTime());
        shoppingItem2.setUser(defaultUser);
        shoppingItem2.setShop(lidlKrakow1);
        shoppingItem2.setDescription("4 rolls, bread, eggs, potatoes");
        shoppingItem2.setReceipt(null);
        shoppingItem2.setShoppingCategory(grocery);
        session.save(shoppingItem2);

        ShoppingItem shoppingItem3 = new ShoppingItem();
        shoppingItem3.setCurrency(pln);
        shoppingItem3.setAmount(2500);
        shoppingItem3.setDate(new GregorianCalendar(2014, 11, 3).getTime());
        shoppingItem3.setUser(defaultUser);
        shoppingItem3.setShop(tescoKrakow1);
        shoppingItem3.setDescription("Samsung TV");
        shoppingItem3.setReceipt(null);
        shoppingItem3.setShoppingCategory(electronics);
        session.save(shoppingItem3);

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
}
