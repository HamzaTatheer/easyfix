package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//import java.awt.*;
//import java.awt.event.ActionEvent;

public class controllerEditProfile extends UI {

    int PCust_id;

    @FXML
    private TextField getcity, getarea, getpayment;
    @FXML
    private Button gotoChangeCity, changecity, changepayment, changearea, gotoChangeArea, gotoChangePayment, home, profile;

    int Cust_id;

    @FXML
    public void handleChangeCityAction(ActionEvent event) throws Exception {
        if (event.getSource() == changecity) {
            boolean change = customerService.changeCity(PCust_id, getcity.getText());
            if (change == true) {
                System.out.println("City Changed successfully");
                changeProfileScene("profile.fxml", changecity);
            }
        } else if (event.getSource() == home) {
            changeProfileScene("homepage.fxml", home);
        }
    }

    @FXML
    public void handleChangeAreaAction(ActionEvent event) throws Exception {
        if (event.getSource() == changearea) {
            boolean change = customerService.changeArea(PCust_id, getarea.getText());
            if (change == true) {
                System.out.println("Area Changed successfully");
                changeProfileScene("profile.fxml", changearea);
            }
        } else if (event.getSource() == home) {
            changeProfileScene("homepage.fxml", home);
        }
    }

    @FXML
    public void handleChangePaymentAction(ActionEvent event) throws Exception {
        if (event.getSource() == changepayment) {
            boolean change = customerService.changePaymentMethod(PCust_id, getpayment.getText());
            if (change == true) {
                System.out.println("Payment Method Changed successfully");
                changeProfileScene("profile.fxml", changepayment);
            }
        } else if (event.getSource() == home) {
            changeProfileScene("homepage.fxml", home);
        }
    }

    public void changeProfileScene(String file, Button btn) throws Exception {
        Parent root;
        Stage stage;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(file));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sendDatatoProfileScenes(String file,Button btn)throws Exception{
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        Parent root = loader.load();

        //Get controller of scene2
        controllerEditProfile scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.transferID(Cust_id);

        //Show scene 2 in new window
        Stage stage=(Stage) btn.getScene().getWindow();;
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void transferID(int _Cust_id) { //Communication: pass user's id from Controller (Multiple fxml files) to handlebookAction
        //Display the message
        PCust_id = _Cust_id;
    }


}