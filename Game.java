package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Game implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Board gameBoard;
    private int playerNumber1;
    private int playerNumber2;


    public Game() {
        gameBoard = new Board();
        playerNumber1 = 1;
        playerNumber2 = 2;
    }

    public Game(int stones) {
        gameBoard = new Board(stones);
        playerNumber1 = 1;
        playerNumber2 = 2;
    }

    public void initialiseBoard(int value) {

        gameBoard.getPlayer1Side().getHole(0).setPitValue(value);
        gameBoard.getPlayer1Side().getHole(1).setPitValue(value);
        gameBoard.getPlayer1Side().getHole(2).setPitValue(value);
        gameBoard.getPlayer1Side().getHole(3).setPitValue(value);
        gameBoard.getPlayer1Side().getHole(4).setPitValue(value);
        gameBoard.getPlayer1Side().getHole(5).setPitValue(value);
        gameBoard.getPlayer1Store().setPitValue(0);
        gameBoard.getPlayer2Side().getHole(0).setPitValue(value);
        gameBoard.getPlayer2Side().getHole(1).setPitValue(value);
        gameBoard.getPlayer2Side().getHole(2).setPitValue(value);
        gameBoard.getPlayer2Side().getHole(3).setPitValue(value);
        gameBoard.getPlayer2Side().getHole(4).setPitValue(value);
        gameBoard.getPlayer2Side().getHole(5).setPitValue(value);
        gameBoard.getPlayer2Store().setPitValue(0);

        System.out.println("You have displayed a new Board");

    }

    public void resetBoard(ActionEvent event) {

        gameBoard.getPlayer1Side().getHole(0).setPitValue(4);
        gameBoard.getPlayer1Side().getHole(1).setPitValue(4);
        gameBoard.getPlayer1Side().getHole(2).setPitValue(4);
        gameBoard.getPlayer1Side().getHole(3).setPitValue(4);
        gameBoard.getPlayer1Side().getHole(4).setPitValue(4);
        gameBoard.getPlayer1Side().getHole(5).setPitValue(4);
        gameBoard.getPlayer1Store().setPitValue(0);
        gameBoard.getPlayer2Side().getHole(0).setPitValue(4);
        gameBoard.getPlayer2Side().getHole(1).setPitValue(4);
        gameBoard.getPlayer2Side().getHole(2).setPitValue(4);
        gameBoard.getPlayer2Side().getHole(3).setPitValue(4);
        gameBoard.getPlayer2Side().getHole(4).setPitValue(4);
        gameBoard.getPlayer2Side().getHole(5).setPitValue(4);
        gameBoard.getPlayer2Store().setPitValue(0);

        displayBoard();

        System.out.println("You have displayed a new Board");

    }

    @FXML
    public Label pit1, pit2, pit3, pit4, pit5, pit6, pit7, pit8, pit9, pit10, pit11, pit12, pit13, pit14;

    public void displayBoard() {
        pit1.setText(String.valueOf(gameBoard.getPlayer1Side().getHole(0).getPitValue()));
        pit2.setText(String.valueOf(gameBoard.getPlayer1Side().getHole(1).getPitValue()));
        pit3.setText(String.valueOf(gameBoard.getPlayer1Side().getHole(2).getPitValue()));
        pit4.setText(String.valueOf(gameBoard.getPlayer1Side().getHole(3).getPitValue()));
        pit5.setText(String.valueOf(gameBoard.getPlayer1Side().getHole(4).getPitValue()));
        pit6.setText(String.valueOf(gameBoard.getPlayer1Side().getHole(5).getPitValue()));
        pit7.setText(String.valueOf(gameBoard.getPlayer1Store().getPitValue()));
        pit8.setText(String.valueOf(gameBoard.getPlayer2Side().getHole(0).getPitValue()));
        pit9.setText(String.valueOf(gameBoard.getPlayer2Side().getHole(1).getPitValue()));
        pit10.setText(String.valueOf(gameBoard.getPlayer2Side().getHole(2).getPitValue()));
        pit11.setText(String.valueOf(gameBoard.getPlayer2Side().getHole(3).getPitValue()));
        pit12.setText(String.valueOf(gameBoard.getPlayer2Side().getHole(4).getPitValue()));
        pit13.setText(String.valueOf(gameBoard.getPlayer2Side().getHole(5).getPitValue()));
        pit14.setText(String.valueOf(gameBoard.getPlayer2Store().getPitValue()));
        System.out.println("You have displayed a new Board");
    }

    public boolean validMove(int playerNumber, int buttonPressed) {

        if (playerNumber == 1) {
            if (buttonPressed <= 6) {
                System.out.println("You chose pit number " + buttonPressed);
                return true;
            } else {
                System.out.println("Pit Number " + buttonPressed + " is invalid. Please choose a pit on your side.");
                return false;
            }

        } else if (playerNumber == 2) {
            if (buttonPressed <= 13 && buttonPressed > 6) {
                System.out.println("You chose pit number " + buttonPressed);
                return true;
            } else {
                System.out.println("Pit Number " + buttonPressed + " is invalid. Please choose a pit on your side.");
                return false;
            }

        }
        return false;
    }


    public int[] getplayerBoard(){

        int[] playerBoard = new int[14];
        playerBoard[6] = gameBoard.getPlayer1Store().getPitValue();
        playerBoard[13] = gameBoard.getPlayer1Store().getPitValue();
        for (int i = 0; i <= 5; i++) {
            playerBoard[i] = gameBoard.getPlayer1Side().getHole(i).getPitValue();
        }

        for (int i = 7; i <= 12; i++) {
            playerBoard[i] = gameBoard.getPlayer2Side().getHole(i - 7).getPitValue();
        }

        return playerBoard;
    }

    public void printBoard(int[] playerBoard) {
        System.out.println("Array 1:  ");
        for (int i = 0; i <= 13; i++) {
            System.out.print((i + 1) + ":   ");
        }
        System.out.println();
        for (int i = 0; i <= 9; i++) {
            System.out.print(playerBoard[i] + "    ");
        }
        for (int i =10; i <= 13; i++) {
            System.out.print(playerBoard[i] + "      ");
        }
    }

    public void updateBoard(int[] playerBoard, Board gameBoard) {

        gameBoard.getPlayer1Store().setPitValue(playerBoard[6]);
        gameBoard.getPlayer2Store().setPitValue(playerBoard[13]);

        for (int i = 0; i <= 5; i++) {
            gameBoard.getPlayer1Side().getHole(i).setPitValue(playerBoard[i]);
        }

        for (int i = 7; i <= 12; i++) {
            gameBoard.getPlayer2Side().getHole(i - 7).setPitValue(playerBoard[i]);
        }
    }

    public void playerMove(ActionEvent event) {

        String button = ((Button) event.getSource()).getText();

        int buttonPressed = Integer.parseInt(button);
        System.out.println("You pressed button " + buttonPressed);

        int currentPlayer = playerNumber1;  //player1 goes first

        if (currentPlayer == 1) {
            if (validMove(currentPlayer, buttonPressed)) {
                int[] playerBoard = getplayerBoard();
                makeMove(buttonPressed, playerBoard);
                updateBoard(playerBoard, gameBoard);
                printBoard(playerBoard);
                displayBoard();
                return;
            }
        }
        currentPlayer = 2;
        if (currentPlayer == 2) {
            if (validMove(currentPlayer, buttonPressed)) {
                int[] playerBoard = getplayerBoard();
                makeMove(buttonPressed, playerBoard);
                updateBoard(playerBoard, gameBoard);
                printBoard(playerBoard);
                displayBoard();
                currentPlayer = 1;
                return;
            }
        }
    }

    public void makeMove(int buttonPressed, int[] playerBoard) {
        {
            int currentPit = buttonPressed - 1;
            int stones = playerBoard[currentPit];
            playerBoard[currentPit] = 0;



            for (int i = stones; i > 0; i--) {
                if ((currentPit+i) < 14){
                    playerBoard[currentPit + (i)] = (playerBoard[currentPit + (i)] + 1);
                }
                if ((currentPit+i) > 14){
                    playerBoard[currentPit + (i-14)] = (playerBoard[currentPit + (i-14)] + 1);
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ActionEvent event = new ActionEvent();
        resetBoard(event);
        displayBoard();
    }


    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(720);
        stage.setHeight(720);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
        System.out.println("You are now viewing the Menu");
    }
}

