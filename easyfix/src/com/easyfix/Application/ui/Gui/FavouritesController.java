package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FavouritesController extends UI {
    ArrayList<WorkerModel>getWorkers;
    int C_id;

    @FXML
    private Button favHomePage;
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
    @FXML
    void handleHomePage(ActionEvent event) {

        final Node source = (Node) event.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
      try {
          //Load second scene
          FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
          Parent root = loader.load();

          //Get controller of scene2
          controllerHomePage scene2Controller = loader.getController();
          //Pass whatever data you want. You can have multiple method calls here
          scene2Controller.transferId(C_id);

          //Show scene 2 in new window
          Stage stage = new Stage();
          stage.setScene(new Scene(root));
          stage.show();
      }
      catch (Exception E){
          System.out.println(E.getMessage());
      }

    }
}
