package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Complain;
import com.easyfix.Application.bl.services.ComplainService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.ComplainModel;

import java.util.ArrayList;

public class ComplainManager implements ComplainService {

    private DbService dbService;

    ComplainManager(){
        dbService = dbProviders.getDbService();
    }

    public Boolean giveComplain(int _id,int _wid,int _cid, String _text)throws Exception{


        //if((dbService.does_customer_exist(_wid)&& (dbService.does_worker_exist(_cid)))){

            //ComplainDbService complainDbService=dbProviders.getComplainDbService();
            //c is model
            ComplainModel c = new ComplainModel();
            c.id = _id;
            c.wid=_wid;
            c.cid=_cid;
            c.text=_text;

            boolean updated =false;
            Complain complainObj = new Complain(c);//convert model to class
            updated = complainObj.checkTextlength(_text); //update in class

            if(updated == true){
                dbService.store_complaint(_cid,_wid,_text);
                return true;
            }
            else {
                throw new Exception("Invalid Complain text length");
            }

        }
        //else
            //throw new Exception("One of the user doesn't exist. Please try again\n");
        public ArrayList<ComplainModel> showAllComplains(int _cid){
            return null;.
        }


}

