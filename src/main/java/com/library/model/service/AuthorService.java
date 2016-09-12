package com.library.model.service;

import com.library.model.dao.AuthorDao;
import com.library.model.entity.Author;

import java.util.List;

/**
 * Class provides service layer for {@link Author} entity.
 *
 * @author Andrii Shchavinskyi
 */
public class AuthorService implements BaseService<Author> {

    private AuthorDao authorDao;

    public AuthorService() {
        authorDao = AuthorDao.getInsctance();
    }

    public boolean add(Author author) {
        authorDao.save(author);
        return true;
    }

    public boolean edit(Author author) {
        authorDao.update(author);
        return true;
    }

    public void deleteById(int id) {
        authorDao.deleteById(id);
    }

    public Author getById(int id) {
        return authorDao.findById(id);
    }

    public List<Author> getAll() {
        return authorDao.findAll();
    }

    /**
     * Method gets result of {@link AuthorDao} search for {@link Author}
     * by first and last name.
     * First name and last name is unique bundle, so in result of search
     * it always be only one {@link Author} object.
     *
     * @param firstName of {@link Author}
     * @param lastName of {@link Author}
     * @return {@link Author} object
     */
    public Author findByFirstAndLastName(String firstName, String lastName) {
        List<Author> authors = authorDao.findByFirstAndLastName(firstName, lastName);
        if (authors.isEmpty()) {
            return null;
        }
        return authors.get(0);
    }

}
