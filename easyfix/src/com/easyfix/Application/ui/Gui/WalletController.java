package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WalletController extends UI {
    private int C_I_D;
    private int W_I_D;
    @FXML
    private Button home;

    @FXML
    private Button paybill;

    @FXML
    private TextField walletText;
    @FXML
    private TextField CustomerEmailText;

    @FXML
    void handleWalletHome(ActionEvent event) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("workerhomepage.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            controllerWorkerHomePage scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here

            scene2Controller.getWID(W_I_D);

            //Show scene 2 in new window
            Stage stage = (Stage) home.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }

    @FXML
    void handleaddtowallet(ActionEvent event) {
        try {
            customerService.addToWallet(C_I_D,Float.parseFloat(walletText.getText()));
            showAlert("Amount added", Alert.AlertType.INFORMATION);

        }
        catch (Exception E){
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }
    public void initialize_ids(int _c,int _w){
        try {


            C_I_D = _c;
            W_I_D = _w;
            CustomerModel get = customerService.getCustomerDetails(C_I_D);
            CustomerEmailText.setText(get.email);
            CustomerEmailText.setEditable(false);
        }
        catch (Exception e){
            showAlert(e.getMessage(), Alert.AlertType.INFORMATION);
        }

    }
    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
