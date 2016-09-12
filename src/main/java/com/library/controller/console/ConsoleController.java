package com.library.controller.console;


import com.library.controller.console.command.CommandList;
import com.library.view.console.ConsoleView;
import com.library.view.console.Messages;
import java.util.Scanner;

/**
 * Controller part of MVC pattern.
 * Provides console interface.
 *
 * @author Andrii Shchavinskyi
 */
public class ConsoleController {

    private ConsoleView consoleView;

    private Scanner scanner;

    public ConsoleController() {
        scanner = new Scanner(System.in);
        consoleView = new ConsoleView();
    }

    public void processUser() {
        printGreetings();
        while(scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            CommandList.getCommandByName(userInput).execute(scanner, consoleView);
        }
    }

    private void printGreetings() {
        consoleView.printString(Messages.WELCOME_MESSAGE);
    }



}
