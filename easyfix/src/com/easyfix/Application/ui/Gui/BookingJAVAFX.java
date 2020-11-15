package com.easyfix.Application.ui.Gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingJAVAFX {
    private int id;
    private int wid;
    private int cid;
    private String bookingtext;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ArrayList<Integer> spareParts;
    private Button complain;
    private Button addtoFavourite;
    private Button giveRating;
    private Button showBill;
    private Button chat;

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
    public BookingJAVAFX(int _wid,String _text,LocalDateTime _startTime,LocalDateTime _endTime,Button _button){
        wid=_wid;
        bookingtext=_text;
        startTime=_startTime;
        endTime=_endTime;
        chat=_button;
        chat.setText("Chat");
        chat.setAlignment(Pos.CENTER);
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

    public Button getChat() {
        return chat;
    }

    public void setChat(Button chat) {
        this.chat = chat;
    }

}
