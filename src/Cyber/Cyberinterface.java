package Cyber;



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Cyberinterface extends Application {
    String user,email2;
    long tic2,brow2,time2,pong2;
    long ct=System.currentTimeMillis(),pt;
    public Cyberinterface(String username,String email,long tic,long brow,long pong,long time1) {
    user=username;
    brow2=brow;
    tic2=tic;
    time2=time1;
    pong2=pong;
    email2=email;
    }

    
    static Stage nu=new Stage();

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        nu=primaryStage;
        primaryStage.setTitle("C7yber Cafe");
        InputStream input2 = getClass().getResourceAsStream("i.jpg");
        primaryStage.getIcons().add(new Image(input2));
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 1280, 800);
        
        InputStream input = getClass().getResourceAsStream("interface.jpg"); 
  
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
        // Set the scene in primary stage	
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
        Label headerLabel = new Label("Welcome to the Cyber Cafe ");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        
        // Add Name Label
        Label nameLabel = new Label("Apps : ");
        gridPane.add(nameLabel, 0,1);
        nameLabel.setFont(Font.font("Arial", FontWeight.LIGHT, 20));

        headerLabel.setTextFill(Color.WHITE);

        // Add Submit Button
        Button submitButton = new Button("Browser ");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,200,0));
        
        Button tictacButton = new Button("TicTacToe");
        
        tictacButton.setPrefHeight(40);
        tictacButton.setDefaultButton(true);
        tictacButton.setPrefWidth(100);
        gridPane.add(tictacButton, 0, 4, 2, 1);
        GridPane.setHalignment(tictacButton, HPos.CENTER);
        GridPane.setMargin(tictacButton, new Insets(20, 300,200,0));
        
        Button registerButton = new Button("Logout");
        registerButton.setPrefHeight(40);
        registerButton.setDefaultButton(true);
        registerButton.setPrefWidth(100);
        gridPane.add(registerButton, 0, 4, 2, 1);
        GridPane.setHalignment(registerButton, HPos.CENTER);
        GridPane.setMargin(registerButton, new Insets(20, -600,-250,0));
        
        Button pongb = new Button("Pong");
        pongb.setPrefHeight(40);
        pongb.setDefaultButton(true);
        pongb.setPrefWidth(100);
        gridPane.add(pongb, 0, 4, 2, 1);
        GridPane.setHalignment(pongb, HPos.CENTER);
        GridPane.setMargin(pongb, new Insets(20, 600,200,0));
        
        pongb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              pt=System.currentTimeMillis()-ct+time2;  
            Pong ctc1 = new Pong(user,email2,tic2,brow2,pong2,pt);
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc1.start(Pong.nu);
                } catch (Exception ex) {
               
              }
                
            }
        });
        
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              pt=System.currentTimeMillis()-ct+time2;  
            Logout ctc1 = new Logout(user,email2,tic2,brow2,pong2,pt);
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc1.start(Logout.nu);
                } catch (Exception ex) {
               
              }
                
            }
        });


        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pt=System.currentTimeMillis()-ct+time2; 
               WebViewWithProgressDemo ctc = new WebViewWithProgressDemo(user,email2,tic2,brow2,pong2,pt);
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc.start(WebViewWithProgressDemo.nu);
                } catch (Exception ex) {
               
              }
            }
        });
        
        tictacButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pt=System.currentTimeMillis()-ct+time2; 
              TicTacToeApp ctc = new TicTacToeApp(user,email2,tic2,brow2,pong2,pt);
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc.start(TicTacToeApp.nu);
                } catch (Exception ex) {
               
              }
            }
        });
    }
    

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}