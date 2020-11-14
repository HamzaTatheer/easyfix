package com.easyfix.Application.ui.Gui;


import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class WorkerJAVAFX {

    private int _Id;
    private String _Name;
    private float _Rating;
    private float _HourlyRate;
    private String _Speciality;
    private Button button;

    public WorkerJAVAFX(Integer _Id, String _Name, float _Rating,float _HourlyRate,String _Speciality,Button button) {
        this._Id=_Id;
        this._Name=_Name;
        this._Rating=_Rating;
        this._HourlyRate=_HourlyRate;
        this._Speciality=_Speciality;
        this.button=button;
        button.setText("SELECT");
        button.setAlignment(Pos.CENTER);
    }
    public WorkerJAVAFX(Integer _Id, String _Name, float _Rating,float _HourlyRate,String _Speciality) {
        this._Id=_Id;
        this._Name=_Name;
        this._Rating=_Rating;
        this._HourlyRate=_HourlyRate;
        this._Speciality=_Speciality;
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

    public float get_HourlyRate() {
        return _HourlyRate;
    }

    public String get_Speciality() {
        return _Speciality;
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

    public void set_Rating(float _Rating) {
        this._Rating = _Rating;
    }

    public void set_HourlyRate(float _HourlyRate) {
        this._HourlyRate = _HourlyRate;
    }

    public void set_Speciality(String _Speciality) {
        this._Speciality = _Speciality;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}