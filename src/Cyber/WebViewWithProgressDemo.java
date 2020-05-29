package Cyber;
 
import java.io.InputStream;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class WebViewWithProgressDemo extends Application {
   static Stage nu=new Stage();
   long ct=System.currentTimeMillis(),pt;
   String user,email2;
   long tic2,brow2,time2,pong2;
    public WebViewWithProgressDemo(String username,String email,long tic,long brow,long pong,long time1) {
    user=username;
    tic2=tic;
    brow2=brow;
    time2=time1;
    pong2=pong;
    email2=email;
    }
   @Override
   public void start(final Stage stage) {
       nu=stage;
       stage.setTitle("C7yber Cafe Browser");
       InputStream input2 = getClass().getResourceAsStream("i.jpg");
       stage.getIcons().add(new Image(input2));
       TextField addressBar = new TextField();
       addressBar.setText("https://google.com");
       Button goButton = new Button("Go!");
       Button goBackButton = new Button("Go Home");
       Label stateLabel = new Label();
 
       stateLabel.setTextFill(Color.BLACK);
       ProgressBar progressBar = new ProgressBar();
 
       final WebView browser = new WebView();
       final WebEngine webEngine = browser.getEngine();
 
       // A Worker load the page
       Worker<Void> worker = webEngine.getLoadWorker();
 
        // Listening to the status of worker
       worker.stateProperty().addListener(new ChangeListener<State>() {
 
           @Override
           public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
               stateLabel.setText("Loading state: " + newValue.toString());
               if (newValue == Worker.State.SUCCEEDED) {
                   stage.setTitle(webEngine.getLocation());
                   stateLabel.setText("Done.");
               }
           }
       });
 
       // Bind the progress property of ProgressBar
       // with progress property of Worker
       progressBar.progressProperty().bind(worker.progressProperty());
       addressBar.setOnKeyPressed((KeyEvent e) -> {
           if(e.getCode()==e.getCode().ENTER){
           String url = addressBar.getText();
               // Load the page.
               webEngine.load(url);
           }
       });
 
       goButton.setOnAction(new EventHandler<ActionEvent>() {
 
           @Override
           public void handle(ActionEvent event) {
               String url = addressBar.getText();
               // Load the page.
               webEngine.load(url);
           }
       });
       goBackButton.setOnAction(new EventHandler<ActionEvent>() {
 
           @Override
           public void handle(ActionEvent event) {
               stage.close();
               Cyberinterface ctc = new Cyberinterface(user,email2,tic2,(System.currentTimeMillis()-ct+brow2),pong2,time2);
             
                try {
                    // Then call its start() method in the following way:

                    ctc.start(Cyberinterface.nu);
                } catch (Exception ex) {
               
              }
           }
       });
       
 
       VBox root = new VBox();
       root.getChildren().addAll(addressBar, goButton,goBackButton, stateLabel, progressBar, browser);
 
       Scene scene = new Scene(root);
 
       stage.setScene(scene);
       stage.setWidth(1000);
       stage.setHeight(800);
 
       stage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
 
}