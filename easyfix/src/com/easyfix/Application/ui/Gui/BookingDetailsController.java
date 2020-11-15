package com.easyfix.Application.ui.Gui;

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
    private Button Next;

    @FXML
    private TextField TitleText;
    String N,S;
    Float R,HR;
    public void recieveData(int C,int W,String name,Float rate,Float hourRate,String special){
        Cust_ID=C;
        Work_ID=W;
        N=name;
        S=special;
        R=rate;
        HR=hourRate;

    }

    public void HandleNextAction(ActionEvent actionEvent) throws Exception {
        try{
            //ArrayList<SparePartModel> sendSpareParts=sparePartService.showAllSpareParts();
            //close window
            final Node source = (Node) actionEvent.getSource();
            final Stage hide = (Stage) source.getScene().getWindow();
            hide.close();


            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingConfirmationXML.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            BookingConfirmationController scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here'
            scene2Controller.intializeBookingConfirmation(Cust_ID,Work_ID,Integer.parseInt(DateText.getText()),Integer.parseInt(MonthText.getText()),Integer.parseInt(Hour.getText()),Integer.parseInt(MinuteText.getText()),TitleText.getText(),N,S,R,HR);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
