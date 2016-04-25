package dao;

import javax.persistence.Query;


import model.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario> implements IDAOUsuario{
	/**
	 * Retorna true se a query me retornar com resultado e false se retornar nada
	 * @param login
	 * @param senha
	 * @return
	 */
	public Usuario Logar(String login,String senha){
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha",Usuario.class);
		query.setParameter("login",login);
		query.setParameter("senha",senha);
		return (Usuario) query.getSingleResult();
		}
	}
}
