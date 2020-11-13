package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class controllerHomePage extends UI {
    private int Cust_id;
    @FXML
    private Button BookWorker;

    @FXML
    private Button ShowFavourites;

    @FXML
    private Button showFinishedBooking;

    @FXML
    private Button showActiveBooking;

    @FXML
    private Button logout;

    @FXML
    private Button EditProfile1;

    @FXML
    public void handleBookWorkerAction(ActionEvent event) throws IOException {
        //System.out.println("Customer Id " + Cust_id+"\n"); //Cust_id passed to Book Worker
        try {
            Parent root;
            Stage stage;
            stage = (Stage) BookWorker.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("BookWorkerXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception E){
            E.getMessage();
        }
    }

    @FXML
    public void handleEditProfile1Action(ActionEvent event) {

    }

    @FXML
    public void handleLogout(ActionEvent event) {

    }

    @FXML
    public void handleShowFavouritesAction(ActionEvent event) {

    }

    @FXML
    public void handleShowFinishedBooking(ActionEvent event) {

    }

    @FXML
    public void handleshowActiveBooking(ActionEvent event) {

    }
    public void transferId(int _Cust_id) { //Communication: pass user's choice from Controller1 (Main.fxml) to Controller (Multiple fxml files)
        //Display the message
        Cust_id=_Cust_id;
    }
}
