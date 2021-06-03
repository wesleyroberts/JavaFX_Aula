package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DataBase.Conection;
import DataBase.DbException;
import model.Funcionario;

public class FuncionarioLoginDaoJdbc {
	
	Connection conn = null;
	public FuncionarioLoginDaoJdbc(Connection conn) {
	this.conn = conn;
	}

	public Boolean login(Funcionario obj) {
		boolean result= false;
		String password = null,email = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {			
			String sql = "Select email,password FROM funcionario Where email=? and password=?";
			st = (PreparedStatement) conn.prepareStatement(sql);			
			st.setString(1, obj.getEmail());
			st.setString(2, obj.getPassword());
			rs = st.executeQuery();			
			if(rs.next()) {
				email = rs.getString("email");
				password = rs.getString("password");			
			}
						
			if (obj.getEmail().equals(email) && obj.getPassword().equals(password)) {				
				result =  true;
			} else {				
				result = false;
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			Conection.closeStatement(st);
		}
		return result;
	}
}
