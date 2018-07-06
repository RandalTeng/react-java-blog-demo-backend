package com.blog.dao;

import com.blog.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.blog.dao
 *
 * @author Created by randal on 18-6-27.
 */
@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    @Transactional
    public User findByUsername(String username) {
        String findSql = "from User u where u.username = :username";
        Session session = getSession();
        Query query = session.createQuery(findSql);
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        closeSession(session);
        return user;
    }
}
