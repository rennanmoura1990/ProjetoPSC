package dao;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import exception.DAOException;
import model.Turma;

public class DAOTurma extends DAOGenerico<Turma> implements IDAOTurma{
	public int PegarAulasTotais(int id_turma) throws DAOException {
		int qtd = 0;
		try {
			Query query = em.createQuery("SELECT t.qtd_aulas FROM Turma t WHERE t.id = :id",Turma.class);
			query.setParameter("id", id_turma);
			qtd = (int) query.getSingleResult();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException("Erro ao obter a quantidade total de aulas");
		}
		return qtd;
	}
}
