package com.easyfix.Application.ui.Gui;
//import java.awt.event.ActionEvent;

import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

//import com.easyfix.Application.bl.serviceProviders;

public class Controller extends UI{

    int userid=0,workerid=0;
    @FXML
    private Label label;
    @FXML
    private Button signup,register,login,next,gotochangecity,changecity,profile;
    @FXML
    private TextField name,email,pass,city,area,choice,getcity;

    static String Choice;

    @FXML
    private void handleLoginAction(ActionEvent event) throws Exception{


        try {
            System.out.println(email.getText()+ pass.getText());

            System.out.println("cc "+Choice);
            if(Choice.equals("customer"))
                userid = customerService.login(email.getText(),pass.getText());

            else if(Choice.equals("worker"))
                workerid = workerService.login(email.getText(),pass.getText());
            System.out.println("Login Successful");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(userid>0){

            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            controllerHomePage scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferId(userid);

            //Show scene 2 in new window
            Stage stage=(Stage) login.getScene().getWindow();;
            stage.setScene(new Scene(root));
            stage.show();
        }
        else if(workerid>0){
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("workerhomepage.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            controllerWorkerHomePage scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.getWID(workerid);

            //Show scene 2 in new window
            Stage stage=(Stage) login.getScene().getWindow();;
            stage.setScene(new Scene(root));
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
    @FXML
    private void handleHomeAction(ActionEvent event)throws  Exception{
        Parent root;
        Stage stage;

        stage = (Stage) changecity.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //@Override
    public void initialize(URL url, ResourceBundle resources) {
        // Initialization code can go here.
        // The parameters url and resources can be omitted if they are not needed
    }

}