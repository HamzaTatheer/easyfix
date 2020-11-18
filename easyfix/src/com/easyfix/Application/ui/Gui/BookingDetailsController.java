package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private Button DetailsHome;
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
    @FXML
    void HandleDetailsHome(ActionEvent event) {
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
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }

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
            showAlert("SUCCESS", Alert.AlertType.INFORMATION);

        }
        catch (Exception F){

                //close window
                 final Node source = (Node) actionEvent.getSource();
                final Stage hide = (Stage) source.getScene().getWindow();
                hide.close();
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
                showAlert(F.getMessage(), Alert.AlertType.INFORMATION);

        }
    }
    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }

}
