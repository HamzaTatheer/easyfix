package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.ui.UI;
import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.bl.services.RatingService;
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
import java.awt.*;
import java.awt.ActiveEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class controllerGiveRating extends UI{
    int cid,wid;
    @FXML
    private Button ratingbtn,home;
    @FXML
    private TextField rating;
    @FXML
    public void handleRatingAction(ActionEvent event)throws Exception{
        if(event.getSource()==ratingbtn) {
            int i=Integer.parseInt(rating.getText());
            boolean b=ratingService.giveRating(cid,wid,i);

            if (b == true) {
                System.out.println("Worker Rated successfully");
                changeRScene("showfinishedbooking.fxml", ratingbtn);
            }
        }
        else if(event.getSource()==home)
            changeRScene("home.fxml",home);

    }
    public void getData(int Cid,int Wid){
        cid=Cid;
        wid=Wid;
    }
    public void changeRScene(String file,Button btn)throws Exception{
        Parent root;
        Stage stage;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(file));

        stage = (Stage) btn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
