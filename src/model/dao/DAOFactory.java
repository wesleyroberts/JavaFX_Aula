package model.dao;

import DataBase.Conection;

public class DAOFactory {
		
	public static ProdutosDAO createUsuarioDAO() {

		return new ProdutosDaoJdbc(Conection.getConnection());

		}
		public static FuncionarioDAO createFuncuionarioDAO() {

		return new FuncionarioDaoJdbc(Conection.getConnection());

		}
	
}
