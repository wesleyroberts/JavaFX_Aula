package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DataBase.Conection;
import DataBase.DbException;
import model.Produtos;

public class ProdutosDaoJdbc implements ProdutosDAO {

	Connection conn = null;

	public ProdutosDaoJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Integer insert(Produtos obj) {

		Integer id = null;

		PreparedStatement st = null;
		try {
			String sql = "INSERT INTO Produtos (Id,nome, descricao, preco) VALUES (?,?,?,?)";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, obj.getId());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getDescription());
			st.setDouble(4, obj.getPreco());
			int linhas = st.executeUpdate();
			if (linhas > 0) {
				System.out.println("Adicionado");

			}

		} catch (Exception e) {
			throw new DbException(e.getMessage());// envia uma exceção
		} finally {
			Conection.closeStatement(st); // finaliza o Statement

		}
		return id;
	}

	@Override
	public Object findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		Produtos produtos = new Produtos();
		try {
			String sql = "SELECT Id,nome,descricao,preco FROM Produtos WHERE ID = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				int id_e = rs.getInt("Id");
				String nome = rs.getString("nome");
				String description= rs.getString("descricao");
				double preco = rs.getDouble("preco");
				
				produtos.setId(id_e);
				produtos.setNome(nome); 
				produtos.setDescription(description);
				produtos.setPreco(preco);
				
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			}finally {
				Conection.closeResultSet(rs);
				Conection.closeStatement(st);
			}

		return produtos;
	}

	@Override
	public List<Produtos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Produtos obj) {
		PreparedStatement st = null;
		try {
			String sql = "UPDATE Produtos SET nome=?,descricao=?,preco=? WHERE Id = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getDescription());
			st.setDouble(3, obj.getPreco());
			st.setInt(4, obj.getId());

			int linhas = st.executeUpdate();
			if (linhas > 0) {
				System.out.println("Alterado");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Conection.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			String sql = "DELETE FROM Produtos WHERE id = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, id);
			int linhas = st.executeUpdate();
			if (linhas > 0) {
				System.out.println("Deletado");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Conection.closeStatement(st);
		}

	}

}
