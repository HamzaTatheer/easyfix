package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

//Worker Functions
public class controllerWorkerHomePage extends UI {
    int WID;
    @FXML
    private Button logout,gotoChangeCity,gotoChangeArea,gotoChangeHourlyRate,home,editWorkerprofile;

    @FXML
    public void handleWorkerProfileAction(ActionEvent event) {
        System.out.println("profile : "+WID);

        if(event.getSource()==gotoChangeCity){
            try {
                sendDatatoWorkerProfile("changeworkercity.fxml", gotoChangeCity);
            }
            catch(Exception e){
                e.getMessage();
            }
        }
        else if(event.getSource()==gotoChangeArea){
            try {
                sendDatatoWorkerProfile("changeworkerarea.fxml", gotoChangeArea);
            }
            catch(Exception e){
                e.getMessage();
            }

        }
        else if(event.getSource()==gotoChangeHourlyRate){
            try {
                sendDatatoWorkerProfile("changeworkerhourlyrate.fxml", gotoChangeHourlyRate);
            }
            catch(Exception e){
                e.getMessage();
            }

        }
        else if(event.getSource()==home){

            try {
                changeWScene("workerhomepage.fxml",home);
            }
            catch(Exception e){
                e.getMessage();
            }
        }
    }

    @FXML
    public void handleWLogoutAction(ActionEvent event)throws Exception{
        Parent root;
        Stage stage;

        stage = (Stage) logout.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("main.fxml"));

        stage = (Stage) logout.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void sendDatatoWorkerProfile(String file,Button btn)throws Exception{
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        Parent root = loader.load();

        //Get controller of scene2
        controllerEditWorkerProfile scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.transferWID(WID);

        //Show scene 2 in new window
        Stage stage=(Stage) btn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void handlegotoWorkerProfileAction(ActionEvent event)throws Exception{
        changeWScene("workerprofile.fxml",editWorkerprofile);
    }
    public void changeWScene(String file,Button btn)throws Exception{
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        Parent root = loader.load();

        //Get controller of scene2
        controllerWorkerHomePage scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.getWID(WID);

        //Show scene 2 in new window
        Stage stage=(Stage) btn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
    public void getWID(int wid){
        WID=wid;
    }
}
