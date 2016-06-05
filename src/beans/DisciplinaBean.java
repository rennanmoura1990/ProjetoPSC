package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import exception.DAOException;
import exception.GeralException;
import fachada.Fachada;
import fachada.IFachada;
import model.Disciplina;
import model.Professor;
import model.Turma;
import model.enums.Dias_semana;
import model.enums.Horarios;

@ManagedBean
@SessionScoped
public class DisciplinaBean {

	private Disciplina disciplina;
	private List<Disciplina> disciplinas;
	private int diaSemanaId;
	private String diaSemana;
	private List<Dias_semana> diasSemana;
	private int horarioId;
	private String horario;
	private List<Horarios> horarios;
	private int professorId;
	private Professor professor;
	private List<Professor> professores;
	private int turmaId;
	private Turma turma;
	private List<Turma> turmas;
	private IFachada fachada;
	private Horarios horarioEnum;
	private Dias_semana diasSemanaEnum;

	public DisciplinaBean() {
		this.disciplina = new Disciplina();
		this.disciplinas = new ArrayList<Disciplina>();
		this.diasSemana = new ArrayList<Dias_semana>();
		this.horarios = new ArrayList<Horarios>();
		this.professor = new Professor();
		this.professores = new ArrayList<Professor>();
		this.turma = new Turma();
		this.turmas = new ArrayList<Turma>();
		this.fachada = new Fachada();
	}

	public void cadastrarDisciplina() throws DAOException {
		try {
			Turma t = fachada.buscarIdTurma(turmaId);
			disciplina.setTurma(t);
			Professor p = fachada.buscarIdProfessor(professorId);
			disciplina.setProfessor(p);
			horario = horarios.get(horarioId-1).getHorario();
			disciplina.setHorario(horario);
			diaSemana = diasSemana.get(diaSemanaId-1).getDiasemana();
			disciplina.setDiaSemana(diaSemana);
			fachada.inserirDisciplina(disciplina);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Cadastro Realizado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		disciplina = new Disciplina();
		turmaId = 0;
		professorId = 0;
	}

	public void editarDisciplina() throws DAOException {
		try {
			Turma t = fachada.buscarIdTurma(turmaId);
			disciplina.setTurma(t);
			Professor p = fachada.buscarIdProfessor(professorId);
			disciplina.setProfessor(p);
			horario = horarios.get(horarioId-1).getHorario();
			disciplina.setHorario(horario);
			diaSemana = diasSemana.get(diaSemanaId-1).getDiasemana();
			disciplina.setDiaSemana(diaSemana);
			fachada.alterarDisciplina(disciplina);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Edição Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		disciplina = new Disciplina();
		turmaId = 0;
		professorId = 0;
	}

	public void clear() {
		disciplina.setId(null);
		disciplina.setDiaSemana(null);
		disciplina.setHorario(null);
		disciplina.setNomeDisciplina(null);
		disciplina.setProfessor(null);
		disciplina.setTurma(null);
		horario = null;
		diaSemana = null;
	}

	public void excluir() throws DAOException {
		try {
			fachada.excluirDisciplina(disciplina.getId());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Exclusão Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		disciplina = new Disciplina();
	}

	public String menuPrincipal() {
		return "/menuprincipal?faces-redirect=true";
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getDisciplinas() throws DAOException {
		disciplinas = fachada.listaDisciplina();
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public List<Dias_semana> getDiasSemana() throws GeralException {
		diasSemana = fachada.diasSemana();
		return diasSemana;
	}

	public void setDiasSemana(List<Dias_semana> diasSemana) {
		this.diasSemana = diasSemana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Horarios> getHorarios() throws GeralException {
		horarios = fachada.horarios();
		return horarios;
	}

	public void setHorarios(List<Horarios> horarios) {
		this.horarios = horarios;
	}

	public int getProfessorId() {
		professorId = (disciplina.getProfessor() != null) ? disciplina.getProfessor().getId() : 0;
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() throws DAOException {
		professores = fachada.listaProfessor();
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public int getTurmaId() {
		turmaId = (disciplina.getTurma() != null) ? disciplina.getTurma().getId() : 0;
		return turmaId;
	}

	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() throws DAOException {
		turmas = fachada.listaTurma();
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public int getHorarioId() throws GeralException {
		return horarioId;
	}

	public void setHorarioId(int horarioId) {
		this.horarioId = horarioId;
	}

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public int getDiaSemanaId() {
		return diaSemanaId;
	}

	public void setDiaSemanaId(int diaSemanaId) {
		this.diaSemanaId = diaSemanaId;
	}

	public Horarios getHorarioEnum() {
		return horarioEnum;
	}

	public void setHorarioEnum(Horarios horarioEnum) {
		this.horarioEnum = horarioEnum;
	}

	public Dias_semana getDiasSemanaEnum() {
		return diasSemanaEnum;
	}

	public void setDiasSemanaEnum(Dias_semana diasSemanaEnum) {
		this.diasSemanaEnum = diasSemanaEnum;
	}

}
