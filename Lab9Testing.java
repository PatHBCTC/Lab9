import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class Lab9Testing extends Application

   {
      
      private TextField username;
      private TextField password;
      
      
      private Label usernameLabel;
      private Label passwordLabel;
      
      public static void main(String[] args)
      
         {
         
            launch(args); 
         }
      
      @Override
      
      public void start(Stage primaryStage)
      
         {
            
            Label usernameLabel = new Label("Username:");
            
            Label passwordLabel = new Label("Password:");
            
            username = new TextField("");
            
            password = new TextField("");
            
            HBox usernameHBox = new HBox(10, usernameLabel, username);
            
            HBox passwordHBox = new HBox(10, passwordLabel, password);
            
            VBox loginBox = new VBox(10, usernameHBox, passwordHBox);
            
            usernameHBox.setAlignment(Pos.CENTER);
            
            passwordHBox.setAlignment(Pos.CENTER);
            
            loginBox.setAlignment(Pos.CENTER);
            
            Scene loginScene = new Scene(loginBox);
            
            primaryStage.setScene(loginScene);
            
            primaryStage.setHeight(500);
            
            primaryStage.setWidth(500);
            
            primaryStage.setTitle("Lab 9");
            
            primaryStage.show();
            
            
      }
      
}