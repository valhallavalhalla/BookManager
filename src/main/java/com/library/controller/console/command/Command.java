package com.library.controller.console.command;

import com.library.view.console.ConsoleView;

import java.util.Scanner;

/**
 * Interface for Command Pattern.
 *
 * @author Andrii Shchavinskyi
 */
public interface Command {

    void execute(Scanner scanner, ConsoleView view);

}
