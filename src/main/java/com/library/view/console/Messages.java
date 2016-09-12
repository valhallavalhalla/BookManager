package com.library.view.console;

/**
 * Messages that bot operates.
 *
 * @author Andrii Shchavinskyi
 */
public interface Messages {

    String WELCOME_MESSAGE = "Hello, I'm book manager!\n" +
            "I can help you to save the books that you want to read in future!\n" +
            "Type 'help', to get more info about my possibilities :)";
    String LIST_OF_COMMANDS = "Here is a list of things that I can do for you" +
            "(just type one of that commands to make me helpful) :";
    String SPACE = " ";
    String DUMB = "Sorry, i can't understand you :(\n" +
            "Type 'help', to get more info about my possibilities.";
    String INPUT_BOOK_AUTHOR_FIRST_NAME = "Type first name of book author";
    String INPUT_BOOK_AUTHOR_LAST_NAME = "Type last name of book author";
    String INPUT_BOOK_TITLE = "Type book title";
    String NO_BOOKS_WITH_THAT_TITLE = "Sorry, but there is no books with that title :(";
    String EMPTY_BOOK_LIST = "I'm sorry, but my notes, about your books, are empty :(\n" +
            "You can type 'add book' so I started to make a note about new book :) ";
    String HERE_BOOK_LIST = "Here list of all books that you saved: ";
    String HAS_REMEMBERED = "Has remembered:";
    String BOOK_ALREADY_EXIST = "Hey, i already have that book in my notes.";
    String INPUT_BOOK_TITLE_TO_DELETE = "Already read some book?\n" +
            "Please, write the book title, and i will delete it from my notes.";
    String SAME_TITLE_BOOKS = "Oops. There a several books with same title.\n" +
            "Please, choose one by typing position in following list:";
    String SUCCESSFULLY_REMOVED = "Great, i removed";
    String CHOOSE_NUMBER_IN_LIST = "Please choose number of book in list to delete.";
    String EDIT_BOOK_INFO = "Something wrong with my notes?\n" +
            "Okay, type book name, and i will help to edit book info :)";
    String TYPE_NEW_BOOK_TITLE = "Type new title of book";
    String TYPE_NEW_AUTHOR_FIRST_NAME = "Type new first name of book author";
    String TYPE_NEW_AUTHOR_LAST_NAME = "Type new last name of book author";
    String EDIT_BOOK_INFO_COMPLETE = "Good, i successfully changed my notes about that book :)";
    String FULL_SAME_INFO = "I'm sorry, but i already have in my notes a book\n" +
            " with exactly the same info as you typed.";

}
