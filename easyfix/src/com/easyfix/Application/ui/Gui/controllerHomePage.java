package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

//import java.awt.*;
//import java.awt.event.ActionEvent;

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
    private Button gotoChangeCity,gotoChangeArea,gotoChangePayment,home,profile,finishedbooking;
    @FXML
    private Button PendingBook;

    @FXML
    void HandlePendingBookings(ActionEvent event) {

            try {
                ArrayList<BookingModel> getBook = bookingService.showPendingBookingsOfCustomer(Cust_id);//get all active bookings by cust_id
                //Load second scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowPendingBookings.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                ShowPendingBookingsController scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.initializePendingBookings(getBook,Cust_id,0);

                //close window
                final Node source = (Node) event.getSource();
                final Stage hide = (Stage) source.getScene().getWindow();
                hide.close();
                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
            catch (Exception E){
                showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
            }


    }
    @FXML
    public void handleBookWorkerAction(ActionEvent event) throws IOException {

            try {
                ArrayList<WorkerModel> getWork = customerService.getWorkersCloseBy(Cust_id);//get all workers by cust_id
                //Load second scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BookWorkerXML.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                BookWorkerController scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.initializeWorkerArrayList(getWork,Cust_id);

                //close window
                final Node source = (Node) event.getSource();
                final Stage hide = (Stage) source.getScene().getWindow();
                hide.close();
                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
            catch (Exception E){
                showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
            }


    }
    @FXML
    public void handleEditProfile1Action(ActionEvent event) {
        System.out.println("profile : "+Cust_id);

        if(event.getSource()==gotoChangeCity){
            try {
                sendDatatoProfile("changecity.fxml", gotoChangeCity);
            }
            catch(Exception e){
                showAlert(e.getMessage(), Alert.AlertType.INFORMATION);
            }
        }
        else if(event.getSource()==gotoChangeArea){
            try {
                sendDatatoProfile("changearea.fxml", gotoChangeArea);
            }
            catch(Exception e){
                showAlert(e.getMessage(), Alert.AlertType.INFORMATION);
            }

        }
        else if(event.getSource()==gotoChangePayment){
            try {
                sendDatatoProfile("changepayment.fxml", gotoChangePayment);
            }
            catch(Exception e){
                showAlert(e.getMessage(), Alert.AlertType.INFORMATION);
            }

        }
        else if(event.getSource()==home){

            try{
                sendDatatoHome("homepage.fxml",home);
            }
            catch(Exception e){
                showAlert(e.getMessage(), Alert.AlertType.INFORMATION);
            }
        }
    }

    @FXML
    public void handleShowFavouritesAction(ActionEvent event) {

            try {
                ArrayList<WorkerModel> getWork = customerService.getFavourites(Cust_id);//get all workers by cust_id
                //Load second scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FavouritesXML.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                FavouritesController scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.initializeFavouritesArrayList(getWork,Cust_id);

                //close window
                final Node source = (Node) event.getSource();
                final Stage hide = (Stage) source.getScene().getWindow();
                hide.close();
                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
            catch (Exception E){
                showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
            }

    }

    @FXML
    public void handleShowFinishedBooking(ActionEvent event)throws Exception {

        ArrayList<BookingModel> getBook = bookingService.showFinishedBookingOfCustomer(Cust_id);

        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showfinishedbooking.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerFinishedBooking scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here

        scene2Controller.initializeBookingArrayList(getBook,Cust_id);

        //Show scene 2 in new window
        Stage stage = (Stage) finishedbooking.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void handleshowActiveBooking(ActionEvent event) {


            try {
                ArrayList<BookingModel> getBook = bookingService.showActiveBookingOfCustomer(Cust_id);//get all active bookings by cust_id
                //Load second scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowActiveXML.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                ShowActiveController scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.initializeActiveBookings(getBook,Cust_id,0);

                //close window
                final Node source = (Node) event.getSource();
                final Stage hide = (Stage) source.getScene().getWindow();
                hide.close();
                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
            catch (Exception E){
                showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
            }



    }
    public void changeScene(String file,Button btn)throws Exception{
        Parent root;
        Stage stage;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(file));

        stage = (Stage) btn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void handlegotoProfileAction(ActionEvent event)throws  Exception{
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerHomePage scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.transferId(Cust_id);

        //Show scene 2 in new window
        Stage stage=(Stage) profile.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
    public void sendDatatoProfile(String file,Button btn)throws Exception{
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
    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }

    public void sendDatatoHome(String file,Button btn)throws Exception{
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        Parent root = loader.load();

        //Get controller of scene2
        controllerHomePage scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.transferId(Cust_id);

        //Show scene 2 in new window
        Stage stage=(Stage) btn.getScene().getWindow();;
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void handleLogoutAction(ActionEvent event)throws Exception{
        changeScene("main.fxml",logout);
    }
    public void transferId(int _Cust_id) { //Communication: pass user's id from Controller (Multiple fxml files) to handlebookAction
        //Display the message
        Cust_id=_Cust_id;
    }
    @FXML
    void handleEditProfileActionhome(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            controllerHomePage scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferId(Cust_id);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }


    }

}

