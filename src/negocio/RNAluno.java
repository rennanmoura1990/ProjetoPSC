package negocio;

import dao.DAOAluno;
import dao.DAOTurma;
import dao.IDAOAluno;
import dao.IDAOTurma;
import exception.DAOException;
import model.enums.*;

public class RNAluno {
	IDAOAluno daoaluno;
	IDAOTurma daoturma;
		
		public RNAluno(){
			daoaluno = new DAOAluno();
			daoturma = new DAOTurma();
		}

	/**
	 * Verifica se a sala tem mais de 40 alunos
	 * 
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
	/**
	 * Verifica porcentagem de faltas de um aluno,se acima de 25% ele é considerado reprovado por falta
	 * @param id_aluno
	 * @param id_turma
	 * @return
	 * @throws DAOException
	 */
	public String VerificaPorcentagemFalta(int id_aluno, int id_turma) throws DAOException {
		String mensagem = null;
		int faltas = this.daoaluno.NumeroFaltas(id_aluno);
		int aulas = this.daoturma.PegarAulasTotais(id_turma);
		double porcentagem = (faltas / aulas) * 100;
		if (porcentagem > 25) {
			
			mensagem = Double.toString(porcentagem)+"% => "+Status.REPROVADO_PORFALTA.getStatus();
		}else{
			mensagem = Double.toString(porcentagem)+"% - OK";
		}
		return mensagem;
	}
}
