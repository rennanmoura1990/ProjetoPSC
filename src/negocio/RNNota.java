package negocio;

import dao.DAONota;
import dao.IDAONota;
import exception.DAOException;
import model.enums.Status;

public class RNNota {
	IDAONota daonota;
	
	public RNNota(){
		daonota = new DAONota();
	}

	public String NotaFinal(int id_aluno, int id_disciplina) throws DAOException {
		String status;
		double nota_final = this.daonota.NotaFinal(id_aluno, id_disciplina);
		if (nota_final >= 7.0) {
			status = Status.APROVADO_PORNOTA.getStatus();
		} else {
			status = Status.RECUPERACAO.getStatus();
		}
		return status;
	}
	
	public String NotaRecuperacao(int id_aluno,int id_disciplina) throws DAOException{
		String status;
		double recuperacao =  this.daonota.NotaRecuperacao(id_aluno, id_disciplina);
		double nota_final = this.daonota.NotaFinal(id_aluno, id_disciplina);
		double soma = nota_final + recuperacao;
		if(soma >=10){
			status = Status.APROVADO_PORNOTA.getStatus();
		}else{
			status = Status.REPROVADO_PORNOTA.getStatus();
		}
		return status;
	}
}
