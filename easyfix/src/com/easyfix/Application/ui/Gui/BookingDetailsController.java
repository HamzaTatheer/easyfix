package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BookingDetailsController extends UI {
    private int Cust_ID;
    private int Work_ID;
    Boolean flag;
    @FXML
    private TextField MonthText;

    @FXML
    private TextField DateText;

    @FXML
    private TextField Hour;

    @FXML
    private TextField MinuteText;

    @FXML
    private Button FinalBook;

    @FXML
    private TextField TitleText;

    public void recieveData(int C,int W){
        Cust_ID=C;
        Work_ID=W;

    }
    public void HandleFinalBookAction(ActionEvent actionEvent) throws Exception {
        try{

        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
