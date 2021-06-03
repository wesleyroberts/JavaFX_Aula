package model.dao;

import java.util.List;

import model.Produtos;

public interface ProdutosDAO {
	
		
		//create
		Integer insert(Produtos obj);
		//recover
		Object findById(Integer id);
		//recover all
		List<Produtos> findAll();
		//update
		void update(Produtos obj);
		//delete
		void deleteById(Integer id);

}
		
