package dao;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario> implements IDAOUsuario{
	/**
	 * Retorna objeto do usuário
	 * @param login
	 * @param senha
	 * @return
	 */
	public Usuario Logar(String login,String senha) throws DAOException{
		try {
			Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha",Usuario.class);
			query.setParameter("login",login);
			query.setParameter("senha",senha);
			return (Usuario) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao fazer login!");
			}
		}
	}
