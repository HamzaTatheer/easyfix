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

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Gui extends Application {


    Scene scene;
    Scene scene2;
    Scene scene3;
    Scene scene4;
    Scene scene5;
    Scene scene6;
    Scene favouritescene;
    private ArrayList<Label> names ;
    private ArrayList<Label> emails;
    static int userid;
    static int workerid;
    public CustomerService customerService;
    public BookingService bookingService;

    public Gui(){
        super();
        customerService = serviceProviders.getCustomerService();
        names = new ArrayList<Label>();
        emails = new ArrayList<Label>();
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

        ///////////////////////////
        //VBox root = new VBox();
        //root.setAlignment(Pos.TOP_LEFT);
        GridPane gp=new GridPane();
        gp.setPadding(new Insets(20,20,20,20));
        gp.setHgap(5);
        gp.setVgap(5);

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));

        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gp.setEffect(r);

        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        Text text = new Text("EasyFix Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().add(text);

        //Add ID's to Nodes
        bp.setId("bp");
        gp.setId("root");
        btn.setId("btnLogin");
        text.setId("text");

        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gp);

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


                getFav();
                primaryStage.setScene(favouritescene);
            }
            Label nam,email123;
            private void getFav() {
                //String fav = favourites.toString();
                ArrayList<WorkerModel> favourites = customerService.getFavourites(userid);
                //System.out.println(favourites.size());
                for (WorkerModel fav : favourites)
                {
                    nam = new Label(fav.name);
                    names.add(nam);
                    email123 = new Label(fav.email);
                    emails.add(email123);
                }
            }

        });
        System.out.println(names.size());
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
        changearea.setOnAction(new EventHandler<ActionEvent>() {

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
        changepaymethod.setOnAction(new EventHandler<ActionEvent>() {

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
        Label three = new Label("saqib");
        Label four = new Label("saqib@gmail.com");
        //root.getChildren().addAll(email2,emaill2,pass2,passw2,btn,btn2);
        scene = new Scene(bp);
        ////////////////////////////////////////
        scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        //Creating title

        gp.addRow(2, email2,emaill2);
        gp.addRow(3, pass2,passw2);
        gp.addRow(5, btn);
        gp.addRow(7, btn2);

        //   scene2.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
     //   scene3.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
     //   scene4.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
     //   scene5.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
     //   scene6.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
     //   favouritescene.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());

        Label one = new Label("mufa");
        Label two = new Label("mufa@gmail.com");
        //String workerss = workers.toString();
       // Label ww = new Label(workerss);


        ArrayList<Label> workersname = new ArrayList<Label>();
        ArrayList<Label> workersid = new ArrayList<Label>();
        ArrayList<Label> workersemail = new ArrayList<Label>();workersname.add(one);workersname.add(three);
        workersemail.add(two);workersemail.add(four);
        vbox.getChildren().addAll(name,namee,email,emaill,pass,passw,city,cityy,area,areaa,btn3);
        scene2 = new Scene(vbox, 500, 300);
        Button addbooking = new Button("Book Worker");
        addbooking.setOnAction(e -> primaryStage.setScene(scene5));
        VBox bookworker = new VBox();
        bookworker.setAlignment(Pos.BASELINE_LEFT);
        Button booktop = new Button("Book Top worker");
        ArrayList<Integer> spare = new ArrayList<Integer>();String text1= "Booking your wotker";
        booktop.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LocalDateTime time = LocalDateTime.now();
                try {
                    bookingService.makeBooking(userid,workerid,text1,time,spare);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                primaryStage.setScene(scene6);
            }

        });
        VBox bookingdone = new VBox();
        scene6 = new Scene(bookingdone,500,300);
        Label done = new Label("Booking Successfull");
        bookingdone.getChildren().add(done);
        scene5 = new Scene(bookworker,500,300);
        bookworker.getChildren().addAll(workersname);
        bookworker.getChildren().addAll(workersemail);
        bookworker.getChildren().add(booktop);
        addbooking.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                getcloseby();
                primaryStage.setScene(scene5);
            }
            Label n,e;
            private void getcloseby() {
                ArrayList<WorkerModel> workers = customerService.getWorkersCloseBy(userid);

                for(WorkerModel work : workers)
                {

                    n = new Label(work.name);
                    //workersid.add(work.id.);
                    workersname.add(n);
                    e = new Label(work.email);
                    workersemail.add(e);
                }

            }

        });
        VBox homepage = new VBox();
        homepage.setAlignment(Pos.BASELINE_CENTER);
        homepage.getChildren().addAll(Getfavourite,EditProfile,addbooking);
        scene3 = new Scene(homepage,500,300);

        VBox EditProfilee = new VBox();
        EditProfilee.setAlignment(Pos.BASELINE_LEFT);
        EditProfilee.getChildren().addAll(ccity,ccityy,changecity,carea,careaa,changearea,cpaymethod,cpaymethodd,changepaymethod);
        scene4 = new Scene(EditProfilee,500,300);

        VBox showfav = new VBox();names.add(one);emails.add(two);
        showfav.setAlignment(Pos.BASELINE_LEFT);
        showfav.getChildren().addAll(names);
        showfav.getChildren().addAll(emails);
        favouritescene = new Scene(showfav,500,300);
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

