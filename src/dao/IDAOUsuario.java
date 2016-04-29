package dao;

import exception.DAOException;
import model.Usuario;

public interface IDAOUsuario extends IDAOGenerico<Usuario>{
	public Usuario BuscaUsuarioLogin (String login) throws DAOException;
	public Usuario Logar(String login,String senha) throws DAOException;
}
