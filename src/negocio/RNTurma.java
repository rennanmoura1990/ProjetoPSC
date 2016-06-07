package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOTurma;
import dao.IDAOTurma;
import exception.DAOException;
import exception.GeralException;
import model.Turma;

public class RNTurma {
	IDAOTurma daoturma;

	public RNTurma() {
		daoturma = new DAOTurma();
	}

	public void inserir(Turma t) throws DAOException {
		try {
			daoturma.inserir(t);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public void verificaObjeto(Turma t) throws GeralException {
		if (t == null) {
			throw new GeralException("Cadastro inválido");
		}
	}

	public void validaRegistro(Turma t) throws GeralException {
		if (t.getNomeTurma().isEmpty()) {
			throw new GeralException("Nome inválido!");
		}
		if (t.getQtd_aulas() == 0) {
			throw new GeralException("Numero de aulas inválido!");
		}
	}

	public Turma buscaTurma(String nome) {
		return daoturma.BuscaTurmaNome(nome);
	}

	public void registroNovoTurma(Turma t) throws GeralException, DAOException {
		if (buscaTurma(t.getNomeTurma()) != null) {
			throw new GeralException("Turma já existente!");
		}
	}

	public void registroExistente(Turma t) throws DAOException, GeralException {
		if (buscaID(t.getId()) == null) {
			throw new GeralException("Turma não existente no banco!");
		}
	}

	public Turma buscaID(int id) throws DAOException {
		try {
			return daoturma.buscarId(id, Turma.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Turma por id");
		}
	}

	public void alterar(Turma t) throws DAOException {
		try {
			daoturma.alterar(t);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}

	public List<Turma> listarTudo() throws DAOException {
		try {
			return daoturma.listaTudo(Turma.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Não foi possível Listar todas turmas!");
		}
	}

	public List<Turma> listarTurmasAtivas() {
		return daoturma.listarTurmasAtivas();
	}
}
