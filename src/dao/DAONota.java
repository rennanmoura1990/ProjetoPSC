package dao;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Nota;

public class DAONota extends DAOGenerico<Nota> implements IDAONota {
	/**
	 * Emite a média final de um aluno de uma determinada disciplina
	 * 
	 * @param id_aluno
	 * @param id_disciplina
	 * @return
	 */
	public double NotaFinal(int id_aluno, int id_disciplina) throws DAOException {
		try {
			Query query = em.createQuery(
					"SELECT AVG(n.media) from Nota n WHERE id_aluno = :aluno AND id_disciplina = :disciplina",
					Nota.class);
			query.setParameter("aluno", id_aluno);
			query.setParameter("disciplina", id_disciplina);
			return (double) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
	}
}
