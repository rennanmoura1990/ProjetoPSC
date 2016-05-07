package dao;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Disciplina;

public class DAODisciplina extends DAOGenerico<Disciplina> implements IDAODisciplina {
	
	public Disciplina buscaDisciplinanome(String nome) throws DAOException {
		try {
			Query query = em.createQuery("SELECT d FROM Disciplina d WHERE d.nomeDisciplina = :nome",Disciplina.class);
			query.setParameter("nome", nome);
			return (Disciplina) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao Buscar Disciplina por Nome!");
		}
	}
}
