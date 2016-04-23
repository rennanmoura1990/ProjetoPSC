package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
public class Turma extends Geral{

	@Column(nullable=false)
	private String nomeTurma;
	
	@OneToMany(mappedBy="turma")
	@Cascade(CascadeType.ALL)
	private List<Aluno> alunos;
	
	@OneToMany(mappedBy="turma")
	@Cascade(CascadeType.ALL)
	private List<Disciplina> disciplina;

	public Turma() {
		super();
	}
	
	public Turma(String nome_turma, List<Aluno> alunos, List<Disciplina> disciplina) {
		super();
		this.nomeTurma = nome_turma;
		this.alunos = alunos;
		this.disciplina = disciplina;
	}
	
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nome_turma) {
		this.nomeTurma = nome_turma;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Disciplina> getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	
}
