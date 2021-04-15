package sample;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileOpener extends Application{
	private Image profilePic;
	
	//empty constructor for non-static references
	public FileOpener(){}
	
	public void start(final Stage stage) {
		stage.setTitle("File Opener");
		
		//filter to select the type of files to be viewed
		FileChooser.ExtensionFilter imageFilter
        = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
		
		final FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(imageFilter);

		final Button openButton = new Button("Select Profile Picture");
		openButton.setOnAction((final ActionEvent e) -> {
			File file = fileChooser.showOpenDialog(stage);
			if (file != null) {

				Image profilePic = new Image(file.toURI().toString());
//	                ImageView ip = new ImageView(image1);
//	                BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
//	                BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
			}
		});
		final StackPane stac = new StackPane();
		stac.getChildren().add(openButton);
		stage.setScene(new Scene(stac, 250, 250));
		stage.show();
	}
	
	//getter method for public access
	public Image getprofilePic() {
	    return profilePic;
	} 

	public static void main(String[] args) {
		Application.launch(args);
	}
}
