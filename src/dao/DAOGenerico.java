package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import exception.DAOException;

public abstract class DAOGenerico<T> implements IDAOGenerico<T> {

	public static EntityManagerFactory instancia;

	public static EntityManagerFactory getInstancia() {
		if (instancia == null) {
			instancia = Persistence.createEntityManagerFactory("Colegio");
		}
		return instancia;
	}

	EntityManager em = getInstancia().createEntityManager();
	EntityTransaction et = em.getTransaction();
	T t; // objeto
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IDAOGenerico#inserir(T)
	 */

	public void inserir(T t) throws DAOException {
		try {
			et.begin();
			em.persist(t);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new DAOException("Erro ao cadastrar " + t.getClass().getSimpleName());
		} finally {
			em.clear();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IDAOGenerico#alterar(T)
	 */
	public void alterar(T t) throws DAOException {
		try {
			et.begin();
			em.merge(t);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new DAOException("Erro ao alterar " + t.getClass().getSimpleName());
		} finally {
			em.clear();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IDAOGenerico#excluir(java.lang.Class, int)
	 */
	public void excluir(Class<T> objeto, int id) throws DAOException {
		try {
			et.begin();
			t = (T) em.find((Class<T>) objeto, id);
			em.remove(t);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new DAOException("Erro ao Excluir " + t.getClass().getSimpleName());
		} finally {
			em.clear();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IDAOGenerico#buscarId(int, java.lang.Class)
	 */
	public T buscarId(int id, Class<T> objeto) throws DAOException {
		try {
			t = em.find(objeto, id);
			return t;
		} catch (NoResultException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IDAOGenerico#ListaTudo(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List<T> listaTudo(Class<T> objeto) throws DAOException {
		List<T> lista = null;
		try {
			lista = em.createQuery("Select obj from " + objeto.getSimpleName() + " obj").getResultList();
			return lista;
		} catch (Exception e) {
			return null;
		} finally {
			em.clear();
		}
	}
}
