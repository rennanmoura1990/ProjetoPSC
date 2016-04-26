package negocio;

import dao.IDAOAluno;
import exception.DAOException;

public class RNAluno {
	IDAOAluno daoaluno;
	/**
	 * Verifica se a sala tem mais de 40 alunos
	 * @param id_turma
	 * @return
	 * @throws DAOException
	 */
	public boolean VerificaSala(int id_turma) throws DAOException {
		boolean verifica = true;
		long qtd = this.daoaluno.QtdAlunoTurma(id_turma);
		if (qtd > 40) {
			verifica = false;
		}
		return verifica;
	}
}
