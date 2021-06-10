package controllers;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.FileModel;

public class MainWindowController {

	FileModel filemodel = new FileModel();

	// Make reference to the TextArea in MainWindowView.FXML so we can access the
	// text in the application

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
		
		
//		  Set to to the users home so user there name
		  String userHomePath = System.getProperty("user.home"); 
		  File userHome = new File(userHomePath); // uses the corect path separator for the OS File videos
//		  Create new file object that is user home then Documents
		  File mydocuments = new File (userHome,"Documents");
//		  Open the file chooser in the my Documents directory
		  fileChooser.setInitialDirectory(mydocuments);
//		  Set the default name of the file that is going to be saved to Document.txt
		  fileChooser.setInitialFileName("Document.txt");

		  fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
		  
 //		  Open then save verion of the file Chooser
		  File selectedFile = fileChooser.showSaveDialog(stage);
		  
//		  Stop a null point exception error that accures if the user presses the cancel button in the Save Dialog box
		  if(selectedFile != null) {
			  filemodel.saveFile(selectedFile.getAbsolutePath(), content.getText());
		  }
		 

	}

}
