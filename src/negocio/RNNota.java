package negocio;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.DAONota;
import dao.IDAONota;
import exception.DAOException;
import exception.GeralException;
import model.Nota;
import model.enums.Status;
import model.enums.Unidades;

public class RNNota {
	IDAONota daonota;

	public RNNota() {
		daonota = new DAONota();
	}

	public void inserir(Nota n) throws DAOException {
		try {
			daonota.inserir(n);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public void alterar(Nota n) throws DAOException {
		try {
			daonota.alterar(n);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public void excluir(int id) throws DAOException {
		try {
			daonota.excluir(Nota.class, id);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public Nota buscarId(int id) throws DAOException {
		try {
			return daonota.buscarId(id, Nota.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public List<Nota> listaTudo() throws DAOException {
		try {
			return daonota.listaTudo(Nota.class);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public void validaNotaIntegrantes(Nota n) throws GeralException {
		if (n.getAluno() == null) {
			throw new GeralException("Nota precisa está vinculada a Aluno");
		}
		if (n.getDisciplina() == null) {
			throw new GeralException("Nota precisa está vinculada a Disciplina");
		}
		if (n.getUnidade() == null) {
			throw new GeralException("Nota precisa está vinculada a Unidade");
		}
	}

	public String notaFinalResultado(int id_aluno, int id_disciplina) throws DAOException {
		String status;
		double nota_final = this.daonota.NotaFinal(id_aluno, id_disciplina);
		if (nota_final >= 7.0) {
			status = Status.APROVADO_PORNOTA.getStatus();
		} else {
			status = Status.RECUPERACAO.getStatus();
		}
		return status;
	}

	public String notaRecuperacaoResultado(int id_aluno, int id_disciplina) throws DAOException {
		String status;
		double recuperacao = NotaFinal(id_aluno, id_disciplina);
		double nota_final = NotaRecuperacao(id_aluno, id_disciplina);
		double soma = nota_final + recuperacao;
		if (soma >= 10) {
			status = Status.APROVADO_PORNOTA.getStatus();
		} else {
			status = Status.REPROVADO_PORNOTA.getStatus();
		}
		return status;
	}

	public void validaNota(double nota) throws GeralException {
		if (nota < 0 || nota > 10) {
			throw new GeralException("A nota deve ser maior que 0 e menor que 10!");
		}
	}

	public double NotaFinal(int id_aluno, int id_disciplina) throws DAOException {
		try {
			return daonota.NotaFinal(id_aluno, id_disciplina);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public double NotaRecuperacao(int id_aluno, int id_disciplina) throws DAOException {
		try {
			return daonota.NotaRecuperacao(id_aluno, id_disciplina);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage());
		}
	}

	public List<Unidades> unidades() throws GeralException {
		try {
			return daonota.unidades();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new GeralException(e.getMessage());
		}
	}

	public void verificarObjeto(Nota n) throws DAOException {
		if (n == null)
			throw new DAOException("Dados inválidos!");
	}

	public List<Nota> notasDisciplinaAluno(int id_aluno, int id_disciplina) {
		return daonota.notasDisciplinaAluno(id_aluno, id_disciplina);
	}

	public void verificaNotalancadaUnidade(int id_aluno, int id_disciplina, String unidade) throws DAOException {
		if (daonota.notaUnidadeExistente(id_aluno, id_disciplina, unidade) != null)
			throw new DAOException("Já existe nota pra essa unidade!");
	}

}
