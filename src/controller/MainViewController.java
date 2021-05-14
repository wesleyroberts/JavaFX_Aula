package controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Cliente;

public class MainViewController implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	// TODO Auto-generated method stub
	@FXML
	private TableView tblClientes;
	@FXML
	private TableColumn<Cliente, String> clNome;
	@FXML
	private TableColumn<Cliente, Double> clValor;
	@FXML
	private TableColumn<Cliente, Date> clData;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnApagar;

	// @FXML
	public void onBtnNovo() {
		System.out.println("onBtNovo");
	}

	// @FXML
	public void onBtnEditar() {
		System.out.println("onBtEditar");
	}

	// @FXML
	public void onBtnApagar() {
		System.out.println("onBtApagar");
	}
}
