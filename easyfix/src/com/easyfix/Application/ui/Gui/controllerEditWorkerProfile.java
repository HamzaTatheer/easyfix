package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


//import java.awt.*;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class controllerEditWorkerProfile extends UI {

    int PCust_id;

    @FXML
    private TextField getcity, getarea, gethourlyrate;
    @FXML
    private Button gotoChangeCity, changecity, changehourlyrate, changearea, gotoChangeArea, gotoChangePayment, home, profile;

    int Cust_id;

    @FXML
    public void handleChangeWorkerCityAction(ActionEvent event) throws Exception {
        if (event.getSource() == changecity) {
            String newCity=getcity.getText();
            boolean change = customerService.changeCity(PCust_id,newCity );
            if (change == true) {
                showAlert("City Changed successfully",Alert.AlertType.INFORMATION);
                sendDatatoHomeScene("workerprofile.fxml",changecity);
            }
        } else if (event.getSource() == home) {
            sendDatatoHomeScene("workerhomepage.fxml",home);
        }
    }

    @FXML
    public void handleChangeWorkerAreaAction(ActionEvent event) throws Exception {
        if (event.getSource() == changearea) {
            boolean change = customerService.changeArea(PCust_id, getarea.getText());
            if (change == true) {
                showAlert("Area Changed successfully",Alert.AlertType.INFORMATION);
                sendDatatoHomeScene("workerprofile.fxml",changearea);
            }
        } else if (event.getSource() == home) {
            sendDatatoHomeScene("workerhomepage.fxml",home);
        }
    }

    @FXML
    public void handleChangeHourlyRateAction(ActionEvent event) throws Exception {
        if (event.getSource() == changehourlyrate) {
            Float rate = Float.valueOf(gethourlyrate.getText()).floatValue();
            boolean change = workerService.changeHourlyRate(PCust_id,rate);
            if (change == true) {
                showAlert("Hourly rate changed successfully",Alert.AlertType.INFORMATION);
                //changeProfileScene("profile.fxml", changepayment);
                sendDatatoHomeScene("workerprofile.fxml",changehourlyrate);
            }
        } else if (event.getSource() == home) {
            sendDatatoHomeScene("workerhomepage.fxml",home);
        }
    }

    public void sendDatatoHomeScene(String file, Button btn) throws Exception {
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        Parent root = loader.load();

        //Get controller of scene2
        controllerWorkerHomePage scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.getWID(PCust_id);

        //Show scene 2 in new window
        Stage stage=(Stage) btn.getScene().getWindow();;
        stage.setScene(new Scene(root));
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
    public void transferWID(int _Cust_id) { //Communication: pass user's id from Controller (Multiple fxml files) to handlebookAction
        //Display the message
        PCust_id = _Cust_id;
    }
    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }
}