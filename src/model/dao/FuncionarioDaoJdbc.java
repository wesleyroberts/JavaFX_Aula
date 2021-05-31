package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DataBase.Conection;
import DataBase.DbException;
import model.Funcionario;


public class FuncionarioDaoJdbc implements FuncionarioDAO {
	
	Connection conn = null;
	public FuncionarioDaoJdbc(Connection conn) {
	this.conn = conn;
	}
	@Override
	public Integer insert(Funcionario obj) {
		Integer id = null;

		PreparedStatement st = null;		
		try {
			String sql = "INSERT INTO funcionario (Id,nome, cpf) VALUES (?,?,?)";
			st =(PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getId());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getCpf());
			int linhas = st.executeUpdate();
			if(linhas>0) {
				ResultSet rs = st.getGeneratedKeys(); //retorna o id criado
				while(rs.next()) {
				id = rs.getInt(1); //1 é a 1ª e unica coluna
				}
				System.out.println("Adicionado com o id: "+ id);
				Conection.closeResultSet(rs); //finaliza o resultSet
				}
			} catch (Exception e) {
				throw new DbException(e.getMessage());//envia uma exceção
			}finally {
			Conection.closeStatement(st); //finaliza o Statement

		}
		return id;
	}
	@Override
	public Object findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Funcionario	funcionario = new Funcionario();
		try {
			String sql = "SELECT Id,nome,cpf FROM funcionario WHERE ID = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				int id_e = rs.getInt("Id");
				String nome = rs.getString("nome");
				String cpf= rs.getString("cpf");
				
				funcionario.setId(id_e);
				funcionario.setNome(nome); 
				funcionario.setCpf(cpf);
								
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			}finally {
				Conection.closeResultSet(rs);
				Conection.closeStatement(st);
			}

		return funcionario;
	}
	@Override
	public List<Funcionario> findAll() {
			
			PreparedStatement st = null;
			ResultSet rs = null;
			List<Funcionario> lista = new ArrayList<Funcionario>();
			try {
				String sql=" Select id,nome,cpf from funcionario";
				st = (PreparedStatement) conn.prepareStatement(sql);
				rs = st.executeQuery();
		
				while(rs.next()) {
					int id_f = rs.getInt("id");
					String nome =rs.getString("Nome");
					String cpf = rs.getString("cpf");
					
					Funcionario funcionario = new Funcionario();
					funcionario.setId(id_f);
					funcionario.setCpf(cpf);
					funcionario.setNome(nome);
					lista.set(id_f, funcionario);
					System.out.println(funcionario.getNome()+" "+funcionario.getNome());
					
				}
			} catch (Exception e) {
						
			}
		return lista ;
	}
	@Override
	public void update(Funcionario obj) {
		PreparedStatement st = null;
		try {
			String sql = "UPDATE funcionario SET Nome=?,cpf=? WHERE Id = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setInt(3, obj.getId());

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
			String sql = "DELETE FROM funcionario WHERE id = ?";
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
