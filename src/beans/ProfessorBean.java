package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import exception.DAOException;
import exception.GeralException;
import fachada.Fachada;
import fachada.IFachada;
import model.Aluno;
import model.Disciplina;
import model.Nota;
import model.Professor;
import model.StatusDisciplina;
import model.Telefones;
import model.Turma;
import model.Usuario;
import model.enums.TiposUsuarios;
import model.enums.Unidades;

@ManagedBean
@SessionScoped
public class ProfessorBean extends Usuario {

	private Professor professor;
	private List<Professor> professores;
	private String telefone;
	private List<String> telefones;
	private Telefones telefoneObj;
	private IFachada fachada;
	private Usuario usuario;
	private List<Disciplina> disciplinas;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	private Aluno aluno;
	private int alunoid;
	private Turma turma;
	private int disciplinaid;
	private List<Nota> notasAluno;
	private Usuario usuariologin;
	/**
	 * Notas
	 */
	private Nota nota;
	private int unidadeID;
	private List<Unidades> unidades;
	private String unidadeNome;
	private StatusDisciplina statusdisciplina;

	public ProfessorBean() {
		this.professor = new Professor();
		this.professores = new ArrayList<Professor>();
		this.telefones = new ArrayList<String>();
		this.telefoneObj = new Telefones();
		this.fachada = new Fachada();
		this.usuario = new Usuario();
		this.disciplinas = new ArrayList<Disciplina>();
		this.disciplina = new Disciplina();
		this.alunos = new ArrayList<Aluno>();
		this.aluno = new Aluno();
		this.turma = new Turma();
		this.nota = new Nota();
		this.unidades = new ArrayList<Unidades>();
		this.notasAluno = new ArrayList<Nota>();
		this.usuariologin = new Usuario();
		this.statusdisciplina = new StatusDisciplina();
	}

	public void addTelefone() {
		telefones.add(telefone);
	}

