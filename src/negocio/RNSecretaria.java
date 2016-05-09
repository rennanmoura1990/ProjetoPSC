package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOSecretaria;
import dao.IDAOSecretaria;
import exception.DAOException;
import exception.GeralException;
import model.Secretaria;

public class RNSecretaria {
	private final IDAOSecretaria daosecretaria;

	public RNSecretaria() {
		daosecretaria = new DAOSecretaria();
	}

	/**
	 * Verifica se existem campos inválidos
	 * 
	 * @param a
	 *            instância de Coordenador com seus dados
	 * @throws DAOException
	 */
	public void verificarObjeto(Secretaria s) throws DAOException {
		if (s == null)
			throw new DAOException("Dados inválidos!");
	}

	/**
	 * Verifica se todos os campos obrigatórios foram preenchidos
	 * 
	 * @param a
	 *            instância de Coordenador com seus dados
	 * @throws DAOException
	 */
	public void validaRegistro(Secretaria s) throws DAOException {
		if (s.getNome().isEmpty())
			throw new DAOException("Nome inválido!");
		if (s.getCpf().isEmpty())
			throw new DAOException("CPF inválido!");
		if (s.getRg().isEmpty())
			throw new DAOException("RG inválido!");
	}

	/**
	 * Returna um Coordenador se encontrar o cpf preenchido
	 * 
	 * @param a
	 *            objeto contendo o cpf
	 * @return O Coordenador correspondente
	 * @throws DAOException
	 */

	public Secretaria buscarId(int id) throws DAOException {
		try {
			return daosecretaria.buscarId(id,Secretaria.class);
		} catch (PersistenceException e) {
			throw new DAOException("Erro no banco de dados!");
		} catch (DAOException e) {
			throw new DAOException("Cpf inválido!");
		}
	}

	/**
	 * Verifica se o registro é novo (não duplicado)
	 * 
	 * @param a
	 *            objeto contendo o cpf
	 * @throws DAOException
	 */

	public void novoRegistro(Secretaria s) throws DAOException {
		if (buscaSecretaria(s.getNome()) != null)
			throw new DAOException("Secretaria já existe no banco de dados");
	}

	public void inserir(Secretaria s) throws DAOException {
		try {
			daosecretaria.inserir(s);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}
	
	public Secretaria buscaSecretaria(String nome) throws DAOException {
		try {
			return daosecretaria.buscaSecretariaNome(nome);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar Secretaria por nome");
		}
	}
	
	public void registroExistente(Secretaria s) throws DAOException, GeralException{
		if(buscarId(s.getId()) == null){
			throw new GeralException("Secretaria não existe no banco!");
		}
	}
	
	public void alterar(Secretaria s) throws DAOException {
		try {
			daosecretaria.alterar(s);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public void excluir(int id) throws DAOException {
		try {
			daosecretaria.excluir(Secretaria.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao exluir dados!");
		}
	}
	
	public List<Secretaria> listarTudo() throws DAOException{
		try {
			return daosecretaria.listaTudo(Secretaria.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Não foi possível listar toda Secretaria");
		}
	}
}
