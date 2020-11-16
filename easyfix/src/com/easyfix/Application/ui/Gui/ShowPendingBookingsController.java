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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.easyfix.Application.ui.Gui.Controller.Choice;

public class ShowPendingBookingsController extends UI {
    int C_I_D;
    int bid;
    ArrayList<BookingModel>getPendingBookings;
    private ObservableList<BookingJAVAFX> list;
    private Button[]buttonsArr;
    int flag;//0 for reject, 1 for accept
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
    private TableColumn<BookingJAVAFX, String> PendingOption;
    @FXML
    private TableColumn<BookingJAVAFX, String> confirmEmailText;

    @FXML
    void handlePendingHome(ActionEvent event) {

        //close window
        final Node source = (Node) event.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
        try {
            //Load second scene
            FXMLLoader loader;
            Parent root;
            if(Choice.equalsIgnoreCase("customer")) {

                loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
                root = loader.load();

                //Get controller of scene2
                controllerHomePage scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.transferId(C_I_D);
            }
            else{
                loader = new FXMLLoader(getClass().getResource("workerhomepage.fxml"));
                root = loader.load();

                //Get controller of scene2
                controllerWorkerHomePage scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.getWID(C_I_D);
            }
            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            System.out.println(E.getMessage());
        }

    }
    public void initializePendingBookings(ArrayList<BookingModel> B, int c,int x){
        try {
            getPendingBookings = new ArrayList<BookingModel>(B);
            flag=x;
            buttonsArr = new Button[getPendingBookings.size()];
            C_I_D = c;
            TableView.setStyle("-fx-alignment: Centre;");


            PendingTitle.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("bookingtext"));
            PendingStart.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("startTime"));
            PendingEnd.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("endTime"));
            PendingOption.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("chat"));
            confirmEmailText.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("_email"));
            for (int i = 0; i < buttonsArr.length; i++) {
                buttonsArr[i] = new Button();
                buttonsArr[i].setOnAction(this::handleButtonAction);
            }
            int i = 0;
            list = FXCollections.observableArrayList();

            for (BookingModel bookingModel : getPendingBookings) {
                if(flag==0) {
                    list.add(new BookingJAVAFX(customerService.getCustomerDetails(bookingModel.cid).email,workerService.getWorker(bookingModel.wid).email,bookingModel.wid, bookingModel.text, bookingModel.startTime, bookingModel.endTime, buttonsArr[i], "reject"));
                }
                else if(flag==1) {
                    list.add(new BookingJAVAFX(customerService.getCustomerDetails(bookingModel.cid).email,workerService.getWorker(bookingModel.wid).email,bookingModel.wid, bookingModel.text, bookingModel.startTime, bookingModel.endTime, buttonsArr[i], "accept"));
                }
                i++;
            }
            TableView.setItems(list);
        }
        catch (Exception E){
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }
    private void handleButtonAction(ActionEvent actionEvent) {
        int size=getPendingBookings.size();
        for(int i=0;i<size;i++) {
            if (actionEvent.getSource() == buttonsArr[i]) {
                bid=getPendingBookings.get(i).id;

            }
        }
        if(flag==0) {
            if (bookingService.rejectBooking(bid)) {
                try {
                    ArrayList<BookingModel> getBook = bookingService.showPendingBookingsOfCustomer(C_I_D);//get all active bookings by cust_id
                    //Load second scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowPendingBookings.fxml"));
                    Parent root = loader.load();

                    //Get controller of scene2
                    ShowPendingBookingsController scene2Controller = loader.getController();
                    //Pass whatever data you want. You can have multiple method calls here
                    scene2Controller.initializePendingBookings(getBook, C_I_D,flag);

                    //close window
                    final Node source = (Node) actionEvent.getSource();
                    final Stage hide = (Stage) source.getScene().getWindow();
                    hide.close();
                    //Show scene 2 in new window
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                    showAlert("Booking Rejected", Alert.AlertType.INFORMATION);
                } catch (Exception E) {
                    showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
                }
            } else
                showAlert("Not Rejected", Alert.AlertType.INFORMATION);
        }
        else if(flag==1){
            if (bookingService.acceptBooking(bid)) {
                try {
                    ArrayList<BookingModel> getBook = bookingService.showPendingBookingsOfCustomer(C_I_D);//get all active bookings by cust_id
                    //Load second scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowPendingBookings.fxml"));
                    Parent root = loader.load();

                    //Get controller of scene2
                    ShowPendingBookingsController scene2Controller = loader.getController();
                    //Pass whatever data you want. You can have multiple method calls here
                    scene2Controller.initializePendingBookings(getBook, C_I_D,flag);

                    //close window
                    final Node source = (Node) actionEvent.getSource();
                    final Stage hide = (Stage) source.getScene().getWindow();
                    hide.close();
                    //Show scene 2 in new window
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                    showAlert("Booking Accepted", Alert.AlertType.INFORMATION);
                } catch (Exception E) {
                    showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
                }
            } else
                showAlert("Not Accepted", Alert.AlertType.INFORMATION);

        }

    }
    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }

}
