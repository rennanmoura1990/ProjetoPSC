package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Classe pra dizer se o Aluno foi reprovado,aprovado ou em recuperação.
 * 
 * @author rennanmoura
 *
 */

@Entity
public class Status extends Geral {
	@OneToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	@OneToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	@OneToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	@Column(nullable = false)
	private String status;

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(Aluno aluno, Turma turma, Disciplina disciplina, String status) {
		this.aluno = aluno;
		this.turma = turma;
		this.disciplina = disciplina;
		this.status = status;

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
