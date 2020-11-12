package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.SparePartModel;

import java.util.ArrayList;

public interface SparePartService {
    public Boolean addSparePart(String _name,float _cost,int _quantity);
    public ArrayList<SparePartModel> showAllSpareParts();
}