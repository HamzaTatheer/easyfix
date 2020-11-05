package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.easyfix.Application.bl.services.CustomerService;
public class Gui  extends Application {

    public CustomerService customerService;
    public Gui(){
        super();
    }

    @Override
    public void start(Stage primaryStage) {
        Label email = new Label("Email");
        GridPane.setConstraints(email,0,0);
        TextField emaill = new TextField();
        String finalemail = emaill.getText();
        GridPane.setConstraints(emaill,0,1);
        Label pass = new Label("Password");
        GridPane.setConstraints(pass,0,2);
        TextField passw = new TextField();
        String finalpass = passw.getText();
        GridPane.setConstraints(passw,0,3);
        Button btn = new Button();
        GridPane.setConstraints(btn,2,4);
        btn.setText("Login");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int userid;
                try {

                    userid = customerService.login(finalemail, finalpass);
                    System.out.println("Login Successful");


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    userid=-2;
                }
            }
        });

        GridPane root = new GridPane();
        root.getChildren().addAll(email,emaill,pass,passw,btn);

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void start() {
        launch();
    }

    //public void start(){
        //still working

//    }

}
