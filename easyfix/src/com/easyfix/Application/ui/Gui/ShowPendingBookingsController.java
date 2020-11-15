package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShowPendingBookingsController extends UI {
    int C_I_D;
    ArrayList<BookingModel>getPendingBookings;
    private ObservableList<BookingJAVAFX> list;
    @FXML
    private Button PendingHome;

    @FXML
    private TableView<BookingJAVAFX> TableView;

    @FXML
    private TableColumn<BookingJAVAFX, String> PendingTitle;

    @FXML
    private TableColumn<BookingJAVAFX, LocalDateTime> PendingStart;

    @FXML
    private TableColumn<BookingJAVAFX, LocalDateTime> PendingEnd;

    @FXML
    void handlePendingHome(ActionEvent event) {
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
            scene2Controller.transferId(C_I_D);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            System.out.println(E.getMessage());
        }

    }
    public void initializePendingBookings(ArrayList<BookingModel> B, int c){
        getPendingBookings=new ArrayList<BookingModel>(B);
        C_I_D=c;
        //setSpacing(5);
        TableView.setStyle( "-fx-alignment: Centre;");

        PendingTitle.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX,String>("bookingtext"));
        PendingStart.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("startTime"));
        PendingEnd.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("endTime"));
        list= FXCollections.observableArrayList();

        for (BookingModel bookingModel : getPendingBookings) {
            list.add(new BookingJAVAFX(bookingModel.wid,bookingModel.text,bookingModel.startTime,bookingModel.endTime));
        }
        TableView.setItems(list);

    }

}
