package controller;


import java.net.URL;
import java.util.ResourceBundle;
import application.MainAula;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Funcionario;
import model.dao.DAOFactory;
import model.dao.FuncionarioDaoJdbc;

public class CadastroFuncionarioViewController implements Initializable {

	FuncionarioDaoJdbc funcionarioDao = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		funcionarioDao = (FuncionarioDaoJdbc) DAOFactory.createFuncionarioDAO();
	}

	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtCpf;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField txtNome;
	@FXML
	private Button btnPronto;
	@FXML
	private Button btnVoltar;
	@FXML
	void onBtnPronto() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Cadastro de CLietne");
		alert.setHeaderText("Informações sobre cadastro");
		alert.setContentText("O Funcionaro " + txtNome.getText()+ " foi adicionado com Sucesso");
		alert.show();
		registroFuncionario();
		
	}

	@FXML
	void onBtnVoltar(ActionEvent event) {
		MainAula.mudarTela("login");
	}

	private void registroFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(txtNome.getText());
		funcionario.setEmail(txtEmail.getText());
		funcionario.setCpf(txtCpf.getText());
		funcionario.setPassword(txtPassword.getText());
		funcionarioDao.insert(funcionario);
		
	}

}
