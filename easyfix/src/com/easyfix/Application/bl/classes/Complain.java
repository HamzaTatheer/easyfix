package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.ComplainModel;

public class Complain {
    public int id;
    public int wid;
    public int cid;
    public String text;
    //constructors
    Complain(){

    }
    Complain(int _id,int _wid,int _cid,String _text){
        id=_id;
        wid=_wid;
        cid=_cid;
        text=_text;
    }
    Complain(ComplainModel obj){
        id=obj.id;
        wid=obj.wid;
        cid=obj.cid;
        text=obj.text;
    }
    //setters

    //getters
    Complain getComplain(ComplainModel obj){ //convert model to class
        Complain temp=new Complain();
        temp.cid=obj.cid;
        temp.id=obj.id;
        temp.text=obj.text;
        temp.wid=obj.wid;
        return temp;
    }
    ComplainModel getComplainModel(Complain obj){ //convert class to model
        ComplainModel temp=new ComplainModel();
        temp.cid=obj.cid;
        temp.id=obj.id;
        temp.text=obj.text;
        temp.wid=obj.wid;
        return temp;
    }
}
