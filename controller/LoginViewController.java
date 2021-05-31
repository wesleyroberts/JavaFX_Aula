package controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import application.MainAula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Funcionario;

public class LoginViewController implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	// TODO Auto-generated method stub
	
	@FXML
	private TextField tfNome;	
	@FXML 
	private TextField tfPreco;	
	@FXML
	private TextField tfDescription;
	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnLogin;
	
	
	// @FXML
		public void onBtnLogin() {
			System.out.println("Login efetuado");
		}	

	// @FXML
	public void onBtnCadastrar() {
		System.out.println("Cadastrar");
		MainAula.mudarTela("cadastro");
	}
}
