package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOCoordenador;
import dao.IDAOCoordenador;
import exception.DAOException;
import model.Coordenador;

public class RNCoordenador {
	private final IDAOCoordenador daocoordenador;

	public RNCoordenador() {
		daocoordenador = new DAOCoordenador();
	}

	/**
	 * Verifica se existem campos inválidos
	 * 
	 * @param a
	 *            instância de Coordenador com seus dados
	 * @throws DAOException
	 */
	public void verificarObjeto(Coordenador c) throws DAOException {
		if (c == null)
			throw new DAOException("Dados inválidos!");
	}

	/**
	 * Verifica se todos os campos obrigatórios foram preenchidos
	 * 
	 * @param a
	 *            instância de Coordenador com seus dados
	 * @throws DAOException
	 */
	public void validaRegistro(Coordenador c) throws DAOException {
		if (c.getNome().isEmpty())
			throw new DAOException("Nome inválido!");
		if (c.getCpf().isEmpty())
			throw new DAOException("CPF inválido!");
		if (c.getRg().isEmpty())
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

	public Coordenador buscarId(Coordenador c) throws DAOException {
		try {
			return daocoordenador.buscarId(c.getId(), Coordenador.class);
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

	public void novoRegistro(Coordenador c) throws DAOException {
		if (buscaCoordenador(c) != null)
			throw new DAOException("Coordenador já existe no banco de dados");
	}

	public void inserir(Coordenador c) throws DAOException {
		try {
			daocoordenador.inserir(c);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}
	
	public Coordenador buscaCoordenador(Coordenador c) throws DAOException {
		try {
			return daocoordenador.buscaCoordenadorNome(c.getNome());
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar Coordenador por nome");
		}
	}
	
	public void registroExistente(Coordenador c) throws DAOException, Exception{
		if(buscarId(c) == null){
			throw new Exception("Coordenador não existe no banco!");
		}
	}
	
	public void alterar(Coordenador c) throws DAOException {
		try {
			daocoordenador.alterar(c);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public void excluir(int id) throws DAOException {
		try {
			daocoordenador.excluir(Coordenador.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao exluir dados!");
		}
	}
	
	public List<Coordenador> listarTudo() throws DAOException{
		try {
			return daocoordenador.listaTudo(Coordenador.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Nao foi possivel Listar todos coordenaores!");
		}
	}
}
