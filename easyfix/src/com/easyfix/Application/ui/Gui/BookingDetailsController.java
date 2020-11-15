package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BookingDetailsController extends UI {
    private int Cust_ID;
    private int Work_ID;
    Boolean flag;
    @FXML
    private TextField MonthText;
    @FXML
    private Button DetailsHome;
    @FXML
    private TextField DateText;
    @FXML
    private TextField Hour;

    @FXML
    private TextField MinuteText;

    @FXML
    private Button Next;

    @FXML
    private TextField TitleText;
    String N,S;
    Float R,HR;
    @FXML
    void HandleDetailsHome(ActionEvent event) {
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

    public void recieveData(int C,int W,String name,Float rate,Float hourRate,String special){
        Cust_ID=C;
        Work_ID=W;
        N=name;
        S=special;
        R=rate;
        HR=hourRate;

    }

    public void HandleFinalBookAction(ActionEvent actionEvent){
        //
        int y;
    }
    public void HandleNextAction(ActionEvent actionEvent) throws Exception {

        try{
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
            //ArrayList<SparePartModel> sendSpareParts=sparePartService.showAllSpareParts();
            //close window
            final Node source = (Node) actionEvent.getSource();
            final Stage hide = (Stage) source.getScene().getWindow();
            hide.close();


            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingConfirmationXML.fxml"));
            Parent root = loader.load();

            //Get controller of scene2
            BookingConfirmationController scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here'
            scene2Controller.intializeBookingConfirmation(Cust_ID,Work_ID,Integer.parseInt(DateText.getText()),Integer.parseInt(MonthText.getText()),Integer.parseInt(Hour.getText()),Integer.parseInt(MinuteText.getText()),TitleText.getText(),N,S,R,HR);
            //Setting the text to be added.
            text.setText("SUCCESS");

            //Creating a Group object
            Group rt = new Group(text);

            //Creating a scene object
            Scene scene = new Scene(rt, 600, 300);

            // can use an Alert, Dialog, or PopupWindow as needed...
            Stage popup = new Stage();
            // configure UI for popup etc...
            popup.setScene(scene);
            // hide popup after 3 seconds:
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(e -> popup.hide());

            popup.show();
            popup.show();
            delay.play();
            delay.play();
            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch (Exception F){
            Text text = new Text();

            //Setting font to the text
            text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

            //setting the position of the text
            text.setX(10);
            text.setY(10);

            //Setting the color
            text.setFill(Color.RED);

            //Setting the Stroke
            text.setStrokeWidth(2);

            // Setting the stroke color
            text.setStroke(Color.YELLOW);
            text.setText("\n\nFailure\n"+F.getMessage()+"\nInvalid Inputs");

            //Creating a Group object
            Group rt = new Group(text);

            //Creating a scene object
            Scene scene = new Scene(rt, 600, 300);

            // can use an Alert, Dialog, or PopupWindow as needed...
            Stage popup = new Stage();
            // configure UI for popup etc...
            popup.setScene(scene);
            // hide popup after 3 seconds:
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> popup.hide());

            popup.show();
            delay.play();
            delay.play();
            delay.play();
            //close window
            final Node source = (Node) actionEvent.getSource();
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
    }
}
