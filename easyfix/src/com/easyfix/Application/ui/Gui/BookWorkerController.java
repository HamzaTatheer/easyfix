package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class BookWorkerController extends UI {
    private ArrayList<WorkerModel> getWorkers;
    private int c_id;
    ObservableList<WorkerJAVAFX> list;
    @FXML
    private TableView<WorkerJAVAFX> TableView;

    @FXML
    private TableColumn<WorkerJAVAFX, Integer> _Id;

    @FXML
    private TableColumn<WorkerJAVAFX, String> _Name;

    @FXML
    private TableColumn<WorkerJAVAFX, Float> _Rating;

    @FXML
    private TableColumn<WorkerJAVAFX, Float> _HourlyRate;

    @FXML
    private TableColumn<WorkerJAVAFX, String> _Speciality;

    public void initializeWorkerArrayList(ArrayList<WorkerModel> W, int c) {
        getWorkers = new ArrayList<WorkerModel>(W);
        c_id = c;
        //setSpacing(5);
        TableView.setStyle("-fx-alignment: Centre;");

        _Id.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Integer>("_Id"));
        _Name.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, String>("_Name"));
        _Rating.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Float>("_Rating"));
        _HourlyRate.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Float>("_HourlyRate"));
        _Speciality.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, String>("_Speciality"));
        list = FXCollections.observableArrayList();
        for (WorkerModel workerModel : getWorkers) {
            list.add(new WorkerJAVAFX(workerModel.id, workerModel.name, workerModel.avgRating, workerModel.hourlyRate, workerModel.speciality));
        }
        TableView.setItems(list);

    }
    
    public void HandleActionBookWorker(ActionEvent actionEvent) {
    }

    public void HandleActionAddToSparePart(ActionEvent actionEvent) {
    }
}

