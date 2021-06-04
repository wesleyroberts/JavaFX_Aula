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
	// tela Login
	private static Scene loginScene;
	// tela Cadastro funcionario
	private static Scene cadastroFuncionarioScene;
	//tela Cadastro Prodtuos
	private static Scene cadastroProdutoScene;
	//tela de Menu Propdutos
	private static Scene produtosMenuScene;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			primaryStage.setTitle("Contas de Clientes");
			URL fxmlMainVIew = getClass().getResource("/view/loginView.fxml");
			Parent parentMaiParentView = FXMLLoader.load(fxmlMainVIew);
			Parent parentFuncionarioView = FXMLLoader.load(getClass().getResource("/view/cadastroFuncionarioView.fxml"));
			Parent parentProdutoView = FXMLLoader.load(getClass().getResource("/view/cadastrarProdutos.fxml"));
			Parent parentMenuProdutosView = FXMLLoader.load(getClass().getResource("/view/produtosMenu.fxml"));
			
			cadastroFuncionarioScene = new Scene(parentFuncionarioView);
			cadastroProdutoScene = new Scene(parentProdutoView);
			produtosMenuScene = new Scene(parentMenuProdutosView);
			
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
		case "cadastroFuncionario":
			stage.setScene(cadastroFuncionarioScene);
			break;
		case "cadastroProduto":
			stage.setScene(cadastroProdutoScene);
			break;
		case "menuProdutos":
			stage.setScene(produtosMenuScene);
			break;

		}
	}

	public static void main(String[] args) {
		
		launch(args);

	}
}
