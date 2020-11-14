package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.Gui.WorkerJAVAFX;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class FavouritesController extends UI {
    ArrayList<WorkerModel>getWorkers;
    int C_id;
    private ObservableList<WorkerJAVAFX> list;
    @FXML
    private TableView<WorkerJAVAFX> TableView;

    @FXML
    private TableColumn<WorkerJAVAFX, String> _FavName;

    @FXML
    private TableColumn<WorkerJAVAFX, Float> _FavRating;

    @FXML
    private TableColumn<WorkerJAVAFX, Float> _FavHourlyRate;

    @FXML
    private TableColumn<WorkerJAVAFX, String> _FavSpeciality;

    public void initializeFavouritesArrayList(ArrayList<WorkerModel> W, int c){
        getWorkers=new ArrayList<WorkerModel>(W);
        C_id=c;
        //setSpacing(5);
        TableView.setStyle( "-fx-alignment: Centre;");

        _FavName.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX,String>("_Name"));
        _FavRating.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Float>("_Rating"));
        _FavHourlyRate.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Float>("_HourlyRate"));
        _FavSpeciality.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX,String>("_Speciality"));

        list= FXCollections.observableArrayList();

        for (WorkerModel workerModel : getWorkers) {
            list.add(new WorkerJAVAFX(workerModel.id,workerModel.name,workerModel.avgRating,workerModel.hourlyRate,workerModel.speciality));
        }
        TableView.setItems(list);

    }
}
