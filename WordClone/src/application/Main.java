package application;
	
import controllers.MainWindowController;
import javafx.application.Application;
import javafx.stage.Stage;
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
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/views/MainWindowView.fxml"));
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("WordClone");
			primaryStage.show();
			
//			Create object of the controller
			MainWindowController mainwindowcontroller = new MainWindowController();
//			Then pass in the primary stage so we can then pass that to the file chooser javafx element
//			Can't be in a constructor as the then the FXML view will not be able to load the MainWIndowController 
			mainwindowcontroller.load(primaryStage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
