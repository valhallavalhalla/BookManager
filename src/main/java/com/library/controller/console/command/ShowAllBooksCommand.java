package com.library.controller.console.command;

import com.library.model.entity.Book;
import com.library.model.service.BookService;
import com.library.view.console.ConsoleView;
import com.library.view.console.Messages;

import java.util.List;
import java.util.Scanner;

public class ShowAllBooksCommand implements Command {

    private BookService bookService;

    public ShowAllBooksCommand() {
        bookService = new BookService();
    }

    public void execute(Scanner scanner, ConsoleView view) {
        List<Book> books = bookService.getAll();
        if (books.isEmpty()) {
            view.printString(Messages.EMPTY_BOOK_LIST);
        } else {
            view.printString(Messages.HERE_BOOK_LIST);
            for (Book book: books) {
                view.printString(book.toFormattedString());
            }
        }
    }


}
