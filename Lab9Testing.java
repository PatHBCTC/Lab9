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
//SQL imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Lab9Testing extends Application

   {
      
      private TextField usernameField;
      private TextField passwordField;
      
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
            
            usernameField = new TextField("");
            
            passwordField = new TextField("");
            
            Button loginButton = new Button("Login");
            
            loginButton.setOnAction(new LoginButtonHandler());
            
            HBox usernameHBox = new HBox(10, usernameLabel, usernameField);
            
            HBox passwordHBox = new HBox(10, passwordLabel, passwordField);
            
            VBox loginBox = new VBox(10, usernameHBox, passwordHBox, loginButton);
            
            usernameHBox.setAlignment(Pos.CENTER);
            
            passwordHBox.setAlignment(Pos.CENTER);
            
            loginBox.setAlignment(Pos.CENTER);
            
            Scene loginScene = new Scene(loginBox);
            
            primaryStage.setScene(loginScene);
            
            primaryStage.setHeight(200);
            
            primaryStage.setWidth(400);
            
            primaryStage.setTitle("Yeet");
            
            primaryStage.show();
            
      }
      
      class LoginButtonHandler implements EventHandler<ActionEvent>
         {
         
            @Override
            
            public void handle(ActionEvent event)
            
            { 
            
               // Delcare JDBC objects
               Connection con = null;
               Statement stmt = null;
               ResultSet rs = null;
               
               try
               {
               
                  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDrier");
               
                  String userName = usernameField.getText();
                  String password = passwordField.getText();
                  String url  = "jdbc:sqlserver://sql1.cis.mc3.edu"+";databaseName=<DATABASE NAME>";
                  con = DriverManager.getConnection(url, userName, password);
                  stmt = con.createStatement();
                  rs = stmt.executeQuery("SELECT * FROM Welcome Where Students_Name = 'Instructor'");
            
               }
               catch(Exception e)
               {
                  
                  e.printStackTrace();
                  
               }
               
               
               
               
            
            }
            

      }

      
}
