package com.easyfix.Application.ui.Gui;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.Button;

public class BookingJAVAFX {
    public int id;
    public int wid;
    public int cid;
    public String bookingtext;
    public String status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public ArrayList<Integer> spareParts;
    public Button complain;
    public Button addtoFavourite;
    public Button giveRating;
    public Button showBill;

    public BookingJAVAFX(int id, int wid, int cid, String bookingtext, String status, LocalDateTime startTime, LocalDateTime endTime, ArrayList<Integer> spareParts,Button complain,Button addtoFavourite,Button showBill,Button giveRating) {
        this.id = id;
        this.wid = wid;
        this.cid = cid;
        this.bookingtext = bookingtext;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.spareParts = spareParts;
        this.complain=complain;
        this.complain.setText("Complain");
        this.addtoFavourite=addtoFavourite;
        this.addtoFavourite.setText("Add to Favourite");
        this.giveRating=giveRating;
        this.giveRating.setText("Give Rating");
        this.showBill=showBill;
        this.showBill.setText("Show Bill");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getBookingtext() {
        return bookingtext;
    }

    public void setBookingtext(String bookingtext) {
        this.bookingtext = bookingtext;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ArrayList<Integer> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(ArrayList<Integer> spareParts) {
        this.spareParts = spareParts;
    }

    public Button getComplain() {
        return complain;
    }

    public void setComplain(Button complain) {
        this.complain = complain;
    }

    public Button getAddtoFavourite() {
        return addtoFavourite;
    }

    public void setAddtoFavourite(Button addtoFavourite) {
        this.addtoFavourite = addtoFavourite;
    }

    public Button getGiveRating() {
        return giveRating;
    }

    public void setGiveRating(Button giveRating) {
        this.giveRating = giveRating;
    }

    public Button getShowBill() {
        return showBill;
    }

    public void setShowBill(Button showBill) {
        this.showBill = showBill;
    }
}
