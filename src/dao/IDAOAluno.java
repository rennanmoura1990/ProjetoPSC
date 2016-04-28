package dao;

import exception.DAOException;
import model.Aluno;

public interface IDAOAluno extends IDAOGenerico<Aluno>{

	public int QtdAlunoTurma(int turma_id) throws DAOException;
	public int NumeroFaltas(int id_aluno) throws DAOException;
	public void LancaFalta(Aluno a) throws DAOException;
	
}
