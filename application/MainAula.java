package application;

import java.net.URL;
import java.util.List;

import com.mysql.jdbc.Connection;

import DataBase.Conection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Funcionario;
import model.Produtos;
import model.dao.FuncionarioDaoJdbc;
import model.dao.ProdutosDAO;
import model.dao.ProdutosDaoJdbc;

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
			Parent parentContaView = FXMLLoader.load(getClass().getResource("/view/cadastroView.fxml"));
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

		Connection conn = Conection.getConnection();
//		Conection.closeConnection();
//		System.out.println("Tudo Ok!");
//		System.exit(0);

	//	Connection conn = Conection.getConnection();
//		Funcionario f = new Funcionario();
//		f.setNome("Wesley Roberts");
//		f.setCpf("1234567");
//		f.setId(1);
//		
		FuncionarioDaoJdbc funcionarioDao = new FuncionarioDaoJdbc(conn);
//		int id = funcionarioDao.insert(f);
//		System.out.println("Divida Id:" + id);
//		f.setId(id);
//		
//		Produtos p = new Produtos();
//		p.setDescription("GTX1060 placa de video com 4GB ");
//		p.setNome("GTX1060");
//		p.setPreco(1500.5);
//		p.setId(2);
//		
	ProdutosDaoJdbc produtosDao = new ProdutosDaoJdbc(conn);
//		produtosDao.insert(p);
//		System.out.println("Tudo ok");
//		System.exit(0);
//		Produtos p2 = (Produtos) produtosDao.findById(2);
//	System.out.println("o produto encontrado " + p2.getNome());
//	Conection.closeConnection();
		
		Funcionario obj =  (Funcionario) funcionarioDao.findById(1);
		obj.setNome("Luiz antonio");
		funcionarioDao.update(obj);
		Funcionario p2 = (Funcionario)funcionarioDao.findById(1);
		System.out.println("o produto encontrado " + p2.getNome());
		
	
		
//		List<Funcionario> func = funcionarioDao.findAll();
//		for(Funcionario f:func) {
//			System.out.println(f.getNome());
//		}
		List<Produtos> pro = produtosDao.findAll();
		pro.forEach(p ->{
			System.out.println(p.getNome());
		});
		Conection.closeConnection();
		
//		launch(args);
	}
}
