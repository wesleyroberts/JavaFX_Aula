package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainAula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Produtos;
import model.dao.DAOFactory;
import model.dao.ProdutosDaoJdbc;

public class ControllerProdutosView  implements Initializable{
	ProdutosDaoJdbc produtoDao = null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		produtoDao = (ProdutosDaoJdbc) DAOFactory.createUsuarioDAO();
	}

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnDeletar;

    @FXML
    void onBtnApagar() {
    	
    }

    @FXML
    void onBtnEditar() {
    	
    }

    @FXML
    void onBtnAdicionar() { 
    	MainAula.mudarTela("cadastroProduto"); 	
    	
    }
    public void cadastrarProduto(Produtos obj) {
    	produtoDao.insert(obj);    
    	
    }
    
}
