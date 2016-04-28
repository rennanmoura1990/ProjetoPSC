package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Nota extends Geral{

	private double nota1;
	
	private double nota2;
	
	private double media;
	
	private double nota_recuperacao;
	
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

	public Nota() {
		super();
	}
	public Nota(double nota1, double nota2, double media,double nota_recuperacao,String unidade, Aluno aluno, Disciplina disciplina) {
		super();
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
		this.nota_recuperacao = nota_recuperacao;
		this.unidade = unidade;
		this.aluno = aluno;
		this.disciplina = disciplina;
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
	public double getNota_recuperacao() {
		return nota_recuperacao;
	}
	public void setNota_recuperacao(double nota_recuperacao) {
		this.nota_recuperacao = nota_recuperacao;
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
