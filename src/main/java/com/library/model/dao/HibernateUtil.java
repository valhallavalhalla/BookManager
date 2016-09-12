package com.library.model.dao;

import com.library.model.entity.Author;
import com.library.model.entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class that configure Hibernate, and provides access to {@link SessionFactory}.
 *
 * @author Andrii Shchavinsky
 */
class HibernateUtil {

    private static SessionFactory sessionFactory;

    static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Author.class)
                    .buildSessionFactory();
            return sessionFactory;

        }
    }

}
