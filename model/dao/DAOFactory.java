package model.dao;

import DataBase.Conection;

public class DAOFactory {
		
	public static ProdutosDAO createUsuarioDAO() {

		return new ProdutosDaoJdbc(Conection.getConnection());

		}
		public static FuncionarioDAO createFuncionarioDAO() {

		return new FuncionarioDaoJdbc(Conection.getConnection());

		}
		
		public static FuncionarioLoginDaoJdbc LoginFuncionarioDAO() {

			return new FuncionarioLoginDaoJdbc(Conection.getConnection());

			}
}
