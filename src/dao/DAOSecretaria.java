package dao;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Secretaria;

public class DAOSecretaria extends DAOGenerico<Secretaria> implements IDAOSecretaria {

	public Secretaria buscaSecretariaNome(String nome) throws DAOException {
		try {
			Query query = em.createQuery("SELECT s FROM Secretaria s WHERE s.nome = :nome", Secretaria.class);
			query.setParameter("nome", nome);
			return (Secretaria) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao Buscar Secretaria por Nome!");
		} finally {
			em.clear();
		}
	}
}
