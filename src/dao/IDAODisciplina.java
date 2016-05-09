package dao;

import java.util.List;

import exception.DAOException;
import exception.GeralException;
import model.Disciplina;
import model.enums.Dias_semana;
import model.enums.Horarios;

public interface IDAODisciplina extends IDAOGenerico<Disciplina>{
	public Disciplina buscaDisciplinanome(String nome) throws DAOException;
	public List<Horarios> listaHorarios() throws GeralException;
	public List<Dias_semana> listaDiasSemana() throws GeralException;
}
