package com.easyfix.Application.ui.Gui.Master;

//import com.easyfix.Application.ui.Gui.Master.LoginCustomer.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.swing.*;

import javafx.stage.Stage;

public class MasterController implements Initializable {
    @FXML
    private TextField txt_1;

    @FXML
    void checkWCLogin(ActionEvent event) throws IOException {
        String message=txt_1.getText();
        if(message.equalsIgnoreCase("Worker")){
            JOptionPane.showMessageDialog(null,"Worker Successful");
            //Parent fxml= FXMLLoader.load(getClass().getResource("MasterXML.fxml"));

        }
        else if(message.equalsIgnoreCase("Customer")){
            JOptionPane.showMessageDialog(null,"Customer Successful");
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current relative path is: " + s);
            Parent loader = FXMLLoader.load(getClass().getResource("LoginCustomerXML.fxml"));
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene mainScene = new Scene(loader);
            mainStage.setScene(mainScene);
            mainStage.show();
        }
        else
            JOptionPane.showMessageDialog(null,"Invalid Input!!!!!!!!!!! Please Enter Worker or Customer");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
