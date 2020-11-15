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

public class ShowActiveController extends UI {
    private ArrayList<BookingModel> getActiveBookings;
    private int C_I_D;
    private ObservableList<BookingJAVAFX> list;
    private Button[]buttonsArr;
    private int W_I_D;
    @FXML
    private Button ActiveHome;
    @FXML
    private TableView<BookingJAVAFX> TableView;

    @FXML
    private TableColumn<BookingJAVAFX, String> ActiveTitle;

    @FXML
    private TableColumn<BookingJAVAFX, LocalDateTime> ActiveStart;

    @FXML
    private TableColumn<BookingJAVAFX, LocalDateTime> ActiveEnd;

    @FXML
    private TableColumn<BookingJAVAFX,String> ActiveOption;
    @FXML
    private Button WorkerHome;

    @FXML
    void HandleWorkerHome(ActionEvent event) {

    }

    public void initializeActiveBookings(ArrayList<BookingModel> B, int c){
        getActiveBookings=new ArrayList<BookingModel>(B);
        buttonsArr=new Button[getActiveBookings.size()];
        C_I_D=c;
        //setSpacing(5);
        TableView.setStyle( "-fx-alignment: Centre;");

        ActiveTitle.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX,String>("bookingtext"));
        ActiveStart.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("startTime"));
        ActiveEnd.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("endTime"));
        ActiveOption.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX,String>("chat"));
        list= FXCollections.observableArrayList();
        for (int i=0;i<buttonsArr.length;i++){
            buttonsArr[i]=new Button();
            buttonsArr[i].setOnAction(this::handleButtonAction);
        }
        int i=0;
        for (BookingModel bookingModel : getActiveBookings) {
            list.add(new BookingJAVAFX(bookingModel.wid,bookingModel.text,bookingModel.startTime,bookingModel.endTime,buttonsArr[i]));
            i++;
        }
        TableView.setItems(list);

    }

    private void handleButtonAction(ActionEvent actionEvent) {
    }
    @FXML
    void handleActiveHome(ActionEvent event) {
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
}
