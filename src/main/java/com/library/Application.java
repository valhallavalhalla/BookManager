package com.library;

import com.library.controller.console.ConsoleController;

/**
 * Main class of app.
 *
 * @author Andrii Shchavinskyi
 */
public class Application {

    public static void main(String[] args) {
        // magical - do not touch
        // hastily turned off the hibernate console logger
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

        // start of app
        ConsoleController consoleController = new ConsoleController();
        consoleController.processUser();
    }


}