package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.SparePartModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BookingSparePartController extends UI {
    int Cust_ID;
    int Work_ID;
    int bID;

    ArrayList<SparePartModel>getSpareParts;
    private ObservableList<SpareJAVAFX> list;

    @FXML
    private TableView<SpareJAVAFX> TableView;

    @FXML
    private TableColumn<SpareJAVAFX, String> SpareName;

    @FXML
    private TableColumn<SpareJAVAFX, Float> SparePrice;

    @FXML
    private TableColumn<SpareJAVAFX, String > BookWButton;
    private Button[]buttonsArr;
    @FXML
    private Button SpareHome;

    @FXML
    void HandleSpareHome(ActionEvent event) {
        //close window
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
            scene2Controller.transferId(Cust_ID);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            System.out.println(E.getMessage());
        }

    }
    public void initializeSpareArrayList(ArrayList<SparePartModel> W, int c,int w,int b)throws Exception{
        bID=b;
        getSpareParts=new ArrayList<SparePartModel>(W);
        buttonsArr=new Button[getSpareParts.size()];
        Cust_ID=c;
        Work_ID=w;
        //setSpacing(5);
        TableView.setStyle( "-fx-alignment: Centre;");

        SpareName.setCellValueFactory(new PropertyValueFactory<SpareJAVAFX,String>("N"));
        SparePrice.setCellValueFactory(new PropertyValueFactory<SpareJAVAFX, Float>("_Cost"));
        BookWButton.setCellValueFactory(new PropertyValueFactory<SpareJAVAFX,String>("add"));
        list= FXCollections.observableArrayList();
        for (int i=0;i<buttonsArr.length;i++){
            buttonsArr[i]=new Button();
            buttonsArr[i].setOnAction(actionEvent -> {
                try {
                    handleButtonAction(actionEvent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
        int i=0;
        for (SparePartModel sparePartModel : getSpareParts) {
            list.add(new SpareJAVAFX(sparePartModel.id,sparePartModel.name,sparePartModel.quantity,sparePartModel.cost,buttonsArr[i]));
            i++;
        }
        TableView.setItems(list);

    }

    private void handleButtonAction(ActionEvent actionEvent)throws Exception{
        try {

        for(int i=0;i<buttonsArr.length;i++) {
            if (actionEvent.getSource() == buttonsArr[i]) {

                    sparePartService.addSparePartsToBooking(bID, i, 1);
                    showAlert("SUCCESS! SparePart added", Alert.AlertType.INFORMATION);

                }

            }
        }
        catch (Exception E){
            showAlert("SparePart not added", Alert.AlertType.INFORMATION);
        }

    }
    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }


}
