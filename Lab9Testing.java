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
import javax.swing.*;
//SQL imports
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;



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
         
            
            public void handle(ActionEvent event)
            
            {
            
            Connection conn = null;
            Statement stmt = null;
            ResultSet result = null;
   
            String DatabaseURL = "jdbc:sqlserver://sql1.cis.mc3.edu" + ";databaseName = CIS111B";
            
            String user = usernameField.getText();
            String pass = passwordField.getText();
            
            //if statement for joption 
            
            
            try
            {
            // Create connection to SQL
            conn = DriverManager.getConnection(DatabaseURL, user, pass);
            System.out.println("Connected to: " + DatabaseURL);
            
            stmt = conn.createStatement();
            
            //INSERT INTO Sys_Login_Audit (Audit_ID, User_ID, Dte_Time_Stmp, Student_Init) " + "VALUES (NEWID(), 'CIS111BUser', GETDATE(), 'MRS')"
            String sqlStatement = "SELECT * FROM Student WHERE Student_FullName = '<SELECTED FROM DROP-DOWN>'";
            System.out.println("Statement created: " + stmt);
            
            result = stmt.executeQuery(sqlStatement);
            
               while(result.next())
               {
            
                  System.out.println(result.getString(1));
            
               }
            
            conn.close();
            
            }
            catch(Exception e)
            {
               
               JOptionPane.showMessageDialog(null, "Error: \n" + e);
               
            
            }
         
         
         }            

      }

      
}
