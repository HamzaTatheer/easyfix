package com.easyfix.Application;

//import com.easyfix.Application.ui.Gui.Gui;
import com.easyfix.Application.ui.Gui.Gui;
import com.easyfix.Application.ui.Terminal.Terminal;
import com.easyfix.Application.ui.UI;
import com.sun.java.accessibility.util.GUIInitializedListener;

public class Application {
    public static void start(){
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
