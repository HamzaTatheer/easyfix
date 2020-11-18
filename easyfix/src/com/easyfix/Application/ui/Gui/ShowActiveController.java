package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.ChatMessageModel;
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

public class ShowActiveController extends UI {
    private ArrayList<BookingModel> getActiveBookings;
    private int C_I_D;
    private int flag; //0 for chat, 1 for finish, 2 for add to wallet
    private ObservableList<BookingJAVAFX> list;
    private Button[] buttonsArr;
    private int W_I_D;
    int bid;
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
    private TableColumn<BookingJAVAFX, String> ActiveOption;
    @FXML
    private TableColumn<BookingJAVAFX, String> ConfirmActiveEmail;
    @FXML
    private Button WorkerHome;


    public void initializeActiveBookings(ArrayList<BookingModel> B, int c,int x) {
        flag=x;

        try {


            getActiveBookings = new ArrayList<BookingModel>(B);
            buttonsArr = new Button[getActiveBookings.size()];
            if(Choice.equalsIgnoreCase("customer"))
                C_I_D =c;//c is here cust id
            else
                W_I_D=c;//c heres is work_id
            //setSpacing(5);
            TableView.setStyle("-fx-alignment: Centre;");

            ActiveTitle.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("bookingtext"));
            ActiveStart.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("startTime"));
            ActiveEnd.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("endTime"));
            ActiveOption.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("chat"));
            ConfirmActiveEmail.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("_email"));
            list = FXCollections.observableArrayList();
            for (int i = 0; i < buttonsArr.length; i++) {
                buttonsArr[i] = new Button();
                buttonsArr[i].setOnAction(this::handleButtonAction);
            }
            int i = 0;
            for (BookingModel bookingModel : getActiveBookings) {
                if(flag==0) {
                    list.add(new BookingJAVAFX(customerService.getCustomerDetails(bookingModel.cid).email,workerService.getWorker(bookingModel.wid).email,bookingModel.wid, bookingModel.text, bookingModel.startTime, bookingModel.endTime, buttonsArr[i], "chat"));
                }
                else if(flag==1){
                    list.add(new BookingJAVAFX(customerService.getCustomerDetails(bookingModel.cid).email,workerService.getWorker(bookingModel.wid).email,bookingModel.wid, bookingModel.text, bookingModel.startTime, bookingModel.endTime, buttonsArr[i], "finish"));
                }
                else if(flag==2){
                    list.add(new BookingJAVAFX(customerService.getCustomerDetails(bookingModel.cid).email,workerService.getWorker(bookingModel.wid).email,bookingModel.wid, bookingModel.text, bookingModel.startTime, bookingModel.endTime, buttonsArr[i], "add to wallet"));
                }
                i++;
            }
            TableView.setItems(list);
        } catch (Exception E) {
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }

    private void handleButtonAction(ActionEvent actionEvent) {
        //close window
        final Node source = (Node) actionEvent.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
        if(flag==0) {
            try {
                int size = getActiveBookings.size();
                for (int i = 0; i < size; i++) {
                    if (actionEvent.getSource() == buttonsArr[i]) {

                        W_I_D = getActiveBookings.get(i).wid;

                        C_I_D = getActiveBookings.get(i).cid;
                    }
                    //System.out.println("Button" + (i + 1) + "Pressed\n");
                    //System.out.println("WorkerID selected"+selected_WID);
                }
                //Load second scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatXML.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                ChatController scene2Controller = loader.getController();
                ArrayList<ChatMessageModel> getchats = chatService.loadMessageHistory(C_I_D, W_I_D);
                //Pass whatever data you want. You can have multiple method calls here
                if (Choice.equalsIgnoreCase("customer")) {
                    scene2Controller.initializeChatArrayList(getchats, C_I_D, W_I_D);
                } else
                    scene2Controller.initializeChatArrayList(getchats, W_I_D, C_I_D);


                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (
                    Exception E) {
                showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
            }
        }
        else {
            int size=getActiveBookings.size();
            for(int i=0;i<size;i++) {
                if (actionEvent.getSource() == buttonsArr[i]) {
                    bid=getActiveBookings.get(i).id;
                    C_I_D = getActiveBookings.get(i).cid;
                    W_I_D=getActiveBookings.get(i).wid;
                }
            }
            if(flag==1){
                if (bookingService.finishBooking(bid)) {
                    try {

                        ArrayList<BookingModel> getBook = bookingService.showPendingBookingsOfCustomer(C_I_D);//get all active bookings by cust_id
                        //Load second scene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowActiveXML.fxml"));
                        Parent root = loader.load();

                        //Get controller of scene2
                        ShowActiveController scene2Controller = loader.getController();
                        //Pass whatever data you want. You can have multiple method calls here
                        scene2Controller.initializeActiveBookings(getBook, C_I_D,flag);

                        //close window
                        final Node s = (Node) actionEvent.getSource();
                        final Stage h = (Stage) s.getScene().getWindow();
                        h.close();
                        //Show scene 2 in new window
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                        showAlert("Booking Finished", Alert.AlertType.INFORMATION);
                    } catch (Exception E) {
                        showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
                    }
                } else
                    showAlert("Not Finished", Alert.AlertType.INFORMATION);
            }
            else if(flag==2){
                try {
                    //Load second scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("WalletXML.fxml"));
                    Parent root = loader.load();

                    //Get controller of scene2
                    WalletController scene2Controller = loader.getController();
                    //Pass whatever data you want. You can have multiple method calls here
                    scene2Controller.initialize_ids(C_I_D,W_I_D);

                    //close window
                    final Node s = (Node) actionEvent.getSource();
                    final Stage h = (Stage) source.getScene().getWindow();
                    hide.close();
                    //Show scene 2 in new window
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                }
                catch (Exception E){
                    showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
                }


            }


        }
    }
    @FXML
    void handleActiveHome(ActionEvent event) {
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
                scene2Controller.getWID(W_I_D);
            }


            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }
    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
