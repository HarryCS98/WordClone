package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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


	public void open(){
		  
		 content.setText(filemodel.loadFile());
		 setTitle();
		  
	}
	

	public void saveAs(){
		
		
		filemodel.saveAs(content.getText());
		 

	}
	
	
	
	
	public void save(){
		
		
		filemodel.save(content.getText());
		
		
	}
	
	
	 private void setTitle() {
			
			Stage primStage = (Stage) content.getScene().getWindow();
			primStage.setTitle(primStage.getTitle() + " - " + filemodel.getfileName());

			
		}
	
	
}
