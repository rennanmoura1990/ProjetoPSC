package dao;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Coordenador;

public class DAOCoordenador extends DAOGenerico<Coordenador> implements IDAOCoordenador {

	public Coordenador buscaCoordenadorNome(String nome) throws DAOException {
		try {
			Query query = em.createQuery("SELECT c FROM Coordenador c WHERE c.nome = :nome", Coordenador.class);
			query.setParameter("nome", nome);
			return (Coordenador) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao Buscar Coordenador por Nome!");
		} finally {
			em.clear();
		}
	}
}
