package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label loginmessage;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void Login(ActionEvent event)
    {

        if(usernameField.getText().equals("test") && passwordField.getText().equals("123"))
        {
            try
            {
                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                String css = this.getClass().getResource("sample.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setWidth(720);
                stage.setHeight(720);
                stage.setScene(scene);
                stage.centerOnScreen();
                System.out.println("You are logged in as:  " + usernameField.getText());
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
       }

        else
        {
            loginmessage.setText("Incorrect Username/Password. Please Try Again");
            }

    }

}
