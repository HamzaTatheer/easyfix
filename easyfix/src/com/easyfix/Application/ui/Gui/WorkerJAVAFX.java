package com.easyfix.Application.ui.Gui;

public class WorkerJAVAFX {

    private int _Id;
    private String _Name;
    private float _Rating;



    public WorkerJAVAFX(Integer _Id, String _Name, float _Rating) {
        this._Id=_Id;
        this._Name=_Name;
        this._Rating=_Rating;
    }

    public Float get_Rating() {
        return _Rating;
    }

    public int get_Id() {
        return _Id;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Rating(Float _Rating) {
        this._Rating = _Rating;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }
}