	public void cadastrarProfessor() throws GeralException, DAOException {
		try {
			professor.setProfessorAtivo("S");
			fachada.inserirProfessor(professor);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(professor);
				telefoneObj.setTelefone(tel);
				fachada.inserirTelefone(telefoneObj);
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Cadastro Realizado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		professor = new Professor();
	}

	public void clear() {
		professor.setId(null);
		professor.setNome(null);
		professor.setCpf(null);
		professor.setDtnasc(null);
		professor.setRg(null);
		professor.setTelefones(null);
		telefone = null;
		telefones.clear();
	}

	public void editarProfessor() throws GeralException, DAOException {
		try {
			fachada.alteraProfessor(professor);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(professor);
				telefoneObj.setTelefone(tel);
				fachada.alteraTelefone(telefoneObj);
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Edição Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		professor = new Professor();
	}

	public void excluirProfessor() throws DAOException {
		try {
			professor.setProfessorAtivo("N");
			fachada.alteraProfessor(professor);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Exclusão Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		professor = new Professor();
	}

	/**
	 * A mudar a disciplina,ele refaz a tabela com os alunos daquela disciplina
	 * de tal turma.
	 * 
	 * @param e
	 * @throws GeralException
	 * @throws DAOException
	 */
	public void valueChangeMethod(ValueChangeEvent e) throws GeralException, DAOException {
		alunos = null;
		disciplinaid = (e.getNewValue() != null) ? (int) e.getNewValue() : 0;
		disciplina = fachada.buscarIdDisciplina(disciplinaid);
		alunos = (disciplina != null) ? fachada.listaAlunoporTurma(disciplina.getTurma().getId()) : null;
	}

	/**
	 * Lançamento de Nota
	 * 
	 * @throws DAOException
	 * @throws GeralException
	 */
	public void lancarNota() throws DAOException, GeralException {
		try {
			nota.setMedia((nota.getNota1() + nota.getNota2()) / 2);
			unidadeNome = unidades.get(unidadeID - 1).getUnidade();
			nota.setUnidade(unidadeNome);
			Disciplina d = fachada.buscarIdDisciplina(disciplinaid);
			nota.setDisciplina(d);
			nota.setAluno(aluno);
			fachada.inserirNota(nota);
			nota = new Nota();
			unidadeID = 0;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Informação: ", "Lançamento de Nota Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	/**
	 * Edição de Nota
	 * 
	 * @throws DAOException
	 * @throws GeralException
	 */
	public void editaNota() throws DAOException, GeralException {
		try {
			nota.setMedia((nota.getNota1() + nota.getNota2()) / 2);
			unidadeNome = unidades.get(unidadeID - 1).getUnidade();
			nota.setUnidade(unidadeNome);
			Disciplina d = fachada.buscarIdDisciplina(disciplinaid);
			nota.setDisciplina(d);
			nota.setAluno(aluno);
			fachada.alterarNota(nota);
			nota = new Nota();
			unidadeID = 0;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Informação: ", "Edição de Nota Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public void cadastrarUsuario() throws DAOException, GeralException {
		try {
			usuariologin.setTipoUsuario(TiposUsuarios.PROFESSOR.toString());
			usuariologin.setPessoa(professor);
			fachada.inserirUsuario(usuariologin);
			clearUsuario();
			usuariologin = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Informação: ", "Cadastro de Usuário Realizado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public void clearUsuario() {
		usuariologin.setLogin(null);
		usuariologin.setSenha(null);
	}

	public void lancaFalta() throws DAOException {
		try {
			fachada.LancaFalta(aluno);
			String status = fachada.verificaPorcentagemFalta(aluno);
			aluno.setStatus(status);
			fachada.alterarAluno(aluno);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Falta Lançada,aluno agora tem : "
							+ aluno.getFaltas() + " faltas (" + aluno.getPorcentagem() + "%)"));
			aluno = new Aluno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public void gerarStatusNota() throws DAOException, GeralException {
		try {
			String status = fachada.NotaFinal(alunoid, disciplinaid);
			statusdisciplina.setStatus(status);
			statusdisciplina.setAluno(aluno);
			statusdisciplina.setDisciplina(disciplina);
			fachada.inserirStatus(statusdisciplina);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Informação: ", "Status : " + statusdisciplina.getStatus() + ""));
			aluno = new Aluno();
			statusdisciplina = new StatusDisciplina();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public String menuPrincipal() {
		return "/menuprincipal?faces-redirect=true";
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() throws DAOException {
		professores = fachada.listarProfessoresAtivos();
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public Telefones getTelefoneObj() {
		return telefoneObj;
	}

	public void setTelefoneObj(Telefones telefoneObj) {
		this.telefoneObj = telefoneObj;
	}

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public Usuario getUsuario() {
		usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Disciplina> getDisciplinas() throws GeralException {
		disciplinas = fachada.listaDisciplinaPorProfessor(usuario.getPessoa().getId());
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getAlunos() throws GeralException {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public int getDisciplinaid() {
		return disciplinaid;
	}

	public void setDisciplinaid(int disciplinaid) {
		this.disciplinaid = disciplinaid;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getAlunoid() {
		alunoid = (aluno.getId() != null) ? aluno.getId() : 0;
		return alunoid;
	}

	public void setAlunoid(int alunoid) {
		this.alunoid = alunoid;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public int getUnidadeID() {
		return unidadeID;
	}

	public void setUnidadeID(int unidadeID) {
		this.unidadeID = unidadeID;
	}

	public List<Unidades> getUnidades() throws GeralException {
		unidades = fachada.unidades();
		return unidades;
	}

	public void setUnidades(List<Unidades> unidades) {
		this.unidades = unidades;
	}

	public String getUnidadeNome() {
		return unidadeNome;
	}

	public void setUnidadeNome(String unidadeNome) {
		this.unidadeNome = unidadeNome;
	}

	public List<Nota> getNotasAluno() {
		notasAluno = ((aluno.getId() != null) && (disciplina != null))
				? fachada.notasDisciplinaAluno(aluno.getId(), disciplinaid) : null;
		return notasAluno;
	}

	public void setNotasAluno(List<Nota> notasAluno) {
		this.notasAluno = notasAluno;
	}

	public Usuario getUsuariologin() {
		return usuariologin;
	}

	public void setUsuariologin(Usuario usuariologin) {
		this.usuariologin = usuariologin;
	}

	public StatusDisciplina getStatusdisciplina() {
		return statusdisciplina;
	}

	public void setStatusdisciplina(StatusDisciplina statusdisciplina) {
		this.statusdisciplina = statusdisciplina;
	}

}
