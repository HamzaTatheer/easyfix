package com.easyfix.Application.ui.Gui;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import com.easyfix.Application.models.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import com.easyfix.Application.bl.serviceProviders;
import com.easyfix.Application.bl.services.BookingService;
import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.application.Application;
import com.easyfix.Application.models.WorkerModel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import com.easyfix.Application.bl.classes.SparePart;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import com.easyfix.Application.bl.services.CustomerService;
//import com.easyfix.Application.bl.serviceProviders;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}