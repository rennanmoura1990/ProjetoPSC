package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOProfessor;
import dao.IDAOProfessor;
import exception.DAOException;
import model.Professor;

public class RNProfessor {
	IDAOProfessor daoprofessor;
	
	public RNProfessor(){
		daoprofessor = new DAOProfessor();
	}
	
	public void inserir(Professor p) throws DAOException {
		try {
			daoprofessor.inserir(p);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public void verificaObjeto(Professor p) throws Exception {
		if (p == null) {
			throw new Exception("Cadastro inválido");
		}
	}

	public void validaRegistro(Professor p) throws Exception {
		if (p.getCpf().isEmpty()) {
			throw new Exception("CPF Inválido!");
		}
		if (p.getDtnasc() == null) {
			throw new Exception("Data de Nascimento inválida!");
		}
		if (p.getDisciplina().isEmpty()) {
			throw new Exception("Professor precisa ter pelo menos uma disciplina!");
		}
		if (p.getNome().isEmpty()) {
			throw new Exception("Nome inválido!");
		}
		if (p.getRg().isEmpty()) {
			throw new Exception("RG inválido!");
		}
		if (p.getTelefones().isEmpty()) {
			throw new Exception("Professor precisa ter pelo menos um telefone de contato!");
		}
	}

	public Professor buscaProfessor(Professor p) throws DAOException {
		try {
			return daoprofessor.buscaProfessorNome(p.getNome());
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar professor por nome");
		}
	}

	public void registroNovoAluno(Professor p) throws Exception {
		if (buscaProfessor(p) != null) {
			throw new Exception("Professor já existente!");
		}
	}

	public void registroExistente(Professor p) throws DAOException, Exception{
		if(buscaID(p) == null){
			throw new Exception("Professor não existe no banco!");
		}
	}

	public Professor buscaID(Professor p) throws DAOException {
		try {
			return daoprofessor.buscarId(p.getId(),Professor.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao buscar Professor por id");
		}
	}
	
	public void alterar(Professor p) throws DAOException {
		try {
			daoprofessor.alterar(p);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public void excluir(int id) throws DAOException {
		try {
			daoprofessor.excluir(Professor.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public List<Professor> listarTudo() throws DAOException{
		try {
			return daoprofessor.listaTudo(Professor.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Não foi possível Listar todos alunos!");
		}
	}
}
