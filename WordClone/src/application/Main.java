package application;

import javafx.application.Application;
import javafx.stage.Stage;
import models.FileModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/views/MainWindowView.fxml"));
			Scene scene = new Scene(root, 800, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("WordClone");
			primaryStage.show();

			/*
			 * MainWindowController mainwindowcontroller = new MainWindowController();
			 * 
			 * mainwindowcontroller.load(primaryStage);
			 */
			 

			FileModel filemodel = new FileModel();

			filemodel.load(primaryStage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
