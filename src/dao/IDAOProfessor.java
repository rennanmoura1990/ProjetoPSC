package dao;

import java.util.List;

import model.Professor;

public interface IDAOProfessor extends IDAOGenerico<Professor>{

	public Professor buscaProfessorNome(String nome);
	public List<Professor> listarProfessoresAtivos();

}
