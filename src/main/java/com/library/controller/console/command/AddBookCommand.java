package com.library.controller.console.command;

import com.library.model.entity.Author;
import com.library.model.entity.Book;
import com.library.model.service.BookService;
import com.library.view.console.ConsoleView;
import com.library.view.console.Messages;

import java.util.Scanner;

public class AddBookCommand implements Command {

    private BookService bookService = new BookService();

    public void execute(Scanner scanner, ConsoleView view) {
        view.printString(Messages.INPUT_BOOK_AUTHOR_FIRST_NAME);
        String authorFirstName = scanner.nextLine();

        view.printString(Messages.INPUT_BOOK_AUTHOR_LAST_NAME);
        String authorLastName = scanner.nextLine();

        view.printString(Messages.INPUT_BOOK_TITLE);
        String title = scanner.nextLine();

        Book book = new Book(new Author(authorFirstName, authorLastName), title);
        boolean result = bookService.add(book);

        if (result) {
            view.printStrings(Messages.HAS_REMEMBERED, book.toFormattedString());
        } else {
            view.printString(Messages.BOOK_ALREADY_EXIST);
        }
    }

}
