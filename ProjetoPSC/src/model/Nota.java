package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_nota;
	@Column(nullable=false)
	private double nota1;
	@Column(nullable=false)
	private double nota2;
	@Column(nullable=false)
	private double media;
	@Column(nullable=false)
	private String unidade;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_aluno",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Aluno aluno;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_disciplina",insertable=true,updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Disciplina disciplina;
	public int getId_nota() {
		return id_nota;
	}
	public void setId_nota(int id_nota) {
		this.id_nota = id_nota;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}
