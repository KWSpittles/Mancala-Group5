package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginPageController {

    @FXML
    private Label lblGameHeading;
    @FXML
    private Label lblGameHeadSuffix;
    @FXML
    private Label lblSignIn;
    @FXML
    private Label lblForgot;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnSignIn;
    @FXML
    private Button btnSignUp;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void handleBtnAction(ActionEvent event) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signUpPage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String css = Objects.requireNonNull(this.getClass().getResource("loginPage.css")).toExternalForm();
        scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
    }

    public void signInBtnAction(ActionEvent event) throws Exception {
        if (tfEmail.getText().equals("test") && pfPassword.getText().equals("123")) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginPage.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            String css = Objects.requireNonNull(this.getClass().getResource("loginPage.css")).toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.centerOnScreen();
            System.out.println("You are logged in as:  " + tfEmail.getText());

        } else {
            System.out.println("Login didn't work");
        }
    }
}