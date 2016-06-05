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
import model.Coordenador;
import model.Pessoa;
import model.Secretaria;
import model.Telefones;

@ManagedBean
@SessionScoped
public class FuncionarioBean {
	private Pessoa pessoa;
	private Coordenador coordenador;
	private Secretaria secretaria;
	private List<Coordenador> coordenadores;
	private List<Secretaria> secretarias;
	private String telefone;
	private List<String> telefones;
	private Telefones telefoneObj;
	private IFachada fachada;

	public FuncionarioBean() {
		this.pessoa = new Pessoa();
		this.coordenador = new Coordenador();
		this.secretaria = new Secretaria();
		this.coordenadores = new ArrayList<Coordenador>();
		this.secretarias = new ArrayList<Secretaria>();
		this.telefones = new ArrayList<String>();
		this.telefoneObj = new Telefones();
		this.fachada = new Fachada();
	}

	public void addTelefone() {
		telefones.add(telefone);
	}

	public void cadastrarCoordenador() throws DAOException, GeralException {
		try {
			fachada.inserirCoordenador(coordenador);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(coordenador);
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
		coordenador = new Coordenador();
	}

	public void clear() {
		pessoa.setId(null);
		pessoa.setNome(null);
		pessoa.setCpf(null);
		pessoa.setRg(null);
		pessoa.setDtnasc(null);
		pessoa.setTelefones(null);
		telefone = null;
		telefones.clear();
	}

	public String menuPrincipal() {
		return "/menuprincipal?faces-redirect=true";
	}

	public void editarCoordenador() throws DAOException, GeralException {
		try {
			fachada.alterarCoordenador(coordenador);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(coordenador);
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
		coordenador = new Coordenador();
	}
	
	public void excluirCoordenador() throws DAOException{
		try {
			fachada.excluirCoordenador(coordenador.getId());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Exclusão Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}
	
	public void cadastrarSecretaria() throws DAOException, GeralException {
		try {
			fachada.inserirSecretaria(secretaria);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(secretaria);
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
		secretaria = new Secretaria();
	}
	
	public void editarSecretaria() throws DAOException, GeralException {
		try {
			fachada.alteraSecretaria(secretaria);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(secretaria);
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
		secretaria = new Secretaria();
	}
	
	public void excluirSecretaria() throws DAOException{
		try {
			fachada.excluirSecretaria(secretaria.getId());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Exclusão Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public List<Coordenador> getCoordenadores() throws DAOException {
		coordenadores = fachada.listaCoordenador();
		return coordenadores;
	}

	public void setCoordenadores(List<Coordenador> coordenadores) {
		this.coordenadores = coordenadores;
	}

	public List<Secretaria> getSecretarias() throws DAOException {
		secretarias = fachada.listaSecretaria();
		return secretarias;
	}

	public void setSecretarias(List<Secretaria> secretarias) {
		this.secretarias = secretarias;
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

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

}