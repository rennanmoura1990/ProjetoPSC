package negocio;

import dao.DAONota;
import dao.IDAONota;
import exception.DAOException;
import model.enums.Status;

public class RNNota {
	IDAONota daonota;

	public RNNota() {
		daonota = new DAONota();
	}

	public String notaFinal(int id_aluno, int id_disciplina) throws DAOException {
		String status;
		double nota_final = this.daonota.NotaFinal(id_aluno, id_disciplina);
		if (nota_final >= 7.0) {
			status = Status.APROVADO_PORNOTA.getStatus();
		} else {
			status = Status.RECUPERACAO.getStatus();
		}
		return status;
	}

	public String notaRecuperacao(int id_aluno, int id_disciplina) throws DAOException {
		String status;
		double recuperacao = this.daonota.NotaRecuperacao(id_aluno, id_disciplina);
		double nota_final = this.daonota.NotaFinal(id_aluno, id_disciplina);
		double soma = nota_final + recuperacao;
		if (soma >= 10) {
			status = Status.APROVADO_PORNOTA.getStatus();
		} else {
			status = Status.REPROVADO_PORNOTA.getStatus();
		}
		return status;
	}

	public boolean ValidaNota(double nota) throws Exception {
		try {
			if (nota > 0 || nota < 10) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("A nota deve ser maior que 0 e menor que 10!");
		}
		return false;
	}
}
