package com.easyfix.Application.ui.Gui;
import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class BookWorkerController extends UI {
    private ArrayList<WorkerModel>getWorkers;
    private int c_id;
    ObservableList<WorkerJAVAFX>list;
    @FXML
    private TableView<WorkerJAVAFX> TableView;

    @FXML
    private TableColumn<WorkerJAVAFX, Integer> _Id;

    @FXML
    private TableColumn<WorkerJAVAFX, String> _Name;

    @FXML
    private TableColumn<WorkerJAVAFX, Float> _Rating;

    public void initializeWorkerArrayList(ArrayList<WorkerModel> W,int c){
        getWorkers=new ArrayList<WorkerModel>(W);
        c_id=c;
        _Id.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX,Integer>("_Id"));
        _Name.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX,String>("_Name"));
        _Rating.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Float>("_Rating"));
        list= FXCollections.observableArrayList(
            new WorkerJAVAFX(1, "ali", (float) 2.0)
        
        );
        TableView.setItems(list);
    }


}