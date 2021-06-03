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
	public String insert(Funcionario obj) {
		String cpf = null;

		PreparedStatement st = null;		
		try {
			String sql = "INSERT INTO funcionario (nome, cpf,password,email) VALUES (?,?,?,?)";
			st =(PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3,obj.getPassword());
			st.setString(4, obj.getEmail());
			int linhas = st.executeUpdate();
			if(linhas>0) {
				ResultSet rs = st.getGeneratedKeys(); //retorna o id criado
				while(rs.next()) {
				cpf = rs.getString("cpf"); //1 é a 1ª e unica coluna
				}
//				System.out.println("Adicionado com o id: "+ cpf);
				Conection.closeResultSet(rs); //finaliza o resultSet
				}
			} catch (Exception e) {
				throw new DbException(e.getMessage());//envia uma exceção
			}finally {
			Conection.closeStatement(st); //finaliza o Statement

		}
		return cpf;
	}
	@Override
	public Object findById(Integer cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Funcionario	funcionario = new Funcionario();
		try {
			String sql = "SELECT nome,cpf,email FROM funcionario WHERE cpf= ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, cpf);
			rs = st.executeQuery();
			
			if(rs.next()) {
				String cpf_e = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email= rs.getString("email");
				
				funcionario.setCpf(cpf_e);
				funcionario.setNome(nome); 
				funcionario.setEmail(email);
								
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
			List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
			try {
				String sql=" Select id,nome,cpf from funcionario";
				st = (PreparedStatement) conn.prepareStatement(sql);
				rs = st.executeQuery();
		
				while(rs.next()) {
					String cpf_f = rs.getString("cpf");
					String nome =rs.getString("nome");
					String email =rs.getString("email");
					
					Funcionario funcionario = new Funcionario();
					funcionario.setCpf(cpf_f);
					funcionario.setEmail(email);
					funcionario.setNome(nome);
					listaFuncionario.add(funcionario);
					
				}
			} catch (Exception e) {
						
			}
		return listaFuncionario ;
	}
	@Override
	public void update(Funcionario obj) {
		PreparedStatement st = null;
		try {
			String sql = "UPDATE funcionario SET Nome=?,email=?,password=? WHERE cpf = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEmail());
			st.setString(3, obj.getPassword());

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
	public void deleteById(Integer cpf) {
		PreparedStatement st = null;
		try {
			String sql = "DELETE FROM funcionario WHERE cpf = ?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, cpf);
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
