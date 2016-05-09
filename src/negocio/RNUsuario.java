package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOUsuario;
import dao.IDAOUsuario;
import exception.DAOException;
import exception.GeralException;
import model.Usuario;

public class RNUsuario {
	IDAOUsuario daousuario;

	public RNUsuario() {
		daousuario = new DAOUsuario();
	}

	public void inserir(Usuario u) throws DAOException {
		try {
			daousuario.inserir(u);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public void verificaObjeto(Usuario u) throws GeralException {
		if (u == null) {
			throw new GeralException("Cadastro inválido");
		}
	}

	public void validaRegistro(Usuario u) throws GeralException {
		if (u.getLogin() == null) {
			throw new GeralException("Login Inválido!");
		}
		if (u.getSenha() == null) {
			throw new GeralException("Senha Inválida!");
		}
	}

	public Usuario buscaUsuario(Usuario u) throws DAOException {
		try {
			return daousuario.BuscaUsuarioLogin(u.getLogin());
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar Usuário por login!");
		}
	}

	public void registroNovoUsuario(Usuario u) throws GeralException, DAOException {
		if (buscaUsuario(u) != null) {
			throw new GeralException("Usuário ja existente!");
		}
	}

	public void registroExistente(Usuario u) throws DAOException, GeralException {
		if (buscaID(u.getId()) == null) {
			throw new GeralException("Usuário nao existe no banco!");
		}
	}

	public Usuario buscaID(int id) throws DAOException {
		try {
			return daousuario.buscarId(id, Usuario.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Usuário por id");
		}
	}

	public void alterar(Usuario u) throws DAOException {
		try {
			daousuario.alterar(u);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}

	public void excluir(int id) throws DAOException {
		try {
			daousuario.excluir(Usuario.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}

	public List<Usuario> listarTudo() throws DAOException {
		try {
			return daousuario.listaTudo(Usuario.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Não foi possível Listar todos usuários!");
		}
	}

	/**
	 * Retorna false,caso n�o consiga encontrar o usu�rio
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws DAOException
	 */
	public boolean verificaUsuarioExistente(String login, String senha) throws DAOException {
		boolean verifica = true;
		Usuario u;
		u = this.daousuario.Logar(login, senha);
		if (u == null) {
			verifica = false;
		}
		return verifica;
	}

	public Usuario buscaUsuarioLogin(String login) throws DAOException {
		try {
			return daousuario.BuscaUsuarioLogin(login);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

}
