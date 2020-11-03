package com.easyfix.Application;

import com.easyfix.Application.ui.Gui.Gui;
import com.easyfix.Application.ui.Terminal.Terminal;
import com.easyfix.Application.ui.UI;

public class Application {

    //public config values
    public static String ui = "terminal";//terminal or gui
    public static String db = "sql";//text or sql

    public static void start(){
        if(ui == "terminal"){
            Terminal terminal = new Terminal();
            terminal.start();
        }
        else if(ui == "gui"){
            Gui gui = new Gui();
            gui.start();
        }
    }

}
