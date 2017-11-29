package com.baobaotao.xmlhibernate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;


/**
 * Author: bjccdsrlcr
 * Date: 2017/11/29 0029
 * Time: 11:05
 */
public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        String hql = "UPDATE t_user_test t SET password = :password WHERE username = :username";
        Query query = session.createQuery(hql);
        query.setParameter("password", "1");
        query.setParameter("username", "bjccdsrlcr");
        query.executeUpdate();
        session.close();
    }
}
