package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Secretaria;

public class DAOSecretaria extends DAOGenerico<Secretaria> implements IDAOSecretaria {

	public Secretaria buscaSecretariaNome(String nome){
		try {
			Query query = em.createQuery("SELECT s FROM Secretaria s WHERE s.nome = :nome", Secretaria.class);
			query.setParameter("nome", nome);
			return (Secretaria) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}
}
