package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAOStatusDisciplina;
import dao.IDAOStatusDisciplina;
import exception.DAOException;
import model.StatusDisciplina;
import model.enums.Status;

public class RNStatusDisciplina {

	IDAOStatusDisciplina daostatusdisciplina;

	public RNStatusDisciplina() {
		daostatusdisciplina = new DAOStatusDisciplina();
	}

	public void inserir(StatusDisciplina sd) throws DAOException {
		try {
			daostatusdisciplina.inserir(sd);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}
	
	public void alterar(StatusDisciplina sd) throws DAOException{
		try {
			daostatusdisciplina.alterar(sd);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}
	
	public void excluir(int id) throws DAOException{
		try {
			daostatusdisciplina.excluir(StatusDisciplina.class, id);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}
	
	public StatusDisciplina buscaId (int id) throws DAOException{
		return daostatusdisciplina.buscarId(id,StatusDisciplina.class);
	}
	
	public List<StatusDisciplina> listatudo() throws DAOException{
		return daostatusdisciplina.listaTudo(StatusDisciplina.class);
	}
	
	public void verificaStatusDisciplinaLancado(int id_aluno,int id_disciplina) throws DAOException{
		if (daostatusdisciplina.ExisteStatusDisciplina(id_aluno, id_disciplina) != null)
			throw new DAOException("Status do Aluno para esta disciplina já está lançado!");
	}
	public String Statusdisciplina(int id_aluno,int id_disciplina){
		StatusDisciplina statusDisciplina = daostatusdisciplina.ExisteStatusDisciplina(id_aluno, id_disciplina);
		String retorno = (statusDisciplina != null) ? statusDisciplina.getStatus() : Status.NADA.getStatus();
		return retorno;
	}
}
