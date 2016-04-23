package dao;

import exception.DAOException;
import model.Aluno;

public interface IDAOAluno extends IDAOGenerico<Aluno>{

	public long QtdAlunoTurma(int turma_id) throws DAOException;
	
}
