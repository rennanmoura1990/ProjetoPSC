package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOTelefones;
import dao.IDAOTelefones;
import exception.DAOException;
import model.Telefones;

public class RNTelefones {
	IDAOTelefones daotelefones;

	public RNTelefones() {
		daotelefones = new DAOTelefones();
	}

	/**
	 * Procura se aquele telefone está vinculada a uma pessoa
	 * 
	 * @param id_pessoa
	 * @param telefone
	 * @return
	 * @throws DAOException
	 */
	public boolean VerificaTelefone(int id_pessoa, String telefone) throws DAOException {
		boolean verifica = false;
		try {
			Telefones telefones = daotelefones.buscaTelefonesUsuario(id_pessoa, telefone);
			if (telefones == null) {
				verifica = true;
			}
			return verifica;
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Esse telefone já está vinculado a esta pessoa,por favor informe outro!");
		}
	}

	public void inserir(Telefones t) throws DAOException {
		try {
			daotelefones.inserir(t);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public void verificaObjeto(Telefones t) throws Exception {
		if (t == null) {
			throw new Exception("Cadastro invalido");
		}
	}

	public void validaRegistro(Telefones t) throws Exception {
		if (t.getTelefone() == null) {
			throw new Exception("Telefone inválido!");
		}
		if (t.getPessoa() == null) {
			throw new Exception("É necessário uma pessoa vinculada a este telefone!");
		}
	}

	public Telefones buscaTelefone(Telefones t) throws DAOException {
		try {
			return daotelefones.buscaTelefone(t.getTelefone());
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar Telefone!");
		}
	}

	public Telefones buscaID(Telefones t) throws DAOException {
		try {
			return daotelefones.buscarId(t.getId(), Telefones.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Telefones por id");
		}
	}

	public void alterar(Telefones t) throws DAOException {
		try {
			daotelefones.alterar(t);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}

	public void excluir(int id) throws DAOException {
		try {
			daotelefones.excluir(Telefones.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao excluir dados!");
		}
	}

	public List<Telefones> listarTudo() throws DAOException {
		try {
			return daotelefones.listaTudo(Telefones.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Nao foi possivel Listar todos telefones!");
		}
	}
}
