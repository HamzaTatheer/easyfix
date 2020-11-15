package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.ui.UI;
import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.bl.services.RatingService;
import com.easyfix.Application.models.BookingModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.ActiveEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class controllerGiveRating extends UI{
    int cid,wid;
    @FXML
    private Button ratingbtn,home;
    @FXML
    private TextField rating;
    @FXML
    public void handleRatingAction(ActionEvent event)throws Exception{
        if(event.getSource()==ratingbtn) {
            int i=Integer.parseInt(rating.getText());
            boolean b=ratingService.giveRating(cid,wid,i);

            if (b == true) {
                System.out.println("Worker Rated successfully");
                populateTableViewfromRating();
            }
        }
        else if(event.getSource()==home)
            changeRScene();

    }
    public void getData(int Cid,int Wid){
        cid=Cid;
        wid=Wid;
    }
    public void populateTableViewfromRating()throws Exception{
        ArrayList<BookingModel> getBook = bookingService.showFinishedBookingOfCustomer(cid);

        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showfinishedbooking.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerFinishedBooking scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here

        scene2Controller.initializeBookingArrayList(getBook,cid);

        //Show scene 2 in new window
        Stage stage = (Stage) ratingbtn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void changeRScene()throws Exception{

            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            controllerHomePage scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here

            scene2Controller.transferId(cid);

            //Show scene 2 in new window
            Stage stage = (Stage) home.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
    }
}
