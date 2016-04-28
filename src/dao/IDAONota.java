package dao;

import exception.DAOException;
import model.Nota;

public interface IDAONota extends IDAOGenerico<Nota>{
	public double NotaFinal(int id_aluno, int id_disciplina) throws DAOException;
	public double NotaRecuperacao(int id_aluno,int id_disciplina) throws DAOException;
}
