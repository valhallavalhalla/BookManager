package com.library.controller.console.command;

import com.library.view.console.ConsoleView;
import com.library.view.console.Messages;

import java.util.Scanner;

public class HelpCommand implements Command {

    @Override
    public void execute(Scanner scanner, ConsoleView view) {

        view.printString(Messages.LIST_OF_COMMANDS);
        for (String commandName: CommandList.getCommandNames()) {
            if (!(commandName.equals(CommandNames.HELP) || commandName.equals(CommandNames.UNKNOWN))) {
                view.printString(commandName);
            }
        }

    }

}
