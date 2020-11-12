package com.easyfix.Application.bl.services;
import com.easyfix.Application.models.ComplainModel;
import java.util.ArrayList;
public interface ComplainService {
    public Boolean giveComplain(int _id,int _wid,int _cid, String _text)throws Exception;
    public ArrayList<ComplainModel> showAllComplains(int _cid) throws Exception;
}
