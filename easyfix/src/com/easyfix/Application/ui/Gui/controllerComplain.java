package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.ui.UI;
import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.bl.services.ComplainService;
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
//import java.awt.*;
//import java.awt.ActiveEvent;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;

public class controllerComplain extends UI {
    int wid;
    int cid;
    @FXML
    private TextArea complaintext;
    @FXML
    private Button home,Complain;
    @FXML
    public void handleComplainAction(ActionEvent event)throws Exception{
        if(event.getSource()==Complain) {

            boolean b = complainService.giveComplain(cid, wid, complaintext.getText());
            if (b == true) {
                System.out.println("Complain registered successfully");
                populateTableView();
            }
        }
        else if(event.getSource()==home)
            changeCScene();
    }
    public void recieveData(int c_id,int selected_WID){
        cid=c_id;
        wid=selected_WID;
    }
    public void changeCScene()throws Exception{
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
    public void populateTableView()throws Exception{
        ArrayList<BookingModel> getBook = bookingService.showFinishedBookingOfCustomer(cid);

        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showfinishedbooking.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerFinishedBooking scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here

        scene2Controller.initializeBookingArrayList(getBook,cid);

        //Show scene 2 in new window
        Stage stage = (Stage) Complain.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
