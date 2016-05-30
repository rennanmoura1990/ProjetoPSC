package dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import exception.GeralException;
import model.Usuario;
import model.enums.TiposUsuarios;

public class DAOUsuario extends DAOGenerico<Usuario> implements IDAOUsuario {

	public Usuario BuscaUsuarioLogin(String login){
		try {
			Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
			query.setParameter("login", login);
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}

	/**
	 * Retorna objeto do usuário
	 * 
	 * @param login
	 * @param senha
	 * @return
	 */
	public Usuario Logar(String login, String senha) throws DAOException {
		try {
			Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha",
					Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			return (Usuario) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao fazer login!");
		} finally {
			em.clear();
		}
	}
	public List<TiposUsuarios> tiposUsuarios() throws GeralException{
		try {
			List<TiposUsuarios> tpUsuarios = Arrays.asList(TiposUsuarios.values());
			return tpUsuarios;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException("Erro ao listar Tipos de Usuario!");
		}
	}
}
