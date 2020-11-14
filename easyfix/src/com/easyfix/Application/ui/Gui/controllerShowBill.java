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
                changeBScene("homepage.fxml",paybill);
            }
            else if(event.getSource()==home)
                changeBScene("homepage.fxml",home);
        }
    }
    public void changeBScene(String file, Button btn)throws Exception{
        Parent root;
        Stage stage;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(file));

        stage = (Stage) btn.getScene().getWindow();
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
}
