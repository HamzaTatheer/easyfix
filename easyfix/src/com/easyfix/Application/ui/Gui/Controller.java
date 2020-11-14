package com.easyfix.Application.ui.Gui;
//import java.awt.event.ActionEvent;

import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

//import com.easyfix.Application.bl.serviceProviders;
//Key: controller for login (login.fxml)/register(signup.fxml)
public class Controller extends UI{

    private int userid=-1,workerid=-1;
    @FXML
    private Button signup,register,login;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField pass;
    @FXML
    private TextField city;
    @FXML
    private TextField area;


    String Choice;

    @FXML
    private void handleLoginAction(ActionEvent event) throws Exception{ //login Button action performed


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
        if(userid>0){ //for now HomePage for Customer


            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            controllerHomePage scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferId(userid);
            //close window
            final Node source = (Node) event.getSource();
            final Stage hide = (Stage) source.getScene().getWindow();
            hide.close();
            //Show scene 2 in new window

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }
    }
    @FXML
    private void handleSignupAction(ActionEvent e) throws Exception{ //Don't have an account Button action performed
        Parent root;
        Stage stage;

            stage = (Stage) signup.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        //close window
        final Node source = (Node) e.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
        //Show scene 2 in new window
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleRegisterAction(ActionEvent event) throws Exception{ //Signup button action performed
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
            //close window
            final Node source = (Node) event.getSource();
            final Stage hide = (Stage) source.getScene().getWindow();
            hide.close();
            //Show scene 2 in new window
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            /*
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            controllerHomePage scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferId(userid);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
             */


        }

    }
    public void transferMessage(String message) { //Communication: pass user's choice from Controller1 (Main.fxml) to Controller (Multiple fxml files)
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