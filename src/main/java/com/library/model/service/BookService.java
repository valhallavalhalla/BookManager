package com.library.model.service;

import com.library.model.dao.BookDao;
import com.library.model.entity.Author;
import com.library.model.entity.Book;

import java.util.List;

/**
 * Class provides service layer for {@link Book} entity.
 *
 * @author Andrii Shchavinskyi
 */
public class BookService implements BaseService<Book> {

    private BookDao bookDao;
    private AuthorService authorService;

    public BookService() {
        this.bookDao = BookDao.getInsctance();
        this.authorService = new AuthorService();
    }

    /**
     * Method that adds new {@link Book} into database.
     *
     * If there is no {@link Author} in database,
     * then fully creates new entries in database, and return true.
     * Else:
     *  If database already contains {@link Book} objects with
     *  same titles as added objcet, search is that added {@link Book} have the same
     *  {@link Author} with existed {@link Book} objects.
     *
     *  If found match - return false, and don't insert anything
     *  in database.
     *  Else, set for added {@link Book} existed database {@link Author}
     *  object and return true.
     *
     * @param book to insert into database
     * @return true, if {@link Book} successfully added
     *         otherwise - return false
     */
    public boolean add(Book book) {
        Author bookAuthor = authorService.findByFirstAndLastName(book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName());

        if (bookAuthor == null) {
            authorService.add(book.getAuthor());
            bookDao.save(book);
            return true;
        } else {
            List<Book> booksWithSameTitle = this.findByTitle(book.getTitle());
            for (Book bookWithSameTitle: booksWithSameTitle) {
                if (bookWithSameTitle.getAuthor().equals(bookAuthor)) {
                    return false;
                }
            }
            book.setAuthor(bookAuthor);
            bookDao.save(book);
            return true;
        }
    }


    /**
     * Method that updates {@link Book} in database.
     *
     * If there is no updated {@link Author} in database,
     * then fully creates new entries in database, and return true.
     * Else:
     *  If database already contains {@link Book} objects with
     *  same titles as updated object, search is that updated
     *  {@link Book} have the same {@link Author} with existed {@link Book} objects.
     *
     *  If found match - return false, and don't update anything
     *  in database.
     *  Else, set for updated {@link Book} existed database {@link Author}
     *  object and return true.
     *
     * @param book to update into database
     * @return true, if {@link Book} successfully updated
     *         otherwise - return false
     */
    public boolean edit(Book book) {
        Author bookAuthor = authorService.findByFirstAndLastName(book.getAuthor().getFirstName(),
                book.getAuthor().getLastName());

        if (bookAuthor == null) {
            authorService.edit(book.getAuthor());
            bookDao.update(book);
            return true;
        } else {
            List<Book> booksWithSameTitle = this.findByTitle(book.getTitle());
            for (Book bookWithSameTitle: booksWithSameTitle) {
                if (bookWithSameTitle.getAuthor().equals(bookAuthor)) {
                    return false;
                }
            }
            book.setAuthor(bookAuthor);
            bookDao.update(book);
            return true;
        }

    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public Book getById(int id) {
        return bookDao.findById(id);
    }

    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }

}
