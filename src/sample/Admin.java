package sample;

import java.util.ArrayList;

public class Admin extends User {
	
	private ArrayList<User> userList;
	
	public Admin(String userName, String first, String last) {
		super(userName, first, last);
	}
	
	//method to add user to an ArrayList
	public void addUser(User user) {
    	userList.add(user);
    }
	
	//method to remove user from ArrayList
	public void removeUser(User user) {
		userList.remove(user);
	}	
	
	//method to check if the username is valid
	public Boolean CheckUsername(String UserName) {  
		boolean check = false;
	    if(UserName == getUserName()) {
	    	check = true;
	    }
	    return check;
	}
	
	public String toString() {
		return ("Number of current users :" + getuserCount());
	}
    	
}

//TEST