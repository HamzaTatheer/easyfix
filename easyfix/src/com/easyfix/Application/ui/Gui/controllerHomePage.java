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
    public void handleBookWorkerAction(ActionEvent event) throws IOException {
        //System.out.println("Customer Id " + Cust_id+"\n"); //Cust_id passed to Book Worker
        try {
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
                E.getMessage();
            }

        }
        catch (Exception E){
            E.getMessage();
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
                e.getMessage();
            }
        }
        else if(event.getSource()==gotoChangeArea){
            try {
                sendDatatoProfile("changearea.fxml", gotoChangeArea);
            }
            catch(Exception e){
                e.getMessage();
            }

        }
        else if(event.getSource()==gotoChangePayment){
            try {
                sendDatatoProfile("changepayment.fxml", gotoChangePayment);
            }
            catch(Exception e){
                e.getMessage();
            }

        }
        else if(event.getSource()==home){

        }
    }


    @FXML
    public void handleLogout(ActionEvent event) {

    }

    @FXML
    public void handleShowFavouritesAction(ActionEvent event) {
        try {
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
                E.getMessage();
            }

        }
        catch (Exception E){
            E.getMessage();
        }

    }

    @FXML
    public void handleShowFinishedBooking(ActionEvent event)throws Exception {

        System.out.println("ID "+Cust_id);
            ArrayList<BookingModel> getBook = bookingService.showFinishedBookingOfCustomer(Cust_id);
              /*  for (BookingModel bookingModel : getBook) {
                    System.out.print(bookingModel.id + ".");
                    System.out.print(bookingModel.wid + ".");
                    System.out.print(bookingModel.cid + ".");
                    System.out.print(bookingModel.text);
                    System.out.print("-");
                    System.out.println(" " + bookingModel.status);
                }*/

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
    public void transferId(int _Cust_id) { //Communication: pass user's id from Controller (Multiple fxml files) to handlebookAction
        //Display the message
        Cust_id=_Cust_id;
    }

}
