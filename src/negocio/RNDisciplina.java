package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAODisciplina;
import dao.IDAODisciplina;
import exception.DAOException;
import exception.GeralException;
import model.Disciplina;
import model.enums.Dias_semana;
import model.enums.Horarios;

public class RNDisciplina {
	private final IDAODisciplina daodisciplina;

	public RNDisciplina() {
		daodisciplina = new DAODisciplina();
	}

	/**
	 * Verifica se existem campos inválidos
	 * 
	 * @param a
	 *            instância de Disciplina com seus dados
	 * @throws DAOException
	 */
	public void verificarObjeto(Disciplina d) throws DAOException {
		if (d == null)
			throw new DAOException("Dados inválidos!");
	}

	/**
	 * Verifica se todos os campos obrigatórios foram preenchidos
	 * 
	 * @param a
	 *            instância de Disciplina com seus dados
	 * @throws DAOException
	 */
	public void validaRegistro(Disciplina a) throws DAOException {
		if (a.getDiaSemana().isEmpty())
			throw new DAOException("Dia da semana inválido!");
		if (a.getNomeDisciplina().isEmpty())
			throw new DAOException("Nome da disciplina inválido!");
		if (a.getHorario().isEmpty())
			throw new DAOException("Horário inválido!");
	}

	public void novoRegistro(Disciplina d) throws DAOException {
		if (buscaDisciplina(d.getNomeDisciplina()) != null)
			throw new DAOException("Disciplina já existe no banco de dados");
	}

	public void inserir(Disciplina d) throws DAOException {
		try {
			daodisciplina.inserir(d);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public Disciplina buscaDisciplina(String nome) throws DAOException {
		try {
			return daodisciplina.buscaDisciplinanome(nome);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar Disciplina por nome");
		}
	}

	public void registroExistente(Disciplina d) throws DAOException,GeralException {
		if (buscaID(d.getId()) == null) {
			throw new GeralException("Disciplina não existente no banco!");
		}
	}
	
	public Disciplina buscaID(int id) throws DAOException {
		try {
			return daodisciplina.buscarId(id,Disciplina.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Disciplina por id");
		}
	}
	public void alterar(Disciplina d) throws DAOException {
		try {
			daodisciplina.alterar(d);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}

	public void excluir(int id) throws DAOException {
		try {
			daodisciplina.excluir(Disciplina.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao excluir dados!");
		}
	}

	public List<Disciplina> listarTudo() throws DAOException {
		try {
			return daodisciplina.listaTudo(Disciplina.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Não foi possível Listar todas Disciplinas!");
		}
	}
	
	public List<Horarios> horarios() throws GeralException{
		try {
			return daodisciplina.listaHorarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException (e.getMessage());
		}
	}
	
	public List<Dias_semana> diasSemana() throws GeralException{
		try {
			return daodisciplina.listaDiasSemana();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException (e.getMessage());
		}
	}
	
	public List<Disciplina> listaDisciplinaPorProfessor(int id_professor) throws GeralException{
		try {
			return daodisciplina.disciplinaPorProfessor(id_professor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException(e.getMessage());
		}
	}
	
}
