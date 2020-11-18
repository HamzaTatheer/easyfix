package com.easyfix.Application.ui.Gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.easyfix.Application.ui.Gui.Controller.Choice;

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
    private String _email;

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
    public BookingJAVAFX(String _email1,String _email2,int _wid,String _text,LocalDateTime _startTime,LocalDateTime _endTime,Button _button,String s){
        wid=_wid;
        bookingtext=_text;
        startTime=_startTime;
        endTime=_endTime;
        chat=_button;
        if(Choice.equals("customer")){

            _email=_email2;
        }
        else if(Choice.equals("worker")){
            _email=_email1;

        }
        if(s.equals("chat")) {
            chat.setText("Chat");
        }
        else if(s.equals("reject")){
            chat.setText("Reject");
        }
        else if(s.equals("accept")){
            chat.setText("Accept");
        }
        else if(s.equals("finish")){
            chat.setText("finish");
        }
        else if(s.equals("add to wallet")){
            chat.setText("add to wallet");
        }
        chat.setAlignment(Pos.CENTER);
    }

    public BookingJAVAFX(int _CID,String _Text,LocalDateTime s,LocalDateTime e){
        cid=_CID;
        bookingtext=_Text;
        startTime=s;
        endTime=e;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
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
