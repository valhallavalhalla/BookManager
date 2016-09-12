package com.library.model.dao;

import com.library.model.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDao implements GenericDao<Author> {

    private static AuthorDao instance;
    private SessionFactory sessionFactory;

    private AuthorDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static AuthorDao getInsctance() {
        if (instance == null) {
            instance = new AuthorDao();
        }
        return instance;
    }

    @Override
    public void save(Author author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Author author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(author);
            session.getTransaction().commit();
        }
    }

    @Override
    public Author findById(int id) {
        Author author;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            author = session.get(Author.class, id);
            session.getTransaction().commit();
        }
        return author;
    }

    @Override
    public void deleteById(int id) {
        Author author = new Author();
        author.setId(id);
        this.delete(author);
    }

    @Override
    public void delete(Author author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Author> findAll() {
        String query = "from com.library.model.entity.Author";
        List<Author> authors;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            authors = session.createQuery(query).getResultList();
            session.getTransaction().commit();
        }
        return authors;
    }

    public List<Author> findByFirstAndLastName(String firstName, String lastName) {
        String query = "from com.library.model.entity.Author author"
                + " where author.firstName = '" + firstName + "'"
                + " and author.lastName = '" + lastName + "'";

        List<Author> authors;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            authors = session.createQuery(query).getResultList();
            session.getTransaction().commit();
        }
        return authors;
    }
}
