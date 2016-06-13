package dao;

import java.util.List;

import exception.DAOException;
import exception.GeralException;
import model.Nota;
import model.enums.Unidades;

public interface IDAONota extends IDAOGenerico<Nota>{
	public double NotaFinal(int id_aluno, int id_disciplina) throws DAOException;
	public double NotaRecuperacao(int id_aluno,int id_disciplina) throws DAOException;
	public List<Unidades> unidades() throws GeralException;
	public List<Nota> notasDisciplinaAluno(int id_aluno,int id_disciplina);
	public Nota notaUnidadeExistente(int id_aluno,int id_disciplina,String unidade);
}
