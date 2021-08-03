package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileModel {

	Stage stage = new Stage();
	FileChooser fileChooser = new FileChooser();
	String docPath;
	String fileName;
	boolean exists;
	

	

	public void load(Stage primaryStage) {

		stage = primaryStage;

	}

	public void saveFile(String fileName, String content) throws IOException {

		// Create an object of File and pass to it the name of the file
		File file = new File(fileName);

		// Create a bufferedWriter object and pass to it our file object
		BufferedWriter out = new BufferedWriter(new FileWriter(file));

		// Write the content "text" to our file
		out.write(content);

		// Then close the file
		out.close();
	}

	public String loadFile() {

		String fileText = "";

//		  Set to to the users home so user there name
		String userHomePath = System.getProperty("user.home");
		File userHome = new File(userHomePath); // uses the corect path separator for the OS File videos
//		  Create new file object that is user home then Documents
		File mydocuments = new File(userHome, "Documents");
//		  Open the file chooser in the my Documents directory
		fileChooser.setInitialDirectory(mydocuments);

		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));

//		  Open then save verion of the file Chooser
		File selectedFile = fileChooser.showOpenDialog(stage);
		
		fileName =  selectedFile.getName();

//		  Stop a null point exception error that occures if the user presses the cancel button in the Save Dialog box
		if (selectedFile != null) {
			try {
				fileText = Files.readString(Path.of(selectedFile.getAbsolutePath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileText;

	}

	public void saveAs(String text) {

//		  Set to to the users home so user there name
		String userHomePath = System.getProperty("user.home");
		File userHome = new File(userHomePath); // uses the corect path separator for the OS File videos
//		  Create new file object that is user home then Documents
		File mydocuments = new File(userHome, "Documents");
//		  Open the file chooser in the my Documents directory
		fileChooser.setInitialDirectory(mydocuments);
//		  Set the default name of the file that is going to be saved to Document.txt
		fileChooser.setInitialFileName("Document.txt");

		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));

//		  Open then save verion of the file Chooser
		File selectedFile = fileChooser.showSaveDialog(stage);

		docPath = selectedFile.getAbsolutePath();

//		  Stop a null point exception error that occures if the user presses the cancel button in the Save Dialog box
		if (selectedFile != null) {
			try {
				saveFile(selectedFile.getAbsolutePath(), text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void save(String text) {

		if (docPath != null) {
			File tempFile = new File(docPath);
			exists = tempFile.exists();
		}

		if (exists == true) {
			try {
				saveFile(docPath, text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			saveAs(text);

		}

	}
	
	
	public String getfileName() {
		return fileName;
	}
	
	
}
