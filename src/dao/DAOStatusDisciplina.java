package dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import model.StatusDisciplina;

public class DAOStatusDisciplina extends DAOGenerico<StatusDisciplina> implements IDAOStatusDisciplina {

	@SuppressWarnings("rawtypes")
	public StatusDisciplina ExisteStatusDisciplina(int id_aluno, int id_disciplina) {
		try {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<StatusDisciplina> criteriaQuery = criteriaBuilder.createQuery(StatusDisciplina.class);
			Root<StatusDisciplina> statusdisciplina = criteriaQuery.from(StatusDisciplina.class);
			Join joinDisciplina = statusdisciplina.join("disciplina");
			Join joinAluno = statusdisciplina.join("aluno");
			criteriaQuery.where(criteriaBuilder.equal(joinDisciplina.get("id"), id_disciplina),
					criteriaBuilder.equal(joinAluno.get("id"), id_aluno));
			TypedQuery<StatusDisciplina> typedQuery = em.createQuery(criteriaQuery);
			return (StatusDisciplina) typedQuery.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
