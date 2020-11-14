package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class controllerHomePage extends UI {
    private int Cust_id;
    @FXML
    private Button BookWorker;

    @FXML
    private Button ShowFavourites;

    @FXML
    private Button showFinishedBooking;

    @FXML
    private Button showActiveBooking;

    @FXML
    private Button logout;

    @FXML
    private Button EditProfile1;

    @FXML
    public void handleBookWorkerAction(ActionEvent event) throws IOException {
        //System.out.println("Customer Id " + Cust_id+"\n"); //Cust_id passed to Book Worker
        try {
            try {
                ArrayList<WorkerModel> getWork = customerService.getWorkersCloseBy(Cust_id);//get all workers by cust_id
                /*for (WorkerModel workerModel : getWork) {
                    System.out.print(workerModel.id + ".");
                    System.out.print(workerModel.name);
                    System.out.print("-");
                    System.out.println(" " + workerModel.speciality);
                }*/

                /*Parent root;
                Stage stage;
                stage = (Stage) BookWorker.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("BookWorkerXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                */
                //Load second scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BookWorkerXML.fxml"));
                Parent root = loader.load();

                //Get controller of scene2
                BookWorkerController scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.initializeWorkerArrayList(getWork,Cust_id);

                //close window
                final Node source = (Node) event.getSource();
                final Stage hide = (Stage) source.getScene().getWindow();
                hide.close();
                //Show scene 2 in new window
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
            catch (Exception E){
                E.getMessage();
            }

        }
        catch (Exception E){
            E.getMessage();
        }
    }

    @FXML
    public void handleEditProfile1Action(ActionEvent event) {

    }

    @FXML
    public void handleLogout(ActionEvent event) {

    }

    @FXML
    public void handleShowFavouritesAction(ActionEvent event) {

    }

    @FXML
    public void handleShowFinishedBooking(ActionEvent event) {

    }

    @FXML
    public void handleshowActiveBooking(ActionEvent event) {

    }
    public void transferId(int _Cust_id) { //Communication: pass user's id from Controller (Multiple fxml files) to handlebookAction
        //Display the message
        Cust_id=_Cust_id;
    }

}
