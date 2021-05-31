package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainAula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroViewController implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	;
	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfCpf;	
	@FXML
	private Button btnPronto;
	@FXML
	private Button btnVoltar;
	
	
	// @FXML
		public void onBtnVoltar() {
			System.out.println("OK");
			MainAula.mudarTela("login");
		}
		
		@FXML
		private void onBtnPronto() {
		System.out.println("Cadastrado");
		MainAula.mudarTela("login");
		}

}
