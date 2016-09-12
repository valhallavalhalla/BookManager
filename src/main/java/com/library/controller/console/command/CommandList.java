package com.library.controller.console.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum that provides bundle of commands and their string (for user) representation.
 *
 * @author Andrii Shchavinskyi
 */
public enum CommandList {

    AddBookCommand(new AddBookCommand(), CommandNames.ADD_BOOK),
    DeleteBookCommand(new DeleteBookCommand(), CommandNames.REMOVE_BOOK),
    EditBookCommand(new EditBookCommand(), CommandNames.EDIT_BOOK),
    ShowAllBooksCommand(new ShowAllBooksCommand(), CommandNames.SHOW_ALL_BOOKS),
    HelpCommand(new HelpCommand(), CommandNames.HELP),
    UnknownCommand(new UnknownCommand(), CommandNames.UNKNOWN);

    private Command command;
    private String commandName;

    CommandList(Command command, String commandName) {
        this.command = command;
        this.commandName = commandName;
    }

    public static Command getCommandByName(String commandName) {
        for (CommandList commandList: CommandList.values()) {
            if (commandList.commandName.equals(commandName)) {
                return commandList.command;
            }
        }
        return CommandList.UnknownCommand.command;
    }

    public static List<String> getCommandNames() {
        List<String> commandNames = new ArrayList<>(CommandList.values().length);
        for (CommandList commandList: CommandList.values()) {
            commandNames.add(commandList.commandName);
        }
        return commandNames;
    }

}
