package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.bl.serviceProviders;
import com.easyfix.Application.ui.UI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.serviceProviders;
public class Gui extends Application {


    Scene scene;
    Scene scene2;
    Scene scene3;

    public CustomerService customerService;


    public Gui(){
        super();
        customerService = serviceProviders.getCustomerService();
    }

    @Override
    public void start(Stage primaryStage) {
        Label email = new Label("Email");
    //    GridPane.setConstraints(email,0,0);
        TextField emaill = new TextField();

        Label email2 = new Label("Email");
        //    GridPane.setConstraints(email,0,0);
        TextField emaill2 = new TextField();

     //   GridPane.setConstraints(emaill,0,1);
        Label pass = new Label("Password");
      //  GridPane.setConstraints(pass,0,2);
        TextField passw = new TextField();

        Label pass2 = new Label("Password");
        //  GridPane.setConstraints(pass,0,2);
        TextField passw2 = new TextField();


       // GridPane.setConstraints(passw,0,3);
        Button btn = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
      //  GridPane.setConstraints(btn,2,4);
        btn.setText("Login");
        btn2.setText("Register");
        btn3.setText("Register");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_LEFT);

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_LEFT);

        Label name = new Label("Name");
        TextField namee = new TextField();

        Label city = new Label("City");
        TextField cityy = new TextField();

        Label area = new Label("Area");
        TextField areaa = new TextField();
       // GridPane.setConstraints(btn3,4,6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int userid;
                try {
                    String finalemail = emaill.getText();
                    String finalpass = passw.getText();
                    userid = customerService.login(finalemail, finalpass);
                    System.out.println("Login Successful");


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    userid=-2;
                }
            }

        });

        btn2.setOnAction(e-> primaryStage.setScene(scene2));

        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int userid;
                try {
                    String regName = namee.getText();
                    String regEmail = emaill.getText();
                    String regPass = passw.getText();
                    String regCity = cityy.getText();
                    String regArea = areaa.getText();
                    userid = customerService.register(regName,regEmail,regPass,regCity,regArea);
                    System.out.println("Register Successful");


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    userid=-2;
                }
            }

        });


        root.getChildren().addAll(email2,emaill2,pass2,passw2,btn,btn2);
        scene = new Scene(root, 500, 300);

        vbox.getChildren().addAll(name,namee,email,emaill,pass,passw,city,cityy,area,areaa,btn3);
        scene2 = new Scene(vbox, 500, 300);

        
        primaryStage.setTitle("EasyFix");
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
