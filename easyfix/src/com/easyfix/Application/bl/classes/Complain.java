package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.ComplainModel;

public class Complain {
    private int id;
    private int wid;
    private int cid;
    private String text;
    //constructors
     Complain(ComplainModel obj){
        id=obj.id;
        wid=obj.wid;
        cid=obj.cid;
        text=obj.text;
    }
    //member functions
    public ComplainModel getComplainModel(){
        ComplainModel temp=new ComplainModel();
        temp.cid=cid;
        temp.id=id;
        temp.text=text;
        temp.wid=wid;
        return temp;
    }
    public Boolean checkTextlength(String _text){
        if(_text.length()>=30)
            return true;
        else
            return false;
    }
    //getters
    public int getId() {
        return id;
    }

    public int getWid() {
        return wid;
    }

    public int getCid() {
        return cid;
    }

    public String getText() {
        return text;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setText(String text) {
        this.text = text;
    }
}
