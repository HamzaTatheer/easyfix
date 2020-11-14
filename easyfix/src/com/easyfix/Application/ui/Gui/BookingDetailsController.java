package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;

public class BookingDetailsController extends UI {
    int Cust_ID;
    int Work_ID;

    public void recieveData(int C,int W){
        Cust_ID=C;
        Work_ID=W;

    }
    public void HandleFinalBookAction(ActionEvent actionEvent) {
    }
}
