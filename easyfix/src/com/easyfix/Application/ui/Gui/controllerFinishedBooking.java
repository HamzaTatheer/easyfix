package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.models.BillingModel;
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

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

//import java.awt.*;
//import java.awt.event.ActionEvent;

public class controllerFinishedBooking extends UI {
    private ArrayList<BookingModel> getBookings;
    private int c_id;
    ObservableList<BookingJAVAFX>list;
    private Button [] complainbuttonsArr;
    private Button [] favouritebuttonsArr;
    private Button [] ratingbuttonsArr;
    private Button [] billbuttonsArr;
    int selected_WID;

    @FXML
    private Button Complain,home;
    @FXML
    private TableView<BookingJAVAFX> tableview;

    @FXML
    private TableColumn<BookingJAVAFX, Integer> workerid;

    @FXML
    private TableColumn<BookingJAVAFX, String> booktext;

    @FXML
    private TableColumn<BookingJAVAFX, LocalDateTime> starttime;

    @FXML
    private TableColumn<BookingJAVAFX, LocalDateTime> endtime;

    @FXML
    private TableColumn<BookingJAVAFX, String> complain;

    @FXML
    private TableColumn<BookingJAVAFX, String> addtofavourite;      /////Button

    @FXML
    private TableColumn<BookingJAVAFX, String> giverating;          ////Button

    @FXML
    private TableColumn<BookingJAVAFX, String> showbill;            ////Button

    public void initializeBookingArrayList(ArrayList < BookingModel > B,int c){
        getBookings = new ArrayList<BookingModel>(B);
        complainbuttonsArr=new Button[getBookings.size()];
        favouritebuttonsArr=new Button[getBookings.size()];
        ratingbuttonsArr=new Button[getBookings.size()];
        billbuttonsArr=new Button[getBookings.size()];
        c_id = c;
        //setSpacing(5);
        tableview.setStyle("-fx-alignment: Centre;");

        workerid.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, Integer>("wid"));
        booktext.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("bookingtext"));
        starttime.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("startTime"));
        endtime.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, LocalDateTime>("endTime"));
        complain.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("complain"));
        addtofavourite.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("addtoFavourite"));
        giverating.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("giveRating"));
        showbill.setCellValueFactory(new PropertyValueFactory<BookingJAVAFX, String>("showBill"));
        list = FXCollections.observableArrayList();
        int i=0;

        for (i=0;i<complainbuttonsArr.length;i++){
            complainbuttonsArr[i]=new Button();
            complainbuttonsArr[i].setOnAction(actionEvent -> {
                try {
                    handleComplainButtonAction(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            favouritebuttonsArr[i]=new Button();
            favouritebuttonsArr[i].setOnAction(actionEvent -> {
                try {
                    handleaddtoFavouriteButtonAction(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            ratingbuttonsArr[i]=new Button();
            ratingbuttonsArr[i].setOnAction(actionEvent -> {
                try {
                    handlegiveRatingButtonAction(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            billbuttonsArr[i]=new Button();
            billbuttonsArr[i].setOnAction(actionEvent -> {
                try {
                    handleshowBillButtonAction(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
        i=0;
        for (BookingModel bookingModel : getBookings) {
            list.add(new BookingJAVAFX(bookingModel.id, bookingModel.wid, bookingModel.cid, bookingModel.text, bookingModel.status,bookingModel.startTime,bookingModel.endTime,bookingModel.spareParts,complainbuttonsArr[i],favouritebuttonsArr[i],billbuttonsArr[i],ratingbuttonsArr[i]));
            i++;
        }

        tableview.setItems(list);

    }

    private void handleComplainButtonAction(ActionEvent actionEvent) throws IOException {
        int size=getBookings.size();
        for(int i=0;i<size;i++) {
            if (actionEvent.getSource() == complainbuttonsArr[i]) {
                selected_WID=getBookings.get(i).wid;
                //System.out.println("Button" + (i + 1) + "Pressed\n");
                //System.out.println("WorkerID selected"+selected_WID);
            }
        }
        //close window
        final Node source = (Node) actionEvent.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();


        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("complain.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerComplain scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.recieveData(c_id,selected_WID);

        //Show scene 2 in new window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    private void handleaddtoFavouriteButtonAction(ActionEvent actionEvent) throws IOException {
        int size=getBookings.size();
        for(int i=0;i<size;i++) {
            if (actionEvent.getSource() == favouritebuttonsArr[i]) {
                selected_WID=getBookings.get(i).wid;
                //System.out.println("Button" + (i + 1) + "Pressed\n");
                //System.out.println("WorkerID selected"+selected_WID);
            }
        }
        System.out.println("cid "+c_id+" wid "+selected_WID);
        try{
            boolean b=customerService.addToFavourite(c_id,selected_WID);
            if(b==true)
                System.out.println("Worker added to favourite successfully");
        }
        catch(Exception e){
            e.getMessage();
        }

    }
    private void handlegiveRatingButtonAction(ActionEvent actionEvent) throws IOException {

        int size=getBookings.size();
        for(int i=0;i<size;i++) {
            if (actionEvent.getSource() == ratingbuttonsArr[i]) {
                selected_WID=getBookings.get(i).wid;
                //System.out.println("Button" + (i + 1) + "Pressed\n");
                //System.out.println("WorkerID selected"+selected_WID);
            }
        }
        //close window
        final Node source = (Node) actionEvent.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();


        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("giverating.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerGiveRating scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.getData(c_id,selected_WID);

        //Show scene 2 in new window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    private void handleshowBillButtonAction(ActionEvent actionEvent) throws IOException {

        int size=getBookings.size();
        for(int i=0;i<size;i++) {
            if (actionEvent.getSource() == billbuttonsArr[i]) {
                selected_WID=getBookings.get(i).id;
                //System.out.println("Button" + (i + 1) + "Pressed\n");
                //System.out.println("WorkerID selected"+selected_WID);
            }
        }
        BillingModel bill=null;
        try{
            bill= billingService.showBill(selected_WID);
        }
        catch(Exception e){
            e.getMessage();
        }

        //close window
        final Node source = (Node) actionEvent.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();


        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("showbill.fxml"));
        Parent root = loader.load();

        String cname=null,wname=null;
        //Get controller of scene2
        try {
            cname = customerService.getCustomerDetails(bill.cid).name;
        }
        catch(Exception e){
            e.getMessage();
        }
        try {
            wname = workerService.getWorker(bill.wid).name;
        }
        catch(Exception e){
            e.getMessage();
        }
        controllerShowBill scene2Controller = loader.getController();
        scene2Controller.setLabelid(bill.bookingId);
        scene2Controller.setLabeltitle(bill.title);

        //scene2Controller.setLabelcustomer(bill.customerName);
        //scene2Controller.setLabelworker(bill.workerName);

        scene2Controller.setLabelcustomer(cname);
        scene2Controller.setLabelworker(wname);
        scene2Controller.setLabelstatus(bill.status);
        scene2Controller.setLabelcost(bill.totalCost);

        //Pass whatever data you want. You can have multiple method calls here
        scene2Controller.getBillID(c_id,selected_WID);

        //Show scene 2 in new window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void handleHomeAction(ActionEvent event)throws Exception{
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        //Get controller of scene2
        controllerHomePage scene2Controller = loader.getController();
        //Pass whatever data you want. You can have multiple method calls here

        scene2Controller.transferId(c_id);

        //Show scene 2 in new window
        Stage stage = (Stage) home.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
