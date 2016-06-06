package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import exception.DAOException;
import exception.GeralException;
import fachada.Fachada;
import fachada.IFachada;
import model.Turma;

@ManagedBean
@SessionScoped
public class TurmaBean {

	private Turma turma;
	private List<Turma> turmas;
	private IFachada fachada;

	public TurmaBean() {
		turma = new Turma();
		turmas = new ArrayList<Turma>();
		fachada = new Fachada();
	}

	public void cadastrarTurma() throws DAOException, GeralException {
		try {
			fachada.inserirTurma(turma);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Cadastro Realizado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		turma = new Turma();
	}

	public void clear() {
		turma.setId(null);
		turma.setNomeTurma(null);
		turma.setQtd_aulas(0);
	}

	public void editarTurma() throws DAOException, GeralException {
		try {
			fachada.alteraTurma(turma);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Edição Realizado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		turma = new Turma();
	}

	public void excluirTurma() throws DAOException {
		try {

			fachada.excluirTurma(turma.getId());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Exclusão Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		turma = new Turma();
	}

	public String menuPrincipal() {
		return "/menuprincipal?faces-redirect=true";
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() throws DAOException {
		turmas = fachada.listaTurma();
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}
}
