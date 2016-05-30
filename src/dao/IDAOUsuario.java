package dao;

import java.util.List;

import exception.DAOException;
import exception.GeralException;
import model.Usuario;
import model.enums.TiposUsuarios;

public interface IDAOUsuario extends IDAOGenerico<Usuario>{
	public Usuario BuscaUsuarioLogin (String login);
	public Usuario Logar(String login,String senha) throws DAOException;
	public List<TiposUsuarios> tiposUsuarios() throws GeralException;
}
