package com.library.model.entity;

import javax.persistence.*;

/**
 * Class represents entity of book.
 *
 * @author Andrii Shchavinskyi
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Author author;

    @Column(name = "title")
    private String title;

    public Book() {

    }

    public Book(Author author, String title) {
        this.author = author;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                '}';
    }

    public String toFormattedString() {
        return "Author: " + author.getFirstName() +
                " " + author.getLastName() +
                ", Title: '" + title + "'";
    }

}
