package com.bakalis.struts.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.bakalis.models.*;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {

                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties

                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/dissertation?useSSL=false");

                settings.put(Environment.USER, "root");

                settings.put(Environment.PASS, "");

                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                
                
                
                
                //ADDING ENTITIES HERE

                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(SingleTransaction.class);
                configuration.addAnnotatedClass(User.class);
                
                
                // END OF ENTITIES ADDITION
                
                
                
               

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()

                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return sessionFactory;

    }
}
