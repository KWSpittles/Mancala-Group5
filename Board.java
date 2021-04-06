package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Board  {

    private Side Player1Side;
    private Side Player2Side;
    Hole Player1Store = new Hole();
    Hole Player2Store = new Hole();

    public Board() {
        Player1Side = new Side(1);
        Player2Side = new Side(2);
        Hole Player1Store = new Hole();
        Hole Player2Store = new Hole();
    }

    public Board(int stones) {
        Player1Side = new Side(1, stones);
        Player2Side = new Side(2, stones);
        Hole Player1Store = new Hole();
        Hole Player2Store = new Hole();
    }

    public Side getPlayer1Side() {
        return Player1Side;
    }

    public Side getPlayer2Side() {
        return Player2Side;
    }

    public Hole getPlayer1Store() {
        return Player1Store;
    }

    public Hole getPlayer2Store() {
        return Player2Store;
    }
}