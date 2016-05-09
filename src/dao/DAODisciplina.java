package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import exception.GeralException;
import model.Disciplina;
import model.enums.*;

public class DAODisciplina extends DAOGenerico<Disciplina> implements IDAODisciplina {
	
	public Disciplina buscaDisciplinanome(String nome) throws DAOException {
		try {
			Query query = em.createQuery("SELECT d FROM Disciplina d WHERE d.nomeDisciplina = :nome",Disciplina.class);
			query.setParameter("nome", nome);
			return (Disciplina) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao Buscar Disciplina por Nome!");
		}
	}
	
	//Lista Enum Horario
	public List<Horarios> listaHorarios() throws GeralException{
		try {
			List<Horarios> horarios = Arrays.asList(Horarios.values());
			return horarios;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException(e.getMessage());
		}
	}
	
	
	//Lista Enum Dias_Semana
	public List<Dias_semana> listaDiasSemana() throws GeralException{
		try {
			List<Dias_semana> dias_semana = Arrays.asList(Dias_semana.values());
			return dias_semana;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException(e.getMessage());
		}
	}
	
}
