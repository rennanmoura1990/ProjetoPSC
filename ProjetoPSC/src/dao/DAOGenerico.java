
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public abstract class DAOGenerico<T> {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Colegio"); //
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	T t; //objeto
	public void inserir(T t){
		try{
			et.begin();
			em.persist(t);
			et.commit();
		}catch(PersistenceException e)
		{
			et.rollback();
		}
	}
	public void alterar(T t){
		try{
			et.begin();
			em.merge(t);
			et.commit();
		}catch(PersistenceException e){
			et.rollback();
		}
	}
	public void excluir(Class<T> objeto,int id){
		try {
			et.begin();
			t = (T) em.find((Class<T>) objeto,id);
			em.remove(t);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
		}
	}
	public T buscarId(int id,Class<T> objeto){
		try {
			t = em.find(objeto,id);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return t;
	}
	public List<T> ListaTudo(Class<T> objeto){
		List<T> lista = null;
		try {
			lista = em.createQuery("Select obj from "+objeto.getSimpleName() + " obj").getResultList();
			return lista;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;	
	}
}
=======
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public abstract class DAOGenerico<T> {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Colegio"); //
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	T t; //objeto
	public void inserir(T t){
		try{
			et.begin();
			em.persist(t);
			et.commit();
		}catch(PersistenceException e)
		{
			et.rollback();
		}
	}
	public void alterar(T t){
		try{
			et.begin();
			em.merge(t);
			et.commit();
		}catch(PersistenceException e){
			et.rollback();
		}
	}
	public void excluir(Class<T> objeto,int id){
		try {
			et.begin();
			t = (T) em.find((Class<T>) objeto,id);
			em.remove(t);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
		}
	}
	public T buscarId(int id,Class<T> objeto){
		try {
			t = em.find(objeto,id);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return t;
	}
	public List<T> ListaTudo(Class<T> objeto){
		List<T> lista = null;
		try {
			lista = em.createQuery("Select obj from "+objeto.getSimpleName() + " obj").getResultList();
			return lista;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;	
	}
}

