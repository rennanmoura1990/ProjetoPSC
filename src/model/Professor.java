package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Professor extends Pessoa {
	
	@OneToMany (mappedBy = "professor")
	@Cascade(CascadeType.ALL)
	private List<Disciplina> disciplinas;

	public Professor() {
		super();
	}
	
	public List<Disciplina> getDisciplina() {
		return disciplinas;
	}

	public void setDisciplina(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
