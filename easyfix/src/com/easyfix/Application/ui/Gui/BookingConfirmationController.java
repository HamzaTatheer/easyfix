package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.SparePartModel;
import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class BookingConfirmationController extends UI {
    int Cust_ID;
    int Work_ID;
    int day,month,hour,minute;
    String titletext,_name,_special;
    Float r,h_r;


    @FXML
    private TextField MonthText;

    @FXML
    private TextField DateText;

    @FXML
    private TextField HourText;

    @FXML
    private TextField MinuteText;

    @FXML
    private Button FinalBook;

    @FXML
    private TextField TitleText;

    @FXML
    private TextField NameText;

    @FXML
    private TextField RatingText;

    @FXML
    private TextField RateText;

    @FXML
    private TextField SpText;

    public void intializeBookingConfirmation(int C,int W,int dd,int m,int h,int mm,String title,String na,String s_p,float rate,float h__r){
        Cust_ID=C;
        Work_ID=W;
        day=dd;
        month=m;
        hour=h;
        minute=mm;
        titletext=title;
        _name=na;
        _special=s_p;
        r=rate;
        h_r=h__r;
        MonthText.setText(Integer.toString(month));
        DateText.setText(Integer.toString(day));
        HourText.setText(Integer.toString(hour));
        MinuteText.setText(Integer.toString(minute));
        TitleText.setText(title);
        NameText.setText(_name);
        RatingText.setText(Float.toString(r));
        RateText.setText(Float.toString(h_r));
        SpText.setText(_special);


    }


    public void HandleFinalBookAction(ActionEvent actionEvent) throws Exception {
        try{
            ArrayList<SparePartModel> sendSpareParts=sparePartService.showAllSpareParts();
            //close window
            final Node source = (Node) actionEvent.getSource();
            final Stage hide = (Stage) source.getScene().getWindow();
            hide.close();
            LocalDateTime makeTime = LocalDateTime.of(LocalDate.of(2020, month, day), LocalTime.of(hour, minute));
            ArrayList<SparePartModel>dummy=new ArrayList<SparePartModel>();
            int bi_d=bookingService.makeBooking(Cust_ID,Work_ID,titletext,makeTime,dummy);
            if(bi_d>0) {
                //Load second scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingSpartPartXML.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                BookingSparePartController scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here'
                scene2Controller.initializeSpareArrayList(sendSpareParts, Cust_ID, Work_ID,bi_d);

                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            else
            {
                //booking not created
            }
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
