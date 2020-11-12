package com.easyfix.Application;

//import com.easyfix.Application.ui.Gui.Gui;
import com.easyfix.Application.ui.Gui.Gui;
import com.easyfix.Application.ui.Terminal.Terminal;

public class Application {
    public static void start() throws Exception {
        String ui = Config.ui;

        System.out.println("User Interface: " + Config.ui);
        System.out.println("Database: "+ Config.db);

        if(ui == "terminal"){
            Terminal terminal = new Terminal();
            terminal.start();
        }
        else if(ui == "gui"){
            Gui g = new Gui();
            Gui.start();

        }
    }

}
