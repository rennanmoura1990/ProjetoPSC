package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;

import exception.DAOException;
import exception.GeralException;
import model.Nota;
import model.enums.Unidades;
import model.Aluno;
import model.Disciplina;

public class DAONota extends DAOGenerico<Nota> implements IDAONota {
	/**
	 * Emite a média final de um aluno de uma determinada disciplina
	 * 
	 * @param id_aluno
	 * @param id_disciplina
	 * @return
	 */
	public double NotaFinal(int id_aluno, int id_disciplina) throws DAOException {
		double somaNotas = 0;
		double mediaFinal = 0;
		List<Nota> notas = notasDisciplinaAluno(id_aluno, id_disciplina);
		if (notas.size() >= 4) {
			for (Nota n : notas) {
				somaNotas += n.getMedia();
				mediaFinal = somaNotas / 4;
			}
			return mediaFinal;
		} else {
			throw new DAOException(
					"Não é possível emitir nota final,preencha antes todas as notas de todas as unidades!");
		}
	}

	public double NotaRecuperacao(int id_aluno, int id_disciplina) throws DAOException {
		try {
			Query query = em.createQuery(
					"SELECT n.nota_recupecao FROM Nota n WHERE n.id_aluno = :aluno AND n.id_disciplina = :disciplina",
					Nota.class);
			query.setParameter("aluno", id_aluno);
			query.setParameter("disciplina", id_disciplina);
			return (double) query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao emitir nota da recuperação!");
		} finally {
			em.clear();
		}
	}

	public List<Unidades> unidades() throws GeralException {
		try {
			List<Unidades> unidades = Arrays.asList(Unidades.values());
			return unidades;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException("Erro ao listar Unidades!");
		}
	}

	/**
	 * Lista Notas de uma determinada disciplina de um aluno
	 */
	@SuppressWarnings({ "rawtypes" })
	public List<Nota> notasDisciplinaAluno(int id_aluno, int id_disciplina) {
		try {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Nota> criteriaQuery = criteriaBuilder.createQuery(Nota.class);
			Root<Nota> nota = criteriaQuery.from(Nota.class);
			Join joinDisciplina = nota.join("disciplina");
			Join joinAluno = nota.join("aluno");
			criteriaQuery.where(criteriaBuilder.equal(joinDisciplina.get("id"), id_disciplina),
					criteriaBuilder.equal(joinAluno.get("id"), id_aluno));
			TypedQuery<Nota> typedQuery = em.createQuery(criteriaQuery);
			return (List<Nota>) typedQuery.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * Verifica se já existe uma nota preenchida naquela unidade.
	 * 
	 * @param id_aluno
	 * @param id_disciplina
	 * @param unidade
	 * @return
	 */
	public Nota notaUnidadeExistente(int id_aluno, int id_disciplina, String unidade) {
		try {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Nota> criteriaQuery = criteriaBuilder.createQuery(Nota.class);
			Root<Nota> nota = criteriaQuery.from(Nota.class);
			@SuppressWarnings("rawtypes")
			Join joinDisciplina = nota.join("disciplina");
			@SuppressWarnings("rawtypes")
			Join joinAluno = nota.join("aluno");
			criteriaQuery.where(criteriaBuilder.equal(joinDisciplina.get("id"), id_disciplina),
					criteriaBuilder.equal(joinAluno.get("id"), id_aluno),
					criteriaBuilder.equal(nota.get("unidade"), unidade));
			TypedQuery<Nota> typedQuery = em.createQuery(criteriaQuery);
			return (Nota) typedQuery.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
