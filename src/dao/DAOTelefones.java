package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Telefones;

public class DAOTelefones extends DAOGenerico<Telefones> implements IDAOTelefones {
	/**
	 * Encontra um determinado telefone de uma determinada pessoa
	 */
	public Telefones buscaTelefonesUsuario(int pessoa_id, String telefone) throws DAOException {
		try {
			Query query = em.createQuery("SELECT t FROM Telefones t WHERE t.telefone = :telefone AND t.id_pessoa = :id",
					Telefones.class);
			query.setParameter("telefone", telefone);
			query.setParameter("id", pessoa_id);
			Telefones telefones = (Telefones) query.getSingleResult();
			return telefones;
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Telefone da Pessoa!");
		} finally {
			em.clear();
		}
	}

	public Telefones buscaTelefone(String telefone) throws DAOException{
		try {
			Query query = em.createQuery("SELECT t FROM Telefones t WHERE t.telefone = :telefone", Telefones.class);
			query.setParameter("telefone", telefone);
			Telefones telefones = (Telefones) query.getSingleResult();
			return telefones;
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Telefones> listaTelefonesPessoa(int pessoa_id)throws DAOException{
		try {
			Query query = em.createQuery("SELECT t FROM Telefones t LEFT JOIN t.pessoa p WHERE p.id = :id",
					Telefones.class);
			query.setParameter("id", pessoa_id);
			List<Telefones> telefones = (List<Telefones>) query.getResultList();
			return telefones;
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}
}
