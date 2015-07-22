package com.luxoft.financemanager.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryCreator {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {

        Configuration configuration=new Configuration()
                .configure(); // configures settings from hibernate.cfg.xml

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

        // If you miss the below line then it will complaing about a missing dialect setting
        serviceRegistryBuilder.applySettings(configuration.getProperties());

        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);



        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
