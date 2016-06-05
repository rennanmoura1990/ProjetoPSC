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
import model.Professor;
import model.Telefones;

@ManagedBean
@SessionScoped
public class ProfessorBean {

	private Professor professor;
	private List<Professor> professores;
	private String telefone;
	private List<String> telefones;
	private Telefones telefoneObj;
	private IFachada fachada;

	public ProfessorBean() {
		professor = new Professor();
		professores = new ArrayList<Professor>();
		telefones = new ArrayList<String>();
		telefoneObj = new Telefones();
		fachada = new Fachada();
	}

	public void addTelefone() {
		telefones.add(telefone);
	}

	public void cadastrarProfessor() throws GeralException, DAOException {
		try {
			fachada.inserirProfessor(professor);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(professor);
				telefoneObj.setTelefone(tel);
				fachada.inserirTelefone(telefoneObj);
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Cadastro Realizado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		professor = new Professor();
	}

	public void clear() {
		professor.setId(null);
		professor.setNome(null);
		professor.setCpf(null);
		professor.setDtnasc(null);
		professor.setRg(null);
		professor.setTelefones(null);
		telefone = null;
		telefones.clear();
	}

	public void editarProfessor() throws GeralException, DAOException {
		try {
			fachada.alteraProfessor(professor);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(professor);
				telefoneObj.setTelefone(tel);
				fachada.alteraTelefone(telefoneObj);
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Edição Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		professor = new Professor();
	}

	public void excluirProfessor() throws DAOException {
		try {
			fachada.excluirProfessor(professor.getId());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Exclusão Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		professor = new Professor();
	}
	
	public String menuPrincipal(){
		return "/menuprincipal?faces-redirect=true";
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() throws DAOException {
		professores = fachada.listaProfessor();
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public Telefones getTelefoneObj() {
		return telefoneObj;
	}

	public void setTelefoneObj(Telefones telefoneObj) {
		this.telefoneObj = telefoneObj;
	}

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}
}
