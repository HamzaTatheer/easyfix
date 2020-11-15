package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.models.SparePartModel;
import com.easyfix.Application.ui.UI;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        Text text = new Text();

        //Setting font to the text
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

        //setting the position of the text
        text.setX(50);
        text.setY(130);

        //Setting the color
        text.setFill(Color.GREEN);

        //Setting the Stroke
        text.setStrokeWidth(2);

        // Setting the stroke color
        text.setStroke(Color.YELLOW);





        for(int i=0;i<buttonsArr.length;i++) {
            if (actionEvent.getSource() == buttonsArr[i]) {
                try {

                    sparePartService.addSparePartsToBooking(bID, i, 1);
                    //Setting the text to be added.
                    text.setText("Added");

                    //Creating a Group object
                    Group root = new Group(text);

                    //Creating a scene object
                    Scene scene = new Scene(root, 600, 300);

                    // can use an Alert, Dialog, or PopupWindow as needed...
                    Stage popup = new Stage();
                    // configure UI for popup etc...
                    popup.setScene(scene);
                    // hide popup after 3 seconds:
                    PauseTransition delay = new PauseTransition(Duration.seconds(1));
                    delay.setOnFinished(e -> popup.hide());

                    popup.show();
                    delay.play();
                }
                catch (Exception E){
                    //Setting the text to be added.
                    text.setFill(Color.RED);
                    text.setText("Not Added");

                    //Creating a Group object
                    Group root = new Group(text);

                    //Creating a scene object
                    Scene scene = new Scene(root, 600, 300);

                    // can use an Alert, Dialog, or PopupWindow as needed...
                    Stage popup = new Stage();
                    // configure UI for popup etc...
                    popup.setScene(scene);
                    // hide popup after 3 seconds:
                    PauseTransition delay = new PauseTransition(Duration.seconds(1));
                    delay.setOnFinished(e -> popup.hide());

                    popup.show();
                    delay.play();
                    //System.out.println(E.getMessage());
                }

                //System.out.println("Button" + (i + 1) + "Pressed\n");
                //System.out.println("WorkerID selected"+selected_WID);
            }
        }

    }


}
