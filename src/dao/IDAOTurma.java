package dao;

import exception.DAOException;
import model.Turma;

public interface IDAOTurma extends IDAOGenerico<Turma>{
	public int PegarAulasTotais(int id_turma) throws DAOException;
}
