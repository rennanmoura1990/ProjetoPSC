package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends Geral {

	@Column(nullable = false)
	private String login;

	@Column(nullable = false)
	private String senha;
	
	private String tipoUsuario;
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha,String tipoUsuario) {
		super();
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
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
}
