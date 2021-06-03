package controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.MainAula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Funcionario;
import model.dao.DAOFactory;
import model.dao.FuncionarioLoginDaoJdbc;

public class LoginViewController implements Initializable {
	FuncionarioLoginDaoJdbc funcionarioDao = null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		funcionarioDao = (FuncionarioLoginDaoJdbc) DAOFactory.LoginFuncionarioDAO();
	}

	// TODO Auto-generated method stub
	
	@FXML
	private TextField txtEmail;	
	@FXML 
	private TextField txtPassword;	

	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnLogin;
	
	public void login() {
		Boolean result = false;
		Funcionario funcionario = new Funcionario();
		funcionario.setEmail(txtEmail.getText());
		funcionario.setPassword(txtPassword.getText());
		result = funcionarioDao.login(funcionario);
		
		if(result==true) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Login");
			alert.setHeaderText("Resultado do login");
			alert.setContentText("Login efetuado com Sucesso ");
			alert.show();
		}else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Login");
			alert.setHeaderText("Resultado do login");
			alert.setContentText("Erro de login");
			alert.show();
		
		}
	}
	
	// @FXML
		public void onBtnLogin() {
			login();
		}	

	// @FXML
	public void onBtnCadastrar() {
		System.out.println("Cadastrar");
		MainAula.mudarTela("cadastro");
	}
}
