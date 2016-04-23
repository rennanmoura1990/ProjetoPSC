package model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cpf;
	@Column(nullable=false)
	private String rg;
	@OneToMany (mappedBy = "pessoa")
	@Cascade(CascadeType.ALL)
	private List<Telefones> telefones;
	@Temporal(TemporalType.DATE)
	private Calendar dtnasc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public List<Telefones> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefones> telefones) {
		this.telefones = telefones;
	}
	public Calendar getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(Calendar dtnasc) {
		this.dtnasc = dtnasc;
	}
	
}
