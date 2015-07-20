package com.luxoft.financemanager.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryCreator {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
