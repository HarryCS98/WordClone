package controllers;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.FileModel;

public class MainWindowController {

	FileModel filemodel = new FileModel();
	
	//Make reference to the TextArea in MainWindowView.FXML so we can access the text in the application
	
	@FXML
	TextArea content = new TextArea();
	
	
	@FXML
	Button testButton = new Button();
	
	FileChooser fileChooser = new FileChooser();
	
	
	Stage stage = new Stage();
	
	
	public void load(Stage primaryStage) {
		
		stage = primaryStage;
		
	}
	
	
	
	
	
	public void saveFile() throws IOException {
		
		
		String fileName = "test.txt";
		
		 filemodel.saveFile(fileName, content.getText());
		
	}
	

	
	public void test_openFileLocation() throws IOException {
		
		/*
		 * String userHomePath = System.getProperty("user.home"); File userHome = new
		 * File(userHomePath); // uses the corect path separator for the OS File videos
		 * = new File(userHome, "Documents"); Desktop.getDesktop().open(videos);
		 */
        
		
		File selectedFile = fileChooser.showOpenDialog(stage);
		
      
		
	}

	
}
