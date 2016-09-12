package com.library.controller.console.command;

import com.library.model.entity.Book;
import com.library.model.service.BookService;
import com.library.view.console.ConsoleView;
import com.library.view.console.Messages;

import java.util.List;
import java.util.Scanner;

public class DeleteBookCommand implements Command {

    private BookService bookService = new BookService();

    @Override
    public void execute(Scanner scanner, ConsoleView view) {
        if (bookService.getAll().isEmpty()) {
            view.printString(Messages.EMPTY_BOOK_LIST);
            return;
        }

        view.printString(Messages.INPUT_BOOK_TITLE_TO_DELETE);
        String bookTitleToDelete = scanner.nextLine();

        List<Book> books = bookService.findByTitle(bookTitleToDelete);


        if (books.isEmpty()) {                                  // if there is no book with that title
            view.printString(Messages.NO_BOOKS_WITH_THAT_TITLE);
        } else if (books.size() == 1) {                         // if there is only one book with that tile
            bookService.deleteById(books.get(0).getId());
            view.printStrings(Messages.SUCCESSFULLY_REMOVED,
                    books.get(0).toFormattedString());
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
                        Book bookToDelete = books.get(option - 1);
                        bookService.deleteById(bookToDelete.getId());
                        view.printStrings(Messages.SUCCESSFULLY_REMOVED, bookToDelete.toFormattedString());
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

}
