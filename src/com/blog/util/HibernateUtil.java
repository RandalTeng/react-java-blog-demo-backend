package com.blog.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * com.blog.util
 *
 * @author Created by randal on 18-6-26.
 */
public class HibernateUtil {
    private static Configuration cfg = null;
    private static SessionFactory factory;

    static{
        cfg = new Configuration();
        cfg.configure();
        factory = cfg.buildSessionFactory();
    }

    public static Session getSession() {
        return factory.openSession();
    }
}
