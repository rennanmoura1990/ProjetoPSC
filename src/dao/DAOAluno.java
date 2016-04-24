package dao;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Aluno;

public class DAOAluno extends DAOGenerico<Aluno> implements IDAOAluno {

	/**
	 * Retorna a quantidade de alunos de uma determinada turma
	 * 
	 * @param turma_id
	 * @return
	 */
	public long QtdAlunoTurma(int turma_id) throws DAOException {
		try {
			Query query = em.createQuery("SELECT COUNT (*) from Aluno a WHERE id_turma = :id", Aluno.class);
			query.setParameter("id",turma_id);
			return (long) query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException(e);
		}
	}
}
