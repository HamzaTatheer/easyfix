package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.bl.serviceProviders;
import com.easyfix.Application.bl.services.BookingService;
import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import com.easyfix.Application.models.WorkerModel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import com.easyfix.Application.bl.classes.SparePart;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.serviceProviders;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.IOException;

public class Gui extends Application {

    static int userid;
    static int workerid;



    public Gui(){
        super();
        //customerService = serviceProviders.getCustomerService();
        //names = new ArrayList<Label>();
        //emails = new ArrayList<Label>();
    }


    public static void start() {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }



    }


