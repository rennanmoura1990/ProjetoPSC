package dao;

import java.util.List;

import exception.GeralException;
import model.Disciplina;
import model.enums.Dias_semana;
import model.enums.Horarios;

public interface IDAODisciplina extends IDAOGenerico<Disciplina>{
	public Disciplina buscaDisciplinanome(String nome);
	public List<Horarios> listaHorarios() throws GeralException;
	public List<Dias_semana> listaDiasSemana() throws GeralException;
	public List<Disciplina> disciplinaPorProfessor(int id_professor) throws GeralException;
	public List<Disciplina> listarDisciplinaAtivas();
	public List<Disciplina> listarDisciplinaTurma(int id_turma);
}
