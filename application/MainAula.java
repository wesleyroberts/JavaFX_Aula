package application;

import java.net.URL;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//tella inicial

public class MainAula extends Application {
	// palco
	private static Stage stage;
	// tela inicial
	private static Scene loginScene;
	// tela cliente
	private static Scene cadastroScene;

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			primaryStage.setTitle("Contas de Clientes");
			URL fxmlMainVIew = getClass().getResource("/view/loginView.fxml");
			Parent parentMaiParentView = FXMLLoader.load(fxmlMainVIew);
			Parent parentContaView = FXMLLoader.load(getClass().getResource("/view/cadastroFuncionarioView.fxml"));
			cadastroScene = new Scene(parentContaView);

			loginScene = new Scene(parentMaiParentView);
			primaryStage.setScene(loginScene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mudarTela(String tela) {
		switch (tela) {
		case "login":
			stage.setScene(loginScene);
			break;
		case "cadastro":
			stage.setScene(cadastroScene);
			break;

		}
	}

	public static void main(String[] args) {
		
		launch(args);

	}
}
