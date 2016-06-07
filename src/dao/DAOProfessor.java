package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Professor;

public class DAOProfessor extends DAOGenerico<Professor> implements IDAOProfessor {

	public Professor buscaProfessorNome(String nome) {
		try {
			Query query = em.createQuery("SELECT p FROM Professor p WHERE p.nome = :nome", Professor.class);
			query.setParameter("nome", nome);
			return (Professor) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Professor> listarProfessoresAtivos() {
		try {
			Query query = em.createQuery("SELECT p FROM Professor p WHERE t.professorAtivo = 'S'", Professor.class);
			return (List<Professor>) query.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
