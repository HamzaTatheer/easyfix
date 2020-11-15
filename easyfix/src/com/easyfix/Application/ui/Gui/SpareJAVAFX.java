package com.easyfix.Application.ui.Gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class SpareJAVAFX {
    private int _Id;
    private String N;
    private int _Quantity;
    private Float _Cost;
    private Button add;

    public SpareJAVAFX(int _id,String _name,int _quantity,Float _cost,Button _add){
        _Id=_id;
         N=_name;
        _Quantity=_quantity;
        _Cost=_cost;
        add=_add;
        add.setText("Add");
        this.add.setAlignment(Pos.CENTER);
    }

    public int get_Id() {
        return _Id;
    }

    public Button getAdd() {
        return add;
    }

    public Float get_Cost() {
        return _Cost;
    }

    public int get_Quantity() {
        return _Quantity;
    }

    public String getN() {
        return N;
    }

    public void set_Id(int _Id) {

        this._Id = _Id;
    }

    public void set_Cost(Float _Cost) {
        this._Cost = _Cost;
    }

    public void set_Quantity(int _Quantity) {
        this._Quantity = _Quantity;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public void setN(String n) {
        N = n;
    }
}
