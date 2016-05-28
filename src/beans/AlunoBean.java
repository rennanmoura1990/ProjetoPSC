package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.net.ssl.SSLEngineResult.Status;

import fachada.Fachada;
import fachada.IFachada;
import model.Aluno;

@ManagedBean
@SessionScoped
public class AlunoBean {
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Status> status;
	private IFachada fachada;

	public AlunoBean() {
		this.aluno = new Aluno();
		this.alunos = new ArrayList<Aluno>();
		this.fachada = new Fachada();
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
	
	
	
}
