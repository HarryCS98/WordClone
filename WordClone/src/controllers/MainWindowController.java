package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import models.FileModel;

public class MainWindowController {

	FileModel filemodel = new FileModel();
	// Make reference to the TextArea in MainWindowView.FXML so we can access the
	// text in the application

	@FXML
	HTMLEditor content = new HTMLEditor();

	@FXML
	Button testButton = new Button();


	public void open(){
		  
		 content.setHtmlText(filemodel.loadFile());
		 setTitle();
		  
	}
	

	public void saveAs(){
		
		
		filemodel.saveAs(content.getHtmlText());
		 

	}
	
	
	
	
	public void save(){
		
		
		filemodel.save(content.getHtmlText());
		
		
	}
	
	
	 private void setTitle() {
			
			Stage primStage = (Stage) content.getScene().getWindow();
			primStage.setTitle("WordClone" + " - " + filemodel.getfileName());

			
		}
	
	
}
