package application;
	


import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//tella inicial


public class MainAula extends Application {

	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			URL fxmlMainVIew = getClass().getResource("/view/mainView.fxml");
			Parent parentMaiParentView = FXMLLoader.load(fxmlMainVIew);
			mainScene = new Scene(parentMaiParentView);
			primaryStage.setScene(mainScene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
