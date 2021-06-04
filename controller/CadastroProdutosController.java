package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainAula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Produtos;
import model.dao.DAOFactory;
import model.dao.ProdutosDaoJdbc;

public class CadastroProdutosController implements Initializable {
	ProdutosDaoJdbc produtoDao = null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		produtoDao = (ProdutosDaoJdbc) DAOFactory.createUsuarioDAO();
	}
	
	
		@FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtDescricao;

	    @FXML
	    private TextField txtPreco;

	    @FXML
	    private Button btnOk;
	    
	    @FXML
	    private Button btnVoltar;
	    
	    public void CadastrarProduto() {
	    	Produtos produto = new Produtos();
	    	produto.setNome(txtNome.getText());
	    	produto.setPreco( Double.valueOf(txtPreco.getText()).doubleValue());
	    	produto.setDescription(txtDescricao.getText());
	    	produtoDao.insert(produto);
	    	
	    	MainAula.mudarTela("menuProdutos");	    	
	    }
	    
	    public void Voltar() {
	    	MainAula.mudarTela("menuProdutos");
	    }
	    
}
