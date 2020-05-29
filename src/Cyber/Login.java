package Cyber;


import java.io.*;
import java.util.*;

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

public class Login extends Application {
    
    String user1;
    
    static Stage nu=new Stage();
    int i=1;
    String user,email;
    @Override
    public void start(Stage primaryStage) throws Exception {
        nu=primaryStage;
        primaryStage.setTitle("Welcome to C7yber Cafe");
        InputStream input2 = getClass().getResourceAsStream("i.jpg");
        primaryStage.getIcons().add(new Image(input2));
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 1280, 800);
        // Set the scene in primary stage	
        InputStream input = getClass().getResourceAsStream("login.jpg"); 
  
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
            // set background 
         
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
        Label headerLabel = new Label("Cyber Cafe Login");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("User Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);

        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);
        headerLabel.setTextFill(Color.WHITE);
        nameLabel.setTextFill(Color.WHITE);
        passwordLabel.setTextFill(Color.WHITE);

        // Add Submit Button
        Button submitButton = new Button("Login");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, -250,20,0));
        
        Button homeButton = new Button("Close");
        homeButton.setPrefHeight(40);
        homeButton.setDefaultButton(true);
        homeButton.setPrefWidth(100);
        gridPane.add(homeButton, 0, 4, 2, 1);
        GridPane.setHalignment(homeButton, HPos.CENTER);
        GridPane.setMargin(homeButton, new Insets(20,0,20,0));
        
        
        Button registerButton = new Button("Register");
        registerButton.setPrefHeight(40);
        registerButton.setDefaultButton(true);
        registerButton.setPrefWidth(100);
        gridPane.add(registerButton, 0, 4, 2, 1);
        GridPane.setHalignment(registerButton, HPos.CENTER);
        GridPane.setMargin(registerButton, new Insets(20, 250,20,0));
        
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nu.close();
            }
        });
        
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nu.close();
            RegistrationFormApplication ctc = new RegistrationFormApplication();

                try {

                    ctc.start(RegistrationFormApplication.nu);
                } catch (Exception ex) {
                                 
                }
                
            }
        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Username");
                    return;
                }
                 if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Password");
                    return;
                }
                 File file = new File("out.txt");
                if (file.exists())
                {
               
                try {
			
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				StringTokenizer st1 = 
                                 new StringTokenizer(line, "#");
                                
                               if (st1.hasMoreTokens()) 
                                     if(nameField.getText().equals(st1.nextToken())&&passwordField.getText().equals(st1.nextToken()))
                                     {
                                         showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Login Successful.", "Welcome " + nameField.getText());
                                         email=st1.nextToken();
                                         user1=nameField.getText();
                                         
                                         Cyberinterface ctc=new Cyberinterface(user1,email,0,0,0,0);
                                          nu.close();
                                          i=0;
                                          try {
                                             ctc.start(Cyberinterface.nu);
                                              } catch (Exception ex) {
                                        }
                                            
                                     }
			}
			fileReader.close();
			
		} catch (IOException e) {
			
                }
                if(i==1)
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Invalid Username or Password.");
                }
                else
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "No One Registered Yet !");
                
                    
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