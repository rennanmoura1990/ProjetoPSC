package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends Geral{
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false,columnDefinition = "varchar(12)") //Senha de 12 caracteres
	private String senha;
	
	private boolean moduloProfessor = false;
	private boolean moduloAluno = false;
	private boolean moduloSecretaria = false;
	private boolean moduloCoordenador = false;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String login, String senha, boolean moduloProfessor, boolean moduloAluno, boolean moduloSecretaria,
			boolean moduloCoordenador) {
		super();
		this.login = login;
		this.senha = senha;
		this.moduloProfessor = moduloProfessor;
		this.moduloAluno = moduloAluno;
		this.moduloSecretaria = moduloSecretaria;
		this.moduloCoordenador = moduloCoordenador;
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
	public boolean isModuloProfessor() {
		return moduloProfessor;
	}
	public void setModuloProfessor(boolean moduloProfessor) {
		this.moduloProfessor = moduloProfessor;
	}
	public boolean isModuloAluno() {
		return moduloAluno;
	}
	public void setModuloAluno(boolean moduloAluno) {
		this.moduloAluno = moduloAluno;
	}
	public boolean isModuloSecretaria() {
		return moduloSecretaria;
	}
	public void setModuloSecretaria(boolean moduloSecretaria) {
		this.moduloSecretaria = moduloSecretaria;
	}
	public boolean isModuloCoordenador() {
		return moduloCoordenador;
	}
	public void setModuloCoordenador(boolean moduloCoordenador) {
		this.moduloCoordenador = moduloCoordenador;
	}
	
}
