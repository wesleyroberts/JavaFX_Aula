package model.dao;

import java.util.List;

import model.Funcionario;

public interface FuncionarioDAO {
	//create
	Integer insert(Funcionario obj);
	//recover
	Object findById(Integer id);
	//recover all
	List<Funcionario> findAll();
	//update
	void update(Funcionario obj);
	//delete
	void deleteById(Integer id);
}
