package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Coordenador;

public class DAOCoordenador extends DAOGenerico<Coordenador> implements IDAOCoordenador {

	public Coordenador buscaCoordenadorNome(String nome){
		try {
			Query query = em.createQuery("SELECT c FROM Coordenador c WHERE c.nome = :nome", Coordenador.class);
			query.setParameter("nome", nome);
			return (Coordenador) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}
}
