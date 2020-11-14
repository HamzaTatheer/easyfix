package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Complain;
import com.easyfix.Application.bl.services.ComplainService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.ComplainModel;

import java.util.ArrayList;

public class ComplainManager implements ComplainService {

    private DbService dbService;

    public ComplainManager(){
        dbService = dbProviders.getDbService();
    }

    public Boolean giveComplain(int cid,int wid, String _text)throws Exception{

            if(dbService.does_customer_exist(cid) && dbService.does_worker_exist(wid)){
                dbService.store_complaint(cid,wid,_text);
                return true;
            }
            else{
                throw new Exception("Invalid customer or worker id");
            }


        }
        //else
            //throw new Exception("One of the user doesn't exist. Please try again\n");
        public ArrayList<ComplainModel> showAllComplains(int _cid) throws Exception {
            if(dbService.does_customer_exist(_cid) == true) {
                return dbService.show_all_complaint(_cid);
            }
            else{
                throw new Exception("Customer Does Not Exist");
            }
        }


}

