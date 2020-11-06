package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Complain;
import com.easyfix.Application.bl.classes.Rating;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.db.services.WorkerDbService;
import com.easyfix.Application.models.ComplainModel;
import com.easyfix.Application.models.RatingModel;

public class ComplainManager {

    public Boolean giveComplain(int _id,int _wid,int _cid, String _text)throws Exception{
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
        WorkerDbService workDbService=dbProviders.getWorkerDbService();

        if((custdbservice.does_customer_exist(_wid)&& (workDbService.does_Worker_Exist(_cid)))){

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

            if(updated){
                //get updated model and store in db
                c = complainObj.getComplainModel(); //get model
                //store in db
                // if(complainDbService.store_complaint(_id,_wid,_cid,_text))
                //{
                return true;
                //}
                //else
                //throw new Exception("You already have given complain\n");
            }
            else
                throw new Exception("Invalid Complain text length");

        }
        else
            throw new Exception("One of the user doesn't exist. Please try again\n");
    }
}
