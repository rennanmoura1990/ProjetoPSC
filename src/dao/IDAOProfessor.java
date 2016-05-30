package dao;

import exception.DAOException;
import model.Professor;

public interface IDAOProfessor extends IDAOGenerico<Professor>{

	public Professor buscaProfessorNome(String nome);

}
