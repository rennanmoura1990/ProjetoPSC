package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
public class Telefones {
	@Id
	private int id_telefone;
	@Column(nullable=false)
	private String telefone;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pessoa",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Pessoa pessoa;
	public int getId_telefone() {
		return id_telefone;
	}
	public void setId_telefone(int id_telefone) {
		this.id_telefone = id_telefone;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
