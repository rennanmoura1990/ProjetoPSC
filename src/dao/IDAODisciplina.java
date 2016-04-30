package dao;

import exception.DAOException;
import model.Disciplina;

public interface IDAODisciplina extends IDAOGenerico<Disciplina>{
	public Disciplina buscaDisciplinanome(String nome) throws DAOException;
}
