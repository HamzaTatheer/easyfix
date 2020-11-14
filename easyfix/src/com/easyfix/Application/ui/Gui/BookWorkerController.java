package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BookWorkerController extends UI {
    private ArrayList<WorkerModel>getWorkers;
    private int c_id;
    ObservableList<WorkerJAVAFX>list;
    Button []buttonsArr;
    int selected_WID;
    @FXML
    private TableView<WorkerJAVAFX> TableView;


    @FXML
    private TableColumn<WorkerJAVAFX, String> _Name;

    @FXML
    private TableColumn<WorkerJAVAFX, Float> _Rating;

    @FXML
    private TableColumn<WorkerJAVAFX, Float> _HourlyRate;

    @FXML
    private TableColumn<WorkerJAVAFX, String> _Speciality;

    @FXML
    private TableColumn<WorkerJAVAFX, String> BookWButton;

    public void initializeWorkerArrayList(ArrayList<WorkerModel> W,int c){
        getWorkers=new ArrayList<WorkerModel>(W);
        buttonsArr=new Button[getWorkers.size()];
        c_id=c;
        //setSpacing(5);
        TableView.setStyle( "-fx-alignment: Centre;");

        _Name.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX,String>("_Name"));
        _Rating.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Float>("_Rating"));
        _HourlyRate.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX, Float>("_HourlyRate"));
        _Speciality.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX,String>("_Speciality"));
        BookWButton.setCellValueFactory(new PropertyValueFactory<WorkerJAVAFX,String>("button"));
        list= FXCollections.observableArrayList();
        for (int i=0;i<buttonsArr.length;i++){
            buttonsArr[i]=new Button();
            buttonsArr[i].setOnAction(this::handleButtonAction);
        }
        int i=0;
        for (WorkerModel workerModel : getWorkers) {
            list.add(new WorkerJAVAFX(workerModel.id,workerModel.name,workerModel.avgRating,workerModel.hourlyRate,workerModel.speciality,buttonsArr[i]));
            i++;
        }
        TableView.setItems(list);

    }

    private void handleButtonAction(ActionEvent actionEvent) {
        int size=getWorkers.size();
        for(int i=0;i<size;i++) {
            if (actionEvent.getSource() == buttonsArr[i]) {
                selected_WID=getWorkers.get(i).id;
                //System.out.println("Button" + (i + 1) + "Pressed\n");
                //System.out.println("WorkerID selected"+selected_WID);
            }
        }
        //close window
        final Node source = (Node) actionEvent.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
        //Show scene 2 in new window
    }
}