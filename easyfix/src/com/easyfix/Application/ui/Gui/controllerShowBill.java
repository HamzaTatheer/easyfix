package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Node;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;

public class controllerShowBill extends UI {
    int Cid,Bid;
    @FXML
    private Label id,customer,worker,title,status,cost;
    @FXML
    private Button paybill,home;
    @FXML
    public void handlepayBillAction(ActionEvent event)throws Exception{
        if(event.getSource()==paybill){
            boolean b=bookingService.payForBooking(Cid,Bid);
            if(b == true)
            {
                System.out.println("Bill payed successfully");
                populateTableViewfromBill();
            }
            else if(event.getSource()==home)
                changeBScene();
        }
    }
    public void changeBScene()throws Exception{
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerHomePage scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here

        scene2Controller.transferId(Cid);

        //Show scene 2 in new window
        Stage stage = (Stage) paybill.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void getBillID(int cid,int bid){
        Cid=cid;
        Bid=bid;
    }
    public void setLabelcustomer(String text){
        customer.setText(text);
    }
    public void setLabelworker(String text){
        worker.setText(text);
    }
    public void setLabelstatus(String text){
        status.setText(text);
    }
    public void setLabeltitle(String text){
        title.setText(text);
    }
    public void setLabelid(int Id){
        String text=Integer.toString(Id);
        id.setText(text);
    }
    public void setLabelcost(float Cost){
        String text=Float.toString(Cost);
        cost.setText(text);
    }
    public void populateTableViewfromBill()throws Exception{
        ArrayList<BookingModel> getBook = bookingService.showFinishedBookingOfCustomer(Cid);

        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showfinishedbooking.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerFinishedBooking scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here

        scene2Controller.initializeBookingArrayList(getBook,Cid);

        //Show scene 2 in new window
        Stage stage = (Stage) paybill.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
