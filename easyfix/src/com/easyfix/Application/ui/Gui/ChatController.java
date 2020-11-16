package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.ChatMessageModel;
import com.easyfix.Application.ui.UI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.easyfix.Application.ui.Gui.Controller.Choice;
import static com.easyfix.Application.ui.Gui.Controller.username;

public class ChatController extends UI {
    int sen;//sender id
    int rec;//reciever id
    ArrayList<ChatMessageModel>getchat;
    private ObservableList<ChatJAVAFX> list;
    @FXML
    private Button ConfirmationHome;

    @FXML
    private TableColumn<ChatJAVAFX, String> ChatMessage2;

    @FXML
    private TextField sendText;

    @FXML
    private Button sendMessage;

    @FXML
    private Button RefreshButton;

    @FXML
    private TableView<ChatJAVAFX> TableView;

    @FXML
    private TableColumn<ChatJAVAFX, String> ChatMessage;

    @FXML
    void HandleRefreshAction(ActionEvent event) {
        //close window
        final Node source = (Node) event.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatXML.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            ChatController scene2Controller = loader.getController();
            ArrayList<ChatMessageModel>getchats=chatService.loadMessageHistory(sen,rec);
            //Pass whatever data you want. You can have multiple method calls here

            scene2Controller.initializeChatArrayList(getchats,sen,rec);

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }

    @FXML
    void handleConfirmationHome(ActionEvent event) {
        //close window
        final Node source = (Node) event.getSource();
        final Stage hide = (Stage) source.getScene().getWindow();
        hide.close();
        try {
            //Load second scene
            FXMLLoader loader;
            Parent root;
            if(Choice.equalsIgnoreCase("customer")) {

                loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
                root = loader.load();

                //Get controller of scene2
                controllerHomePage scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.transferId(sen);
            }
            else{
                loader = new FXMLLoader(getClass().getResource("workerhomepage.fxml"));
                root = loader.load();

                //Get controller of scene2
                controllerWorkerHomePage scene2Controller = loader.getController();
                //Pass whatever data you want. You can have multiple method calls here
                scene2Controller.getWID(sen);
            }

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception E){
            System.out.println(E.getMessage());
        }

    }

    @FXML
    void handleSendMessage(ActionEvent event) {
        try{
            boolean a=chatService.sendMessage(sen,rec,Choice,sendText.getText());
            showAlert("Message Sent", Alert.AlertType.INFORMATION);
            sendText.setText("");
        }
        catch (Exception E){
            showAlert(E.getMessage(), Alert.AlertType.INFORMATION);
        }

    }


    private void showAlert(String alertMessage, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(alertMessage);
        alert.show();
    }
    public void initializeChatArrayList(ArrayList<ChatMessageModel> Chat, int _c,int _w){
        try {
            getchat = new ArrayList<ChatMessageModel>(Chat);
            sen = _c;
            rec = _w;
            //setSpacing(5);
            TableView.setStyle("-fx-alignment: Centre;");

            ChatMessage.setCellValueFactory(new PropertyValueFactory<ChatJAVAFX, String>("mess"));
            ChatMessage2.setCellValueFactory(new PropertyValueFactory<ChatJAVAFX, String>("mess2"));
            //System.out.println(username);
            list = FXCollections.observableArrayList();
            for (ChatMessageModel chatMessageModel : getchat) {

                    if (!username.equals(chatMessageModel.senderName)|| sen!=chatMessageModel.senderId) {
                        list.add(new ChatJAVAFX(chatMessageModel.message, ""));
                    } else {
                        list.add(new ChatJAVAFX("", chatMessageModel.message));
                    }

            }
            TableView.setItems(list);
        }
        catch (Exception e){
            showAlert(e.getMessage(), Alert.AlertType.INFORMATION);
        }

    }
}
