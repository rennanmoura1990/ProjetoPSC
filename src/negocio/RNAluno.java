package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOAluno;
import dao.DAOTurma;
import dao.IDAOAluno;
import dao.IDAOTurma;
import exception.DAOException;
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

	public void verificaObjeto(Aluno a) throws Exception {
		if (a == null) {
			throw new Exception("Cadastro invalido");
		}
	}

	public void validaRegistro(Aluno a) throws Exception {
		if (a.getCpf().isEmpty()) {
			throw new Exception("CPF Invalido!");
		}
		if (a.getDtnasc() == null) {
			throw new Exception("Data de Nascimento invalida!");
		}
		if (a.getMatricula().isEmpty()) {
			throw new Exception("Data de Nascimento invalida!");
		}
		if (a.getNome().isEmpty()) {
			throw new Exception("Nome invalido!");
		}
		if (a.getRg().isEmpty()) {
			throw new Exception("RG invalido!");
		}
		if (a.getTurma() == null) {
			throw new Exception("E necessario esta em uma turma!");
		}
	}

	public Aluno buscaAluno(Aluno a) throws DAOException {
		try {
			return daoaluno.buscaAlunoNome(a.getNome());
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar aluno por nome");
		}
	}

	public void registroNovoAluno(Aluno a) throws Exception {
		if (buscaAluno(a) != null) {
			throw new Exception("Aluno ja existente!");
		}
	}

	public void registroExistente(Aluno a) throws DAOException, Exception{
		if(buscaID(a) == null){
			throw new Exception("Aluno nao existe no banco!");
		}
	}

	public Aluno buscaID(Aluno a) throws DAOException {
		try {
			return daoaluno.buscarId(a.getId(), Aluno.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Aluno por id");
		}
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
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public List<Aluno> listarTudo() throws DAOException{
		try {
			return daoaluno.listaTudo(Aluno.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Nao foi possivel Listar todos alunos!");
		}
	}
	
	/**
	 * Verifica se a sala tem mais de 40 alunos
	 * 
	 * @param id_turma
	 * @return
	 * @throws DAOException
	 */
	public boolean verificaSala(int id_turma) throws DAOException {
		boolean verifica = true;
		long qtd = this.daoaluno.QtdAlunoTurma(id_turma);
		if (qtd > 40) {
			verifica = false;
		}
		return verifica;
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
	public String verificaPorcentagemFalta(int id_aluno, int id_turma) throws DAOException {
		String status = null;
		int faltas = this.daoaluno.NumeroFaltas(id_aluno);
		int aulas = this.daoturma.PegarAulasTotais(id_turma);
		double porcentagem = (faltas / aulas) * 100;
		if (porcentagem > 25) {
			status = Status.REPROVADO_PORFALTA.getStatus();
		} else {
			status = null;
		}
		return status;
	}
}
