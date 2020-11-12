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

import javax.swing.*;

public class Controller extends UI{

    int userid=0,workerid=0;
    @FXML
    private Label label;
    @FXML
    private Button signup,register,login,next;
    @FXML
    private TextField name,email,pass,city,area,choice;

    String Choice;

    @FXML
    private void handleLoginAction(ActionEvent event) throws Exception{


        try {
            System.out.println(email.getText()+ pass.getText());

            System.out.println("cc "+Choice);
            if(Choice.equals("customer"))
                userid = customerService.login(email.getText(),pass.getText());

            else if(Choice.equals("worker"))
                workerid = workerService.login(email.getText(),pass.getText());
            System.out.println(userid);
            System.out.println("Login Successful");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(userid>0 || workerid>0){
            Parent root;
            Stage stage;

            stage = (Stage) login.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("homepage.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    private void handleSignupAction(ActionEvent e) throws Exception{
        Parent root;
        Stage stage;

            stage = (Stage) signup.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("signup.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleRegisterAction(ActionEvent event) throws Exception{
        int cid=0;
        try {
            cid = customerService.register(name.getText(),email.getText(),pass.getText(),"123",city.getText(),area.getText());
            System.out.println("Signup successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(cid>0){
            Parent root;
            Stage stage;

            stage = (Stage) register.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("homepage.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
    public void transferMessage(String message) {
        //Display the message
        Choice=message;
    }
  /*  @FXML
    private void handleMainAction(ActionEvent event) throws Exception{
        Choice=choice.getText();
        System.out.println(Choice);
        Parent root;
        Stage stage;

        stage = (Stage) next.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }*/
    //@Override
    public void initialize(URL url, ResourceBundle resources) {
        // Initialization code can go here.
        // The parameters url and resources can be omitted if they are not needed
    }

}