package dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import exception.GeralException;
import model.Disciplina;
import model.enums.*;

public class DAODisciplina extends DAOGenerico<Disciplina> implements IDAODisciplina {

	public Disciplina buscaDisciplinanome(String nome){
		try {
			Query query = em.createQuery("SELECT d FROM Disciplina d WHERE d.nomeDisciplina = :nome", Disciplina.class);
			query.setParameter("nome", nome);
			return (Disciplina) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			em.clear();
		}
	}

	// Lista Enum Horario
	public List<Horarios> listaHorarios() throws GeralException {
		try {
			List<Horarios> horarios = Arrays.asList(Horarios.values());
			return horarios;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException(e.getMessage());
		} finally {
			em.clear();
		}
	}

	// Lista Enum Dias_Semana
	public List<Dias_semana> listaDiasSemana() throws GeralException {
		try {
			List<Dias_semana> dias_semana = Arrays.asList(Dias_semana.values());
			return dias_semana;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException(e.getMessage());
		} finally {
			em.clear();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Disciplina> disciplinaPorProfessor(int id_professor) throws GeralException {
		try {
			Query query = em.createQuery("SELECT d FROM Disciplina d WHERE id_professor= :id");
			query.setParameter("id", id_professor);
			return (List<Disciplina>) query.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> listarDisciplinaAtivas() {
		try {
			Query query = em.createQuery("SELECT d FROM Disciplina d WHERE d.disciplinaAtiva = 'S'",Disciplina.class);
			return (List<Disciplina>) query.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
