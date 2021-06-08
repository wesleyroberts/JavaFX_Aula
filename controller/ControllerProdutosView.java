package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.MainAula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Produtos;
import model.dao.DAOFactory;
import model.dao.ProdutosDaoJdbc;

public class ControllerProdutosView implements Initializable {
	ProdutosDaoJdbc produtoDao = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		produtoDao = (ProdutosDaoJdbc) DAOFactory.createUsuarioDAO();
//		associarColunas();
//		UpdateTable();
	}

//	@FXML
//	private TableView<TableObject> tableProdutos;
//	@FXML
//	private TableColumn<TableObject, String> tableColumnProduto;
//
//	@FXML
//	private TableColumn<TableObject, Double> tableColumnPreco;
//
//	@FXML
//	private TableColumn<TableObject,String> tableColumDescricao;
	@FXML
	private Button btnAdicionar;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnDeletar;

	@FXML
	void onBtnApagar() {
		System.out.println("");
	}

	@FXML
	void onBtnEditar() {

	}

	@FXML
	void onBtnAdicionar() {
		MainAula.mudarTela("cadastroProduto");

	}

//	private void associarColunas() {

//		PropertyValueFactory clNomeProperty = new PropertyValueFactory<>("nome");
//		PropertyValueFactory clValorProperty = new PropertyValueFactory<>("preco");
//		PropertyValueFactory clDescricaoProperty = new PropertyValueFactory<>("descricao");
//
//		tableColumnProduto.setCellValueFactory(clNomeProperty);
//		tableColumnPreco.setCellValueFactory(clValorProperty);
//		tableColumDescricao.setCellValueFactory(clDescricaoProperty);

//	}
//	private void UpdateTable() {
//	tableProdutos.getItems().clear();//limpa antes de adicionar
//	
//		//lista para obter os clientes
//		List<Produtos> produto= produtoDao.findAll();
//		String nome =null;
//		Double preco = null;
//		String descricao = null;
//		Integer id_produto =null;
//		
//		for (Produtos p : produto) {
//
//			nome = p.getNome();
//			id_produto = p.getId();
//			descricao = p.getDescription();
//			preco= p.getPreco();
//			
//
//			TableObject table = new TableObject( nome, preco, descricao);
//
//			tableProdutos.getItems().add(table);
//
//			}
//	}
	

//	public void cadastrarProduto(Produtos obj) {
//		produtoDao.insert(obj);
//
//	}
//
//	public static  class  TableObject  {
//		private String nome;
//		private Double preco;
//		private String descricao;
//		private int id;
//	
//		
//		public TableObject(String nome2, Double preco2, String descricao2) {
//			this.nome=nome2;
//			this.preco=preco2;
//			this.descricao= descricao2;
//		}
//		public String getNome() {
//			return nome;
//		}
//		public int getId() {
//			return id;
//		}
//
//		public void setId(int id) {
//			this.id = id;
//		}
//
//		public void setNome(String nome) {
//			this.nome = nome;
//		}
//		public Double getPreco() {
//			return preco;
//		}
//		public void setPreco(Double preco) {
//			this.preco = preco;
//		}
//		public String getDescricao() {
//			return descricao;
//		}
//		public void setDescricao(String descricao) {
//			this.descricao = descricao;
//		}
//		
//		
//	}

}