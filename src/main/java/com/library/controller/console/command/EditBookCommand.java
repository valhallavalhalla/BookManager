package com.library.controller.console.command;

import com.library.model.entity.Book;
import com.library.model.service.BookService;
import com.library.view.console.ConsoleView;
import com.library.view.console.Messages;

import java.util.List;
import java.util.Scanner;

public class EditBookCommand implements Command {

    private BookService bookService = new BookService();

    @Override
    public void execute(Scanner scanner, ConsoleView view) {
        if (bookService.getAll().isEmpty()) {
            view.printString(Messages.EMPTY_BOOK_LIST);
            return;
        }

        view.printString(Messages.EDIT_BOOK_INFO);
        String bookTitleToEdit = scanner.nextLine();

        List<Book> books = bookService.findByTitle(bookTitleToEdit);

        if (books.isEmpty()) {
            view.printString(Messages.NO_BOOKS_WITH_THAT_TITLE);
        } else if (books.size() == 1) {
            Book updatedBook = getUpdatedBook(scanner, view, books.get(0));
            if (bookService.edit(updatedBook)) {
                view.printStrings(Messages.EDIT_BOOK_INFO_COMPLETE);
            } else {
                view.printString(Messages.FULL_SAME_INFO);
            }
        } else {                                                // if there several books with that title
            view.printString(Messages.SAME_TITLE_BOOKS);
            for (int i = 1; i <= books.size(); i++) {
                view.printStrings(String.valueOf(i), books.get(i - 1).toFormattedString());
            }
            while (scanner.hasNextLine()) {
                String userInput = scanner.nextLine();
                try {
                    int option = Integer.valueOf(userInput);
                    if (option > 0 && option <= books.size()) {
                        Book updatedBook = getUpdatedBook(scanner, view, books.get(option - 1));
                        if (bookService.edit(updatedBook)) {
                            view.printStrings(Messages.EDIT_BOOK_INFO_COMPLETE);
                        } else {
                            view.printString(Messages.FULL_SAME_INFO);
                        }
                        break;
                    } else {
                        view.printString(Messages.CHOOSE_NUMBER_IN_LIST);
                    }
                } catch (Exception e) {
                    view.printString(Messages.CHOOSE_NUMBER_IN_LIST);
                }
            }
        }

    }

    private Book getUpdatedBook(Scanner scanner, ConsoleView view, Book editedBook) {
        view.printString(Messages.TYPE_NEW_BOOK_TITLE);
        String newTitle = scanner.nextLine();

        view.printString(Messages.TYPE_NEW_AUTHOR_FIRST_NAME);
        String newAuthorFirstName = scanner.nextLine();

        view.printString(Messages.TYPE_NEW_AUTHOR_LAST_NAME);
        String newAuthorLastName = scanner.nextLine();

        editedBook.getAuthor().setFirstName(newAuthorFirstName);
        editedBook.getAuthor().setLastName(newAuthorLastName);
        editedBook.setTitle(newTitle);

        return editedBook;
    }

}
