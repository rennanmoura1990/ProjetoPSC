package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOTurma;
import dao.IDAOTurma;
import exception.DAOException;
import model.Turma;

public class RNTurma {
	IDAOTurma daoturma;
	
	public RNTurma(){
		daoturma = new DAOTurma();
	}
	
	public void inserir(Turma t) throws DAOException {
		try {
			daoturma.inserir(t);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar dados!");
		}
	}

	public void verificaObjeto(Turma t) throws Exception {
		if (t == null) {
			throw new Exception("Cadastro inválido");
		}
	}

	public void validaRegistro(Turma t) throws Exception {
		if(t.getNomeTurma().isEmpty()){
			throw new Exception("Nome inválido!");
		}
		if(t.getQtd_aulas() == 0 ){
			throw new Exception("Numero de aulas inválido!");
		}
	}

	public Turma buscaTurma(Turma t) throws DAOException {
		try {
			return daoturma.BuscaTurmaNome(t.getNomeTurma());
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao buscar turma por nome");
		}
	}

	public void registroNovoTurma(Turma t) throws Exception {
		if (buscaTurma(t) != null) {
			throw new Exception("Turma já existente!");
		}
	}

	public void registroExistente(Turma t) throws DAOException, Exception{
		if(buscaID(t) == null){
			throw new Exception("Turma não existente no banco!");
		}
	}

	public Turma buscaID(Turma t) throws DAOException {
		try {
			return daoturma.buscarId(t.getId(),Turma.class);
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
	
	public void excluir(int id) throws DAOException {
		try {
			daoturma.excluir(Turma.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao alterar dados!");
		}
	}
	
	public List<Turma> listarTudo() throws DAOException{
		try {
			return daoturma.listaTudo(Turma.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Não foi possível Listar todas turmas!");
		}
	}
}
