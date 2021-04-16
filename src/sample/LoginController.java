package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class LoginController {
	public String inputPassword;
	public String inputId;

	public static HashMap<String, String> userLoginInfo = new HashMap<String, String>();
	
	@FXML 
	PasswordField pwField = new PasswordField();
	@FXML 
	TextField idField = new TextField();
	@FXML
	Label passwordLabel = new Label();
	@FXML
	Label subtitle = new Label();
	

	public void loadLoginInfo (ActionEvent e) {
		userLoginInfo.put("id1", "p1");
		System.out.println("loaded LoginInfo");
		
		BufferedReader reader = null;
		String file = "src\\loginInfo.csv";
		String line = "";
		String[] idPw = new String[2];
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line=reader.readLine())!=null) {
				String[] row = line.split(",");
				int i = 0;
				for (String index : row) {
					//System.out.printf("%-10s",index);
					idPw[i]=index;
					i++;
				}
				userLoginInfo.put(idPw[0], idPw[1]);
			}
		}catch(Exception error) {
			System.out.println(error);
		}
	}
	
	public void guestLogin (ActionEvent e) {
		subtitle.setText("meow~~you login as Guest");
	}
	
	public void readIdPassWord (ActionEvent e) {
		String pw = String.valueOf(pwField.getText());
		String id = String.valueOf(idField.getText());
		
		loadLoginInfo(e);
		
		if(idField.getText().isBlank()) {
			System.out.println("please enter userId");
			subtitle.setText("please enter userId");
		}
		else if (userLoginInfo.containsKey(id)) {
			System.out.println("yeaaaaa ID correct");
			if(pwField.getText().isBlank()) {
				System.out.println("please enter password");
				subtitle.setText("please enter password");
			}
			else if (userLoginInfo.get(id).equals(pw)) {
				System.out.println("yeaaaaa boi login success");
				subtitle.setText("yeaaaaa boi login success");
			}
			else if (userLoginInfo.get(id).equals(pw)==false){
				System.out.println("please enter correct password");
				subtitle.setText("please enter correct password");
			}
		}
		else if (idField.getText().equals(id)==false){
			System.out.println("please enter correct userId");
			subtitle.setText("");
		}
		else {
			System.out.println("you are shitty code mockey");
		}
		
	}
	
}
	
