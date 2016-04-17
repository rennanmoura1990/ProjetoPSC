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
public class Turma {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_turma;
	@Column(nullable=false)
	private String nome_turma;
	@OneToMany(mappedBy="turma")
	@Cascade(CascadeType.ALL)
	private List<Aluno> alunos;
	@OneToMany(mappedBy="turma")
	@Cascade(CascadeType.ALL)
	private List<Disciplina> disciplina;
	public int getId_turma() {
		return id_turma;
	}
	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}
	public String getNome_turma() {
		return nome_turma;
	}
	public void setNome_turma(String nome_turma) {
		this.nome_turma = nome_turma;
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
