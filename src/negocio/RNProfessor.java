package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOProfessor;
import dao.IDAOProfessor;
import exception.DAOException;
import exception.GeralException;
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

	public void verificaObjeto(Professor p) throws GeralException {
		if (p == null) {
			throw new GeralException("Cadastro inválido");
		}
	}

	public void validaRegistro(Professor p) throws GeralException {
		if (p.getCpf().isEmpty()) {
			throw new GeralException("CPF Inválido!");
		}
		if (p.getDtnasc() == null) {
			throw new GeralException("Data de Nascimento inválida!");
		}
		if (p.getDisciplina().isEmpty()) {
			throw new GeralException("Professor precisa ter pelo menos uma disciplina!");
		}
		if (p.getNome().isEmpty()) {
			throw new GeralException("Nome inválido!");
		}
		if (p.getRg().isEmpty()) {
			throw new GeralException("RG inválido!");
		}
		if (p.getTelefones().isEmpty()) {
			throw new GeralException("Professor precisa ter pelo menos um telefone de contato!");
		}
	}

	public Professor buscaProfessor(String nome) throws DAOException {
		try {
			return daoprofessor.buscaProfessorNome(nome);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar professor por nome");
		}
	}

	public void registroNovoProfessor(Professor p) throws GeralException, DAOException {
		if (buscaProfessor(p.getNome()) != null) {
			throw new DAOException("Professor já existente!");
		}
	}

	public void registroExistente(Professor p) throws DAOException, GeralException{
		if(buscaID(p.getId()) == null){
			throw new GeralException("Professor não existe no banco!");
		}
	}

	public Professor buscaID(int id) throws DAOException {
		try {
			return daoprofessor.buscarId(id,Professor.class);
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
