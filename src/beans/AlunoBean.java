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
import model.Telefones;
import model.Turma;
import model.Usuario;
import model.enums.*;

@ManagedBean
@SessionScoped
public class AlunoBean {
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Status> status;
	private int turma;
	private String telefone;
	private List<String> telefones;
	private Telefones telefoneObj;
	private IFachada fachada;
	private List<Turma> turmas;
	private Usuario usuario;
	private List<Telefones> telefonesPessoa;
	private Usuario usuariologon = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
	private List<Disciplina> disciplinas;
	private List<Nota> notas;
	private int disciplinaId;
	private Disciplina disciplina;
	private Turma turmaObj;
	private int alunoId;
	private int turmaId;
	private Aluno alunologado;

	public AlunoBean() {
		this.aluno = new Aluno();
		this.alunos = new ArrayList<Aluno>();
		this.status = new ArrayList<Status>();
		this.turmas = new ArrayList<Turma>();
		this.telefones = new ArrayList<String>();
		this.telefoneObj = new Telefones();
		this.fachada = new Fachada();
		this.usuario = new Usuario();
		this.telefonesPessoa = new ArrayList<Telefones>();
		this.disciplinas = new ArrayList<Disciplina>();
		this.notas = new ArrayList<Nota>();
		this.disciplina = new Disciplina();
		this.turmaObj = new Turma();
		this.alunologado = new Aluno();
	}

	public void addTelefone() {
		telefones.add(telefone);
	}

	public void cadastrarAluno() throws GeralException, DAOException {
		try {
			Turma t = fachada.buscarIdTurma(turma);
			aluno.setTurma(t);
			fachada.inserirAluno(aluno);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(aluno);
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
		aluno = new Aluno();
		turma = 0;
	}

	public void clear() {
		aluno.setId(null);
		aluno.setNome(null);
		aluno.setCpf(null);
		aluno.setDtnasc(null);
		aluno.setMatricula(null);
		aluno.setRg(null);
		aluno.setTelefones(null);
		aluno.setTurma(null);
		telefone = null;
		telefones.clear();
	}

	public void edit() throws GeralException, DAOException {
		try {
			Turma t = fachada.buscarIdTurma(turma);
			aluno.setTurma(t);
			fachada.alterarAluno(aluno);
			for (String tel : telefones) {
				telefoneObj = new Telefones();
				telefoneObj.setPessoa(aluno);
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
		aluno = new Aluno();
		turma = 0;
	}

	public void excluir() throws DAOException {
		try {
			fachada.excluirAluno(aluno.getId());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Exclusão Realizada com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
		clear();
		aluno = new Aluno();
	}

	public void cadastrarUsuario() throws DAOException, GeralException {
		try {
			usuario.setTipoUsuario(TiposUsuarios.ALUNO.toString());
			usuario.setPessoa(aluno);
			fachada.inserirUsuario(usuario);
			clearUsuario();
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Informação: ", "Cadastro de Usuário Realizado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public void clearUsuario() {
		usuario.setLogin(null);
		usuario.setSenha(null);
	}

	public void editaTelefone() throws DAOException, GeralException {
		try {
			fachada.alteraTelefone(telefoneObj);
			telefoneObj = new Telefones();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Telefone editado com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public void excluirTelefone() throws DAOException {
		try {
			fachada.excluirTelefone(telefoneObj.getId());
			telefoneObj = new Telefones();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", "Telefone excluído com Sucesso!"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informação: ", e.getMessage()));
		}
	}

	public void DisciplinaChangeMethod(ValueChangeEvent e) throws GeralException, DAOException {
		notas = null;
		disciplinaId = 0;
		disciplina = null;
		alunoId = 0;
		aluno = null;
		turmaId = 0;
		disciplinaId = (e.getNewValue() != null) ? (int) e.getNewValue() : 0;
		disciplina = (disciplinaId > 0) ? fachada.buscarIdDisciplina(disciplinaId) : null;
		alunoId = usuariologon.getPessoa().getId();
		aluno = (alunoId > 0) ? fachada.buscarIdAluno(alunoId) : null;
		turmaId = (aluno != null) ? aluno.getTurma().getId() : null;
		notas = ((aluno != null) && (disciplina != null))
				? fachada.notasDisciplinaAluno(alunoId, disciplinaId) : null;
	}

	public String menuPrincipal() {
		return "/menuprincipal?faces-redirect=true";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() throws DAOException {
		alunos = fachada.listaAluno();
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public List<Turma> getTurmas() throws DAOException {
		turmas = fachada.listarTurmasAtivas();
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	// ele pega a turma do cadastrado,se não tiver,assume como 0
	public int getTurma() {
		turma = (aluno.getTurma() != null) ? aluno.getTurma().getId() : 0;
		return turma;
	}

	public void setTurma(int turma) {
		this.turma = turma;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Telefones getTelefoneObj() {
		return telefoneObj;
	}

	public void setTelefoneObj(Telefones telefoneObj) {
		this.telefoneObj = telefoneObj;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Telefones> getTelefonesPessoa() throws DAOException {
		telefonesPessoa = (aluno.getId() != null) ? fachada.listaTelefonesPessoa(aluno.getId()) : null;
		return telefonesPessoa;
	}

	public void setTelefonesPessoa(List<Telefones> telefonesPessoa) {
		this.telefonesPessoa = telefonesPessoa;
	}

	public Usuario getUsuariologon() {
		return usuariologon;
	}

	public void setUsuariologon(Usuario usuariologon) {
		this.usuariologon = usuariologon;
	}

	public List<Disciplina> getDisciplinas() throws DAOException {
		disciplinas = fachada.listarDisciplinaTurma(getTurmaObj().getId());
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public int getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurmaObj() {
		turmaObj = getAlunologado().getTurma();
		return turmaObj;
	}

	public void setTurmaObj(Turma turmaObj) {
		this.turmaObj = turmaObj;
	}

	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public int getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}

	public Aluno getAlunologado() {
		alunologado = (Aluno) usuariologon.getPessoa();
		return alunologado;
	}

	public void setAlunologado(Aluno alunologado) {
		this.alunologado = alunologado;
	}

}
