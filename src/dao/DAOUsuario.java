package dao;

import javax.persistence.Query;


import model.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario> {
	/**
	 * Retorna true se a query me retornar com resultado e false se retornar nada
	 * @param login
	 * @param senha
	 * @return
	 */
	public boolean Logar(String login,String senha){
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE login = :login AND senha= :senha",Usuario.class);
		query.setParameter("login",login);
		query.setParameter("senha",senha);
		Usuario u = (Usuario) query.getSingleResult();
		if (u.equals(null)){
			return false;
		}else{
			return true;
		}
	}
}
