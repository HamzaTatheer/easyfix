package com.easyfix.Application.ui.Gui.Master;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MasterMainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)throws Exception {
        Parent fxml= FXMLLoader.load(getClass().getResource("MasterXML.fxml"));
        primaryStage.setTitle("EasyFix");
        Scene scene=new Scene(fxml);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
