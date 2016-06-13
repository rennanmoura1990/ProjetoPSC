package dao;

import model.StatusDisciplina;

public interface IDAOStatusDisciplina extends IDAOGenerico<StatusDisciplina> {
	public StatusDisciplina ExisteStatusDisciplina(int id_aluno, int id_disciplina);
}
