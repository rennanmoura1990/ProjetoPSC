package dao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import model.Aluno;

public class DAOAluno extends DAOGenerico<Aluno> {
	/**
	 * Retorna a quantidade de alunos de uma determinada turma
	 * @param turma_id
	 * @return
	 */
	public long QtdAlunoTurma(int turma_id){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
		Root aluno = criteriaQuery.from(Aluno.class);
		criteriaQuery.select(criteriaBuilder.count(aluno));
		Join turma = aluno.join("turma");
		criteriaQuery.where(criteriaBuilder.equal(turma.get("id_turma"),turma_id));
		Query query = em.createQuery(criteriaQuery);
		return (long) query.getSingleResult();
	}
}
