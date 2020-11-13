package com.easyfix.Application.ui.Gui;
//import java.awt.event.ActionEvent;
import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

//import com.easyfix.Application.bl.serviceProviders;
//controller for choice (Main.fxml)
public class controller1 extends UI{
    @FXML
    private Button next;
    @FXML
    private TextField choice;
    @FXML
    private void handleMainAction(ActionEvent event) throws Exception{
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            Controller scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferMessage(choice.getText());

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}