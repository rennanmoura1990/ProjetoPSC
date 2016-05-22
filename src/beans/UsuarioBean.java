package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import exception.DAOException;
import fachada.Fachada;
import fachada.IFachada;
import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private String login;
	private String senha;
	private Usuario usuario;
	private IFachada fachada;

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.fachada = new Fachada();
	}

	public String Logar() {
		try {
			usuario = fachada.fazerLogin(login, senha);
			if (usuario != null)
				return "menuprincipal";
		} catch (DAOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
		return "/index.xhtml?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

}
