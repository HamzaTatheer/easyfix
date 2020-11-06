package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.ComplainModel;

public class Complain {
    public int id;
    public int wid;
    public int cid;
    public String text;
    //constructors
    public Complain(ComplainModel obj){
        id=obj.id;
        wid=obj.wid;
        cid=obj.cid;
        text=obj.text;
    }
    //getters
    public ComplainModel getComplainModel(){
        ComplainModel temp=new ComplainModel();
        temp.cid=cid;
        temp.id=id;
        temp.text=text;
        temp.wid=wid;
        return temp;
    }
    //setters
    public Boolean checkTextlength(String _text){
        if(_text.length()>=30)
            return true;
        else
            return false;
    }
}
