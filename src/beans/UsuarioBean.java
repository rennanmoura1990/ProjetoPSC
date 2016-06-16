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

	public String Login() {
		try {
			usuario = fachada.fazerLogin(login, senha);
			if (usuario != null) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
				if (usuario.getTipoUsuario().equals("ALUNO")) {
					return "/aluno/consultanota?faces-redirect=true";
				} else if (usuario.getTipoUsuario().equals("PROFESSOR")) {
					return "/professor/notaspresenca?faces-redirect=true";
				} else if (usuario.getTipoUsuario().equals("COORDENADOR")) {
					return "/coordenador/menuprincipal?faces-redirect=true";
				} else if (usuario.getTipoUsuario().equals("SECRETARIA")) {
					return "/secretaria/menuprincipal?faces-redirect=true";
				} else {
					return "/adm/menuprincipal?faces-redirect=true";
				}
			}
		} catch (DAOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
		return "index?faces-redirect=true";
	}

	public String Logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";

	}

	public String formularioAluno() {
		return "/secretaria/formularioaluno?faces-redirect=true";
	}

	public String formularioDisciplina() {
		return "/secretaria/formulariodisciplina?faces-redirect=true";
	}

	public String formularioCoordenador() {
		return "/secretaria/formulariocoordenador?faces-redirect=true";
	}

	public String formularioSecretaria() {
		return "/secretaria/formulariosecretaria?faces-redirect=true";
	}

	public String formularioProfessor() {
		return "/secretaria/formularioprofessor?faces-redirect=true";
	}

	public String formularioTurma() {
		return "/secretaria/formularioturma?faces-redirect=true";
	}

	public String notas() {
		return "/professor/notas?faces-redirect=true";
	}
	
	public String aluno() {
		return "/aluno/consultanota?faces-redirect=true";
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
