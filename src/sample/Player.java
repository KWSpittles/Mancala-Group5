package sample;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Date;

public class Player extends User {

    private int PlayerID;
    private String Username;
    private String firstName;
    private String lastName;
    private Date firstDate;
    private Image profilePicture;
    private int[] winLossDraw;
    private ArrayList<User> favPlayers;


    public Player(String userName, String first, String last) {
        super(userName, first, last);
    }
}
