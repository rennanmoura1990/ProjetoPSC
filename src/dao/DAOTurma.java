package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Turma;

public class DAOTurma extends DAOGenerico<Turma> implements IDAOTurma {

	public Turma BuscaTurmaNome(String nome){
		try {
			Query query = em.createQuery("SELECT t FROM Turma t WHERE t.nomeTurma = :nome", Turma.class);
			query.setParameter("nome", nome);
			return (Turma) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}

	public int PegarAulasTotais(int id_turma) throws DAOException {
		int qtd = 0;
		try {
			Query query = em.createQuery("SELECT t.qtd_aulas FROM Turma t WHERE t.id = :id", Turma.class);
			query.setParameter("id", id_turma);
			qtd = (int) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao obter a quantidade total de aulas");
		} finally {
			em.clear();
		}
		return qtd;
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> listarTurmasAtivas(){
		try {
			Query query = em.createQuery("SELECT t FROM Turma t WHERE t.turmaAtiva = 'S'",Turma.class);
			return (List<Turma>)query.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
