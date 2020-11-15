package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.SparePartModel;
import com.easyfix.Application.ui.UI;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

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
    @FXML
    private TextField year;
    @FXML
    private Button ConfirmationHome;
    @FXML
    void handleConfirmationHome(ActionEvent event) {
        //close window
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
            scene2Controller.transferId(Cust_ID);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            System.out.println(E.getMessage());
        }


    }
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
        MonthText.setEditable(false);
        DateText.setText(Integer.toString(day));
        DateText.setEditable(false);
        HourText.setText(Integer.toString(hour));
        HourText.setEditable(false);
        MinuteText.setText(Integer.toString(minute));
        MinuteText.setEditable(false);
        TitleText.setText(title);
        TitleText.setEditable(false);
        NameText.setText(_name);
        NameText.setEditable(false);
        RatingText.setText(Float.toString(r));
        RatingText.setEditable(false);
        RateText.setText(Float.toString(h_r));
        RateText.setEditable(false);
        SpText.setText(_special);
        SpText.setEditable(false);
        year.setText(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
        year.setEditable(false);

    }


    public void HandleFinalAction(ActionEvent actionEvent) throws Exception {
        try {
            ArrayList<SparePartModel> sendSpareParts = sparePartService.showAllSpareParts();
            //close window
            final Node source = (Node) actionEvent.getSource();
            final Stage hide = (Stage) source.getScene().getWindow();
            hide.close();
            LocalDateTime makeTime = LocalDateTime.of(LocalDate.of(2020, month, day), LocalTime.of(hour, minute));
            ArrayList<SparePartModel> dummy = new ArrayList<SparePartModel>();

            Text text = new Text();

            //Setting font to the text
            text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

            //setting the position of the text
            text.setX(50);
            text.setY(130);

            //Setting the color
            text.setFill(Color.GREEN);

            //Setting the Stroke
            text.setStrokeWidth(2);

            // Setting the stroke color
            text.setStroke(Color.YELLOW);

            int bi_d = bookingService.makeBooking(Cust_ID, Work_ID, titletext, makeTime, dummy);

            //Load second scene

                //Setting the text to be added.
                text.setText("Booking Created");

                //Creating a Group object
                Group rt = new Group(text);

                //Creating a scene object
                Scene scene = new Scene(rt, 600, 300);

                // can use an Alert, Dialog, or PopupWindow as needed...
                Stage popup = new Stage();
                // configure UI for popup etc...
                popup.setScene(scene);
                // hide popup after 3 seconds:
                PauseTransition delay = new PauseTransition(Duration.seconds(5));
                delay.setOnFinished(e -> popup.hide());

                popup.show();
                popup.show();
                delay.play();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingSpartPartXML.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                BookingSparePartController scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here'
                scene2Controller.initializeSpareArrayList(sendSpareParts, Cust_ID, Work_ID, bi_d);

                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

        }
        catch (Exception F){
            Text text = new Text();

            //Setting font to the text
            text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

            //setting the position of the text
            text.setX(50);
            text.setY(130);

            //Setting the color
            text.setFill(Color.RED);

            //Setting the Stroke
            text.setStrokeWidth(2);

            // Setting the stroke color
            text.setStroke(Color.YELLOW);
            //Setting the text to be added.
            text.setText(F.getMessage());

            //Creating a Group object
            Group rt = new Group(text);

            //Creating a scene object
            Scene scene = new Scene(rt, 600, 300);

            // can use an Alert, Dialog, or PopupWindow as needed...
            Stage popup = new Stage();
            // configure UI for popup etc...
            popup.setScene(scene);
            // hide popup after 3 seconds:
            PauseTransition delay = new PauseTransition(Duration.seconds(7));
            delay.setOnFinished(e -> popup.hide());

            popup.show();
            delay.play();
        }
    }
}
