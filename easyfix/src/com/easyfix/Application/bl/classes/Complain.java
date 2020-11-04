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
    Complain(ComplainModel C){
        id=C.id;
        wid=C.wid;
        cid=C.cid;
        text=C.text;
    }
    //setters

    //getters
    ComplainModel get_ComplainModel(){
        ComplainModel temp=new ComplainModel();
        temp.cid=cid;
        temp.id=id;
        temp.text=text;
        temp.wid=wid;
        return temp;
    }
}
