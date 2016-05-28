package dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import exception.GeralException;
import model.Nota;
import model.enums.Unidades;

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
					"SELECT AVG(n.media) from Nota n WHERE n.id_aluno = :aluno AND n.id_disciplina = :disciplina AND n.unidade IN ('PRIMEIRA','SEGUNDA','TERCEIRA','QUARTA')",
					Nota.class);
			query.setParameter("aluno", id_aluno);
			query.setParameter("disciplina", id_disciplina);
			return (double) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao emitir nota final!");
		} finally {
			em.clear();
		}
	}

	public double NotaRecuperacao(int id_aluno, int id_disciplina) throws DAOException {
		try {
			Query query = em.createQuery(
					"SELECT n.nota_recupecao FROM Nota n WHERE n.id_aluno = :aluno AND n.id_disciplina = :disciplina",
					Nota.class);
			query.setParameter("aluno", id_aluno);
			query.setParameter("disciplina", id_disciplina);
			return (double) query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao emitir nota da recuperação!");
		} finally {
			em.clear();
		}
	}

	public List<Unidades> unidades() throws GeralException {
		try {
			List<Unidades> unidades = Arrays.asList(Unidades.values());
			return unidades;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException("Erro ao listar Unidades!");
		}
	}
}
