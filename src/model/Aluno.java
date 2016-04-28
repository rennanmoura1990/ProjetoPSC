package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Aluno extends Pessoa {

	@Column(nullable = false)
	private String matricula;
	private int faltas = 0;
	private double porcentagem = 0.0;
	private String status;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_turma", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Turma turma;

	@OneToMany(mappedBy = "aluno")
	@Cascade(CascadeType.ALL)
	private List<Nota> notas;
	

	public Aluno() {
		super();
	}

	public Aluno(String matricula,int faltas, double porcentagem,String status,Turma turma, List<Nota> notas) {
		super();
		this.matricula = matricula;
		this.faltas = faltas;
		this.porcentagem = porcentagem;
		this.status = status;
		this.turma = turma;
		this.notas = notas;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

}
