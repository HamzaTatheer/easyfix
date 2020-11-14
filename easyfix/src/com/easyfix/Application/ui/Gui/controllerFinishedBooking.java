package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.Button;

public class controllerFinishedBooking extends UI {
    private ArrayList<BookingModel> getBookings;
    private int c_id;
    ObservableList<BookingJAVAFX>list;

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
        for (BookingModel bookingModel : getBookings) {
            list.add(new BookingJAVAFX(bookingModel.id, bookingModel.wid, bookingModel.cid, bookingModel.text, bookingModel.status,bookingModel.startTime,bookingModel.endTime,bookingModel.spareParts));

        }
        tableview.setItems(list);

    }
   /* @FXML
    public void handleGiveRatingAction(ActionEvent event)throws Exception{
        BookingJAVAFX b=tableview.getSelectionModel().getSelectedItem();
        System.out.println("text "+b.bookingtext);
    }*/
}
