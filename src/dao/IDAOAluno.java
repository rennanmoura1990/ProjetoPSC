package dao;

import java.util.List;

import exception.DAOException;
import exception.GeralException;
import model.Aluno;
import model.enums.Status;

public interface IDAOAluno extends IDAOGenerico<Aluno>{

	public Aluno buscaAlunoNome(String nome);
	public int QtdAlunoTurma(int turma_id) throws DAOException;
	public int NumeroFaltas(int id_aluno) throws DAOException;
	public void LancaFalta(Aluno a) throws DAOException;
	public List<Status> status() throws GeralException;
	public List<Aluno> alunoPorTurma(int id_turma) throws GeralException;
}
