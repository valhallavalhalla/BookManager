package com.library.controller.console.command;

import com.library.view.console.ConsoleView;
import com.library.view.console.Messages;

import java.util.Scanner;

public class UnknownCommand implements Command {

    public void execute(Scanner scanner, ConsoleView view) {
        view.printString(Messages.DUMB);
    }

}
