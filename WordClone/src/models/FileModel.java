package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileModel {
	
	
	
	public void saveFile (String fileName, String content) throws IOException {
	
			//Create an object of File and pass to it the name of the file
			File file = new File (fileName);
			
			//Create a bufferedWriter object and pass to it our file object
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			
			//Write the content "text" to our file
			out.write(content);
			
			//Then close the file
			out.close();
	}	

	
	
	
	public void loadFile() {
		
		
	}
		

}
