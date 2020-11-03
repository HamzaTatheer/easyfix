package com.easyfix.Application;

import com.easyfix.Application.ui.Gui.Gui;
import com.easyfix.Application.ui.Terminal.Terminal;
import com.easyfix.Application.ui.UI;

public class Application {
    public static void start(){
        String ui = Config.ui;
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
