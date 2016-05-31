package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import exception.DAOException;
import exception.GeralException;
import fachada.Fachada;
import fachada.IFachada;
import model.Aluno;
import model.Telefones;
import model.Turma;
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

	public AlunoBean() {
		this.aluno = new Aluno();
		this.alunos = new ArrayList<Aluno>();
		this.status = new ArrayList<Status>();
		this.turmas = new ArrayList<Turma>();
		this.telefones = new ArrayList<String>();
		this.telefoneObj = new Telefones();
		this.fachada = new Fachada();
	}

	public void addTelefone() {
		telefones.add(telefone);
	}

	public void cadastrarAluno() throws GeralException, DAOException {
		Turma t = fachada.buscarIdTurma(turma);
		aluno.setTurma(t);
		fachada.inserirAluno(aluno);
		for (String tel : telefones) {
			telefoneObj = new Telefones();
			telefoneObj.setPessoa(aluno);
			telefoneObj.setTelefone(tel);
			fachada.inserirTelefone(telefoneObj);
		}
		aluno = new Aluno();
	}
	
	public void edit(Aluno a) throws GeralException, DAOException{
		Aluno alunoEdit = new Aluno();
		alunoEdit.setId(a.getId());
		alunoEdit.setCpf(a.getCpf());
		alunoEdit.setDtnasc(a.getDtnasc());
		alunoEdit.setMatricula(a.getMatricula());
		alunoEdit.setNome(a.getNome());
		alunoEdit.setRg(a.getRg());
		alunoEdit.setTelefones(a.getTelefones());
		alunoEdit.setTurma(a.getTurma());
		fachada.alterarAluno(alunoEdit);
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
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
		turmas = fachada.listaTurma();
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public int getTurma() {
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
}
