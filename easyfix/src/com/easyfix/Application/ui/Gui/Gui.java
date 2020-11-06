package com.easyfix.Application.ui.Gui;

import com.easyfix.Application.ui.UI;

public class Gui extends UI {
    Gui(){

    }
    public void start(){
        System.out.println("Gui");
    }

}



/*
import com.easyfix.Application.bl.serviceProviders;
import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.ui.UI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import com.easyfix.Application.models.WorkerModel;
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
    Scene scene4;
    static int userid;
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

                try {
                    String finalemail = emaill2.getText();
                    String finalpass = passw2.getText();
                    userid = customerService.login(finalemail, finalpass);
                    System.out.println("Login Successful");
                    primaryStage.setScene(scene3);


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    userid =-2;
                }
            }

        });

        btn2.setOnAction(e-> primaryStage.setScene(scene2));

        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    String regName = namee.getText();
                    String regEmail = emaill.getText();
                    String regPass = passw.getText();
                    String regCity = cityy.getText();
                    String regArea = areaa.getText();
                    userid = customerService.register(regName,regEmail,regPass,regCity,regArea);
                    System.out.println("Register Successful");
                    primaryStage.setScene(scene3);


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    userid=-2;
                }
            }

        });
        Button Getfavourite = new Button("Getfavourite");
        Getfavourite.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                ArrayList<WorkerModel> favourites = customerService.getFavourites(userid);
                String fav = favourites.toString();
                System.out.println(fav);
            }

        });
        Button EditProfile = new Button("Edit Profile");
        EditProfile.setOnAction(e -> primaryStage.setScene(scene4));

        Label ccity = new Label("Enter City name");
        TextField ccityy = new TextField();
        Button changecity = new Button("Change City");
        changecity.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String finalcity = ccityy.getText();
                boolean check = customerService.changeCity(userid,finalcity);
                if(check == true )
                    System.out.println("City changed");
                else
                    System.out.println("unable to change city");
            }

        });

        Label carea = new Label("Enter Area name");
        TextField careaa = new TextField();
        Button changearea = new Button("Change Area");
        changecity.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String finalarea = careaa.getText();
                boolean check = customerService.changeArea(userid,finalarea);
                if(check == true )
                    System.out.println("Area changed");
                else
                    System.out.println("unable to change Area");
            }

        });

        Label cpaymethod = new Label("Enter payment method");
        TextField cpaymethodd = new TextField();
        Button changepaymethod = new Button("Change Payment Method");
        changecity.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String finalpaymethod = cpaymethodd.getText();
                boolean check = customerService.changePaymentMethod(userid,finalpaymethod);
                if(check == true )
                    System.out.println("Payment Method changed");
                else
                    System.out.println("unable to change Payment Method");
            }

        });

        root.getChildren().addAll(email2,emaill2,pass2,passw2,btn,btn2);
        scene = new Scene(root, 500, 300);

        vbox.getChildren().addAll(name,namee,email,emaill,pass,passw,city,cityy,area,areaa,btn3);
        scene2 = new Scene(vbox, 500, 300);

        VBox homepage = new VBox();
        homepage.setAlignment(Pos.BASELINE_CENTER);
        homepage.getChildren().addAll(Getfavourite,EditProfile);
        scene3 = new Scene(homepage,500,300);

        VBox EditProfilee = new VBox();
        EditProfilee.setAlignment(Pos.BASELINE_LEFT);
        EditProfilee.getChildren().addAll(ccity,ccityy,changecity,carea,careaa,changearea,cpaymethod,cpaymethodd,changepaymethod);
        scene4 = new Scene(EditProfilee,500,300);

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
*/
