package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
public class Disciplina extends Geral{
	
	@Column(nullable=false)
	private String nomeDisciplina;
	
	@Column(nullable=false)
	private String horario;
	
	@Column(nullable=false)
	private String diaSemana;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_professor",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Professor professor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_turma",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Turma turma;
	
	@OneToMany(mappedBy="disciplina")
	@Cascade(CascadeType.ALL)
	List<Nota> notas;

	public Disciplina() {
		super();
	}
	
	public Disciplina(String nome_disciplina, String horario, String dia_semana, Professor professor, Turma turma,
			List<Nota> notas) {
		super();
		this.nomeDisciplina = nome_disciplina;
		this.horario = horario;
		this.diaSemana = dia_semana;
		this.professor = professor;
		this.turma = turma;
		this.notas = notas;
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nome_disciplina) {
		this.nomeDisciplina = nome_disciplina;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String dia_semana) {
		this.diaSemana = dia_semana;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
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
