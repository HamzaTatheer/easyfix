package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.ui.UI;
import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.bl.services.ComplainService;
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
import javafx.scene.control.TextArea;

public class controllerComplain extends UI {
    int wid;
    int cid;
    @FXML
    private TextArea complaintext;
    @FXML
    private Button home,Complain;
    @FXML
    public void handleComplainAction(ActionEvent event)throws Exception{
        if(event.getSource()==Complain) {

            boolean b = complainService.giveComplain(cid, wid, complaintext.getText());
            if (b == true) {
                System.out.println("Complain registered successfully");
                changeCScene("showfinishedbooking.fxml", Complain);
            }
        }
        else if(event.getSource()==home)
            changeCScene("home.fxml",home);
    }
    public void recieveData(int c_id,int selected_WID){
        cid=c_id;
        wid=selected_WID;
    }
    public void changeCScene(String file,Button btn)throws Exception{
        Parent root;
        Stage stage;

        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(file));

        stage = (Stage) btn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
