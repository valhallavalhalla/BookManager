package com.library.model.dao;

import com.library.model.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao implements GenericDao<Book> {

    private static BookDao instance;
    private SessionFactory sessionFactory;

    private BookDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static BookDao getInsctance() {
        if (instance == null) {
            instance = new BookDao();
        }
        return instance;
    }

    @Override
    public void save(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        }
    }

    @Override
    public Book findById(int id) {
        Book book;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            book = session.get(Book.class, id);
            session.getTransaction().commit();
        }
        return book;
    }

    @Override
    public void deleteById(int id) {
        Book book = new Book();
        book.setId(id);
        this.delete(book);
    }

    @Override
    public void delete(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Book> findAll() {
        String query = "from com.library.model.entity.Book";

        List<Book> books;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            books = session.createQuery(query).getResultList();
            session.getTransaction().commit();
        }
        return books;
    }

    public List<Book> findByTitle(String title) {
        String query = String.format("from com.library.model.entity.Book book where book.title = '%s'", title);

        List<Book> books;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            books = (List<Book>) session.createQuery(query).getResultList();
            session.getTransaction().commit();
        }
        return books;
    }

}
