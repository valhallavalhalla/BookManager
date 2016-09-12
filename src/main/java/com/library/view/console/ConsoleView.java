package com.library.view.console;

/**
 * View part of MVC pattern.
 * Cass provides methods for console view.
 *
 * @author Andrii Shchavinskyi
 */
public class ConsoleView {

    /**
     * Method prints {@link String} to console.
     *
     * @param string to print
     */
    public void printString(String string) {
        System.out.println(string);
    }

    /**
     * Method separates {@link String} array by spaces
     * and print the resulted {@link String} to console.
     *
     * @param strings array to print
     */
    public void printStrings(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s).append(Messages.SPACE);
        }
        // delete last space char
        sb.deleteCharAt(sb.length() - 1);
        printString(sb.toString());
    }

}
