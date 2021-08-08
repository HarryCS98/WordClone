package controllers;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
	TextField imgURL_TB = new TextField();
	

	public void open() {

		content.setHtmlText(filemodel.loadFile());
		setTitle();

	}

	public void saveAs() {

		filemodel.saveAs(content.getHtmlText());

	}

	public void save() {

		filemodel.save(content.getHtmlText());

	}

	public void insert_Image_Local() {
			
		
		content.setHtmlText( content.getHtmlText() +  "<img src=' " + filemodel.loadLocalIMG().toURI() +
		 "'/>");
		  
	}
	

//	Need to add validation to check URL is correct so we dont try and load a image that doesnt exist
	public void insert_Image_URL() {

		
		content.setHtmlText( content.getHtmlText() +  "<img src=' " + imgURL_TB.getText() +
				 "'/>");
		
		
	}
	
	
	

	private void setTitle() {

		Stage primStage = (Stage) content.getScene().getWindow();
		primStage.setTitle("WordClone" + " - " + filemodel.getfileName());

	}

}
