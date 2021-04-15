package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class User {

    private final UUID PlayerID;
    private Date firstDate;
    
    private String UserName;
    private String firstName;
    private String lastName;
    private Image profilePicture;
    private String password;
    private int[] winLossDraw;
    private static int userCount = 0; //counter to track the number of users
    private ArrayList<Player> favPlayers;
    

    public User (String userName, String first, String last){
    	UserName = userName;
    	firstName = first;
    	lastName = last;
    	PlayerID = UUID.randomUUID(); //generates a random unique identifier
    	//password = pass;
       	
    	userCount++; //adds one to the user count each time the constructor is called
    }
    
    //Setters
    public void setUserName(String UserName) {
    	this.UserName = UserName;
    } 
    
    public void setfirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setlastName(String lastName) {
    	this.lastName = lastName;
    	
    }
    
    //sets the password
    public void setPassword(String password) {
    	
    	this.password = password;
    	
    }
       
    public void setprofilePicture() {
    	FileOpener fileOpener = new FileOpener();
    	FileOpener.main(null);
    	this.profilePicture = fileOpener.getprofilePic();
    }
    
    public void setwinLossDraw(int[] winLossDraw) {
    	this.winLossDraw = winLossDraw;
    }
    
    //getters
    //get user name
    public String getUserName() {
    	return UserName;
    } 
    
    //get first name
    public String getfirstName() {
    	return firstName;
    } 
    
    //get last name
    public String getlastName() {
    	return lastName;
    } 
    
    //get password
    public String getPassword() {
    	return password;
    } 
    
    //needs to retrieve this info from login system
    public Date getfirstDate() {
    	return firstDate;
    }
    
    //Gets the generated unique ID 
    public UUID getPlayerID() {
    	return PlayerID;
    }
    
    //gets the number of current users
    public static int getuserCount() {
    	return userCount;
    	
    }
    
    public String toString() {
		return ("Username :" + UserName + "\nFirst name :" + firstName + "\nLast name :" + lastName + "\nWins/Losses/Draws :" 
				+ winLossDraw);
	}
    
//    public double winPercentage() {
//    	double winPercent = 0;
//    	return winPercent;
//    }
    
}