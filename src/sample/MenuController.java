package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane scenePane;

    public void switchToGame(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.centerOnScreen();
        stage.setScene(scene);
        Game game = new Game(4);
        stage.show();
        System.out.println("You are now playing a game of Mancala! Enjoy");
    }

    public void switchToLeaderboard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setWidth(720);
        stage.setHeight(720);
        stage.centerOnScreen();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are logging out");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
            System.out.println("You have logged out successfully");

        }
    }
}
