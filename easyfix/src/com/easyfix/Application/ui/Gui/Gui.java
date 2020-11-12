package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.Gui.Master.MasterMainApp;
import com.easyfix.Application.ui.UI;
import javafx.application.Application;

public class Gui extends UI {

    public Gui() {
        super();

    }
    public static void start() {
        Application.launch(MasterMainApp.class);
    }
}

