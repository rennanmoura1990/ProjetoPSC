package dao;

import exception.DAOException;
import model.Aluno;

public interface IDAOAluno extends IDAOGenerico<Aluno>{

	public long QtdAlunoTurma(int turma_id) throws DAOException;
	public long NumeroFaltas(int id_aluno) throws DAOException;
	public void LancaFalta(int id_aluno) throws DAOException;
	
}
