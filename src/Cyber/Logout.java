package Cyber;


import java.io.FileInputStream;
import java.io.InputStream;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Logout extends Application {
static Stage nu=new  Stage();
String user;
String email2;
long tic2,brow2,pong2;
long time2;
    public Logout(String username,String email,long tic,long brow,long pong,long time1) {
    user=username;
    tic2=tic;
    brow2=brow;
    time2=time1;
    pong2=pong;
    email2=email;
    }
@Override
public void start(Stage primaryStage) throws Exception {
        nu=primaryStage;
        primaryStage.setTitle("Cyber Cafe Checkout Bill");
        InputStream input2 = getClass().getResourceAsStream("i.jpg");
        primaryStage.getIcons().add(new Image(input2));
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 1280, 720);
        // Set the scene in primary stage
        InputStream input = getClass().getResourceAsStream("logout.jpg"); 
  
            // create a image 
            Image image = new Image(input,1280,800,true,true); 
  
            // create a background image 
            BackgroundImage backgroundimage = new BackgroundImage(image,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundPosition.DEFAULT,  
                                                BackgroundSize.DEFAULT); 
  
            // create Background 
            Background background = new Background(backgroundimage); 
            gridPane.setBackground(background);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
   
    private void addUIControls(GridPane gridPane) {
    
        // Add Header
        Label headerLabel = new Label("Checkout Bill");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("User Name : ");
        gridPane.add(nameLabel, 0,1);
        
        headerLabel.setTextFill(Color.WHITE);
        nameLabel.setTextFill(Color.WHITE);
        
        
        Label name2Label = new Label(user+"        and Email :  "+email2);
        gridPane.add(name2Label, 1,1);
        name2Label.setTextFill(Color.WHITE);
        
        
        // Add Email Label
        Label appLabel = new Label("Apps Used : ");
        gridPane.add(appLabel, 0, 2);
        String a="",b="",c="";
        if(tic2>0)
            a="Tic Tac Toe";
        if(brow2>0)
            b="\nBrowser";
        if(pong2>0)
            c="\nPong";
        if(tic2==0&&brow2==0&&pong2==0)
            a="None";
        
        Label usedLabel = new Label(a+" "+b+" "+c);
        gridPane.add(usedLabel, 1, 2);
        
        
        Label timeLabel = new Label("Time running : ");
        gridPane.add(timeLabel, 0,3);
        appLabel.setTextFill(Color.WHITE);
        usedLabel.setTextFill(Color.WHITE);
        timeLabel.setTextFill(Color.WHITE);
        String line;
        line="Idle : "+time2/1000+" secs ";
        
        if(tic2>0)
            line+="\nTic tac toe : "+tic2/1000+" secs ";
        
        if(brow2>0)
           line+="\nBrowser : "+brow2/1000+" secs";
        
        if(pong2>0)
           line+="\nPong : "+pong2/1000+" secs";
       
        long sum=(tic2*10)+(brow2*20)+(time2*5)+(pong2*10);
        
        Label runningLabel = new Label(line);
        gridPane.add(runningLabel, 1,3);
        Label billLabel = new Label("Bill Amount : ");
        gridPane.add(billLabel, 0,4);
        double amount=sum/1800000;
        if(amount<10)
            amount=10;
        Label amountLabel = new Label("Rs. "+amount);
        gridPane.add(amountLabel, 1,4);
        Label messageLabel = new Label("Thank You, Visit Again");
        gridPane.add(messageLabel, 1,5);
        runningLabel.setTextFill(Color.WHITE);
        billLabel.setTextFill(Color.WHITE);
        amountLabel.setTextFill(Color.WHITE);
        messageLabel.setTextFill(Color.WHITE);
        Button registerButton = new Button("Go Home");
        registerButton.setPrefHeight(40);
        registerButton.setDefaultButton(true);
        registerButton.setPrefWidth(100);
        gridPane.add(registerButton, 0, 4, 2, 1);
        GridPane.setHalignment(registerButton, HPos.CENTER);
        GridPane.setMargin(registerButton, new Insets(20, -600,-250,0));
        
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
            Login ctc1 = new Login();
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc1.start(Login.nu);
                } catch (Exception ex) {
               
              }
                
            }
        });
        // Add Email Text Field
        
    } 
    
    public static void main(String[] args) {
        launch(args);
    }
}
