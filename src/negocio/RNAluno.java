package negocio;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import dao.DAOAluno;
import dao.DAOTurma;
import dao.IDAOAluno;
import dao.IDAOTurma;
import exception.DAOException;
import exception.GeralException;
import model.Aluno;
import model.enums.*;

public class RNAluno {
	IDAOAluno daoaluno;
	IDAOTurma daoturma;

	public RNAluno() {
		daoaluno = new DAOAluno();
		daoturma = new DAOTurma();
	}

	public void inserir(Aluno a) throws DAOException {
		try {
			daoaluno.inserir(a);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public void verificaObjeto(Aluno a) throws GeralException {
		if (a == null) {
			throw new GeralException("Cadastro inválido");
		}
	}

	public void validaRegistro(Aluno a) throws GeralException {
		if (a.getCpf().isEmpty()) {
			throw new GeralException("CPF Inválido!");
		}
		if (a.getDtnasc() == null) {
			throw new GeralException("Data de Nascimento inválida!");
		}
		if (a.getMatricula().isEmpty()) {
			throw new GeralException("Matrícula inválida!");
		}
		if (a.getNome().isEmpty()) {
			throw new GeralException("Nome inválido!");
		}
		if (a.getRg().isEmpty()) {
			throw new GeralException("RG inválido!");
		}
		if (a.getTurma() == null) {
			throw new GeralException("É necessário estar em uma turma!");
		}
	}

	public Aluno buscaAlunoNome(String nome) throws DAOException {
		return daoaluno.buscaAlunoNome(nome);
	}

	public void registroNovoAluno(Aluno a) throws GeralException, DAOException {
		if (buscaAlunoNome(a.getNome()) != null) {
			throw new GeralException("Aluno já existente!");
		}
		return;
	}

	public void registroExistente(Aluno a) throws DAOException, GeralException {
		if (buscaID(a.getId()) == null) {
			throw new GeralException("Aluno não existe no banco!");
		}
	}

	public Aluno buscaID(int id) throws DAOException {
		return daoaluno.buscarId(id, Aluno.class);
	}

	public void alterar(Aluno a) throws DAOException {
		try {
			daoaluno.alterar(a);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}

	public void excluir(int id) throws DAOException {
		try {
			daoaluno.excluir(Aluno.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao excluir dados!");
		}
	}

	public List<Aluno> listarTudo() throws DAOException {
		return daoaluno.listaTudo(Aluno.class);
	}

	/**
	 * Verifica se a sala tem mais de 40 alunos
	 * 
	 * @param id_turma
	 * @return
	 * @throws DAOException
	 */
	public void verificaSala(int id_turma) throws DAOException {
		long qtd = this.daoaluno.QtdAlunoTurma(id_turma);
		if (qtd > 40) {
			throw new DAOException("Turma cheia!");
		}
	}

	/**
	 * Verifica porcentagem de faltas de um aluno,se acima de 25% ele
	 * considerado reprovado por falta
	 * 
	 * @param id_aluno
	 * @param id_turma
	 * @return
	 * @throws DAOException
	 */
	public String verificaPorcentagemFalta(Aluno a) throws DAOException {
		String status = null;
		double porcentagem = a.getPorcentagem();
		if (porcentagem > 25) {
			status = Status.REPROVADO_PORFALTA.getStatus();
		} else {
			status = Status.NADA.getStatus();
		}
		return status;
	}

	public int QtdAlunoTurma(int turma_id) throws DAOException {
		try {
			return daoaluno.QtdAlunoTurma(turma_id);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public int NumeroFaltas(int id_aluno) throws DAOException {
		try {
			return daoaluno.NumeroFaltas(id_aluno);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public void LancaFalta(Aluno a) throws DAOException {
		try {
			daoaluno.LancaFalta(a);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public List<Status> status() throws GeralException {
		try {
			return daoaluno.status();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException(e.getMessage());
		}
	}

	public List<Aluno> listaAlunoPorTurma(int id_turma) {
		return daoaluno.alunoPorTurma(id_turma);
	}
}
