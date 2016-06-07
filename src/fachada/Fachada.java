package fachada;

import java.util.List;

import exception.DAOException;
import exception.GeralException;
import model.Aluno;
import model.Coordenador;
import model.Disciplina;
import model.Nota;
import model.Professor;
import model.Secretaria;
import model.Telefones;
import model.Turma;
import model.Usuario;
import model.enums.Dias_semana;
import model.enums.Horarios;
import model.enums.TiposUsuarios;
import model.enums.Unidades;
import negocio.RNAluno;
import negocio.RNCoordenador;
import negocio.RNDisciplina;
import negocio.RNNota;
import negocio.RNProfessor;
import negocio.RNSecretaria;
import negocio.RNTelefones;
import negocio.RNTurma;
import negocio.RNUsuario;

public class Fachada implements IFachada {

	RNAluno rna = new RNAluno();
	RNCoordenador rnc = new RNCoordenador();
	RNDisciplina rnd = new RNDisciplina();
	RNNota rnn = new RNNota();
	RNProfessor rnp = new RNProfessor();
	RNSecretaria rns = new RNSecretaria();
	RNTelefones rnt = new RNTelefones();
	RNTurma rntu = new RNTurma();
	RNUsuario rnu = new RNUsuario();

	@Override
	public void inserirAluno(Aluno a) throws GeralException, DAOException {
		// TODO Auto-generated method stub
		rna.verificaObjeto(a);
		rna.validaRegistro(a);
		rna.registroNovoAluno(a);
		rna.inserir(a);
	}

	@Override
	public void alterarAluno(Aluno a) throws GeralException, DAOException {
		// TODO Auto-generated method stub
		rna.verificaObjeto(a);
		rna.validaRegistro(a);
		rna.registroExistente(a);
		rna.alterar(a);
	}

	@Override
	public void excluirAluno(int id) throws DAOException {
		// TODO Auto-generated method stub
		rna.buscaID(id);
		rna.excluir(id);
	}

	@Override
	public Aluno buscarIdAluno(int id) throws DAOException {
		// TODO Auto-generated method stub
		Aluno a = rna.buscaID(id);
		return a;
	}

	@Override
	public List<Aluno> listaAluno() throws DAOException {
		// TODO Auto-generated method stub
		List<Aluno> alunos = rna.listarTudo();
		return alunos;
	}

	@Override
	public Aluno buscaAlunoNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		Aluno a = rna.buscaAlunoNome(nome);
		return a;
	}

	@Override
	public int NumeroFaltas(int id) throws DAOException {
		// TODO Auto-generated method stub
		return rna.NumeroFaltas(id);
	}

	@Override
	public void LancaFalta(Aluno a) throws DAOException {
		// TODO Auto-generated method stub
		rna.LancaFalta(a);
	}

	public List<Aluno> listaAlunoporTurma(int id_turma) throws GeralException {
		return rna.listaAlunoPorTurma(id_turma);
	}

	@Override
	public void inserirCoordenador(Coordenador c) throws DAOException {
		// TODO Auto-generated method stub
		rnc.verificaObjeto(c);
		rnc.validaRegistro(c);
		rnc.novoRegistro(c);
		rnc.inserir(c);
	}

	@Override
	public void alterarCoordenador(Coordenador c) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnc.verificaObjeto(c);
		rnc.validaRegistro(c);
		rnc.registroExistente(c);
		rnc.alterar(c);
	}

	@Override
	public void excluirCoordenador(int id) throws DAOException {
		// TODO Auto-generated method stub
		rnc.buscarId(id);
		rnc.excluir(id);
	}

	@Override
	public Coordenador buscarIdCoordenador(int id) throws DAOException {
		// TODO Auto-generated method stub
		Coordenador c = rnc.buscarId(id);
		return c;
	}

	@Override
	public List<Coordenador> listaCoordenador() throws DAOException {
		// TODO Auto-generated method stub
		return rnc.listarTudo();
	}

	@Override
	public Coordenador buscaCoordenadorNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		Coordenador c = rnc.buscaCoordenador(nome);
		return c;
	}

	@Override
	public void inserirDisciplina(Disciplina d) throws DAOException {
		// TODO Auto-generated method stub
		rnd.verificarObjeto(d);
		rnd.validaRegistro(d);
		rnd.novoRegistro(d);
		rnd.inserir(d);
	}

	@Override
	public void alterarDisciplina(Disciplina d) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnd.verificarObjeto(d);
		rnd.validaRegistro(d);
		rnd.registroExistente(d);
		rnd.alterar(d);
	}

	@Override
	public Disciplina buscarIdDisciplina(int id) throws DAOException {
		// TODO Auto-generated method stub
		Disciplina d = rnd.buscaID(id);
		return d;
	}

	@Override
	public List<Disciplina> listaDisciplina() throws DAOException {
		// TODO Auto-generated method stub
		return rnd.listarTudo();
	}

	@Override
	public Disciplina buscaDisciplinaNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		Disciplina d = rnd.buscaDisciplina(nome);
		return d;
	}

	@Override
	public List<Horarios> horarios() throws GeralException {
		// TODO Auto-generated method stub
		return rnd.horarios();
	}

	@Override
	public List<Dias_semana> diasSemana() throws GeralException {
		// TODO Auto-generated method stub
		return rnd.diasSemana();
	}

	public List<Disciplina> listaDisciplinaPorProfessor(int id_professor) throws GeralException {
		return rnd.listaDisciplinaPorProfessor(id_professor);
	}
	
	public List<Disciplina> listarDisciplinaAtivas(){
		return rnd.listarDisciplinaAtivas();
	}

	@Override
	public void inserirNota(Nota n) throws GeralException, DAOException {
		// TODO Auto-generated method stub
		rnn.validaNotaIntegrantes(n);
		rnn.validaNota(n.getNota1());
		rnn.validaNota(n.getNota2());
		rnn.inserir(n);
	}

	@Override
	public void alterarNota(Nota n) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnn.verificarObjeto(n);
		rnn.validaNotaIntegrantes(n);
		rnn.validaNota(n.getNota1());
		rnn.validaNota(n.getNota2());
		rnn.alterar(n);
	}

	@Override
	public void excluirNota(int id) throws DAOException {
		// TODO Auto-generated method stub
		rnn.buscarId(id);
		rnn.excluir(id);
	}

	@Override
	public Nota buscarIdNota(int id) throws DAOException {
		// TODO Auto-generated method stub
		Nota n = rnn.buscarId(id);
		return n;
	}

	@Override
	public List<Nota> listaNota() throws DAOException {
		// TODO Auto-generated method stub
		return rnn.listaTudo();
	}

	@Override
	public String NotaFinal(int id_aluno, int id_disciplina) throws DAOException {
		// TODO Auto-generated method stub
		return rnn.notaFinalResultado(id_aluno, id_disciplina);
	}

	@Override
	public String NotaRecuperacao(int id_aluno, int id_disciplina) throws DAOException {
		// TODO Auto-generated method stub
		return rnn.notaRecuperacaoResultado(id_aluno, id_disciplina);
	}

	@Override
	public List<Unidades> unidades() throws GeralException {
		// TODO Auto-generated method stub
		return rnn.unidades();
	}

	@Override
	public void inserirProfessor(Professor p) throws GeralException, DAOException {
		// TODO Auto-generated method stub
		rnp.verificaObjeto(p);
		rnp.validaRegistro(p);
		rnp.registroNovoProfessor(p);
		rnp.inserir(p);
	}

	@Override
	public void alteraProfessor(Professor p) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnp.verificaObjeto(p);
		rnp.validaRegistro(p);
		rnp.registroExistente(p);
		rnp.alterar(p);
	}

	@Override
	public Professor buscarIdProfessor(int id) throws DAOException {
		// TODO Auto-generated method stub
		Professor p = rnp.buscaID(id);
		return p;
	}

	@Override
	public List<Professor> listaProfessor() throws DAOException {
		// TODO Auto-generated method stub
		return rnp.listarTudo();
	}

	@Override
	public Professor buscaProfessorNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		Professor p = rnp.buscaProfessor(nome);
		return p;
	}

	public List<Professor> listarProfessoresAtivos() {
		return rnp.listarProfessoresAtivos();
	}

	@Override
	public void inserirSecretaria(Secretaria s) throws DAOException {
		// TODO Auto-generated method stub
		rns.verificarObjeto(s);
		rns.validaRegistro(s);
		rns.novoRegistro(s);
		rns.inserir(s);
	}

	@Override
	public void alteraSecretaria(Secretaria s) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rns.verificarObjeto(s);
		rns.validaRegistro(s);
		rns.registroExistente(s);
		rns.alterar(s);
	}

	@Override
	public void excluirSecretaria(int id) throws DAOException {
		// TODO Auto-generated method stub
		rns.buscarId(id);
		rns.excluir(id);
	}

	@Override
	public Secretaria buscarIdSecretaria(int id) throws DAOException {
		// TODO Auto-generated method stub
		Secretaria s = rns.buscarId(id);
		return s;
	}

	@Override
	public List<Secretaria> listaSecretaria() throws DAOException {
		// TODO Auto-generated method stub
		return rns.listarTudo();
	}

	@Override
	public Secretaria buscaSecretariaNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		Secretaria s = rns.buscaSecretaria(nome);
		return s;
	}

	@Override
	public void inserirTelefone(Telefones t) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnt.verificaObjeto(t);
		rnt.validaRegistro(t);
		rnt.inserir(t);
	}

	@Override
	public void alteraTelefone(Telefones t) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnt.verificaObjeto(t);
		rnt.validaRegistro(t);
		rnt.alterar(t);
	}

	@Override
	public void excluirTelefone(int id) throws DAOException {
		// TODO Auto-generated method stub
		rnt.buscaID(id);
		rnt.excluir(id);
	}

	@Override
	public Telefones buscarIdTelefone(int id) throws DAOException {
		// TODO Auto-generated method stub
		Telefones t = rnt.buscaID(id);
		return t;
	}

	@Override
	public List<Telefones> listaTelefones() throws DAOException {
		// TODO Auto-generated method stub
		return rnt.listarTudo();
	}

	@Override
	public Telefones buscaTelefonesUsuario(int pessoa_id, String telefone) throws DAOException {
		// TODO Auto-generated method stub
		Telefones t = rnt.buscaTelefonesUsuario(pessoa_id, telefone);
		return t;
	}

	public List<Telefones> listaTelefonesPessoa(int pessoa_id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirTurma(Turma t) throws DAOException, GeralException {
		rntu.verificaObjeto(t);
		rntu.validaRegistro(t);
		rntu.registroNovoTurma(t);
		rntu.inserir(t);
	}

	@Override
	public void alteraTurma(Turma t) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rntu.verificaObjeto(t);
		rntu.validaRegistro(t);
		rntu.registroExistente(t);
		rntu.alterar(t);
	}

	@Override
	public Turma buscarIdTurma(int id) throws DAOException {
		// TODO Auto-generated method stub
		Turma t = rntu.buscaID(id);
		return t;
	}

	@Override
	public List<Turma> listaTurma() throws DAOException {
		// TODO Auto-generated method stub
		return rntu.listarTudo();
	}

	@Override
	public Turma buscaTurmaNome(String nome) throws DAOException {
		// TODO Auto-generated method stub
		Turma t = rntu.buscaTurma(nome);
		return t;
	}

	public List<Turma> listarTurmasAtivas() {
		return rntu.listarTurmasAtivas();
	}

	@Override
	public void inserirUsuario(Usuario u) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnu.verificaObjeto(u);
		rnu.validaRegistro(u);
		rnu.registroNovoUsuario(u);
		rnu.inserir(u);
	}

	@Override
	public void alteraUsuario(Usuario u) throws DAOException, GeralException {
		// TODO Auto-generated method stub
		rnu.verificaObjeto(u);
		rnu.validaRegistro(u);
		rnu.registroExistente(u);
		rnu.inserir(u);
	}

	@Override
	public void excluirUsuario(int id) throws DAOException {
		// TODO Auto-generated method stub
		rnu.buscaID(id);
		rnu.excluir(id);
	}

	@Override
	public Usuario buscarIdUsuario(int id) throws DAOException {
		// TODO Auto-generated method stub
		Usuario u = rnu.buscaID(id);
		return u;
	}

	@Override
	public List<Usuario> listaUsuario() throws DAOException {
		// TODO Auto-generated method stub
		return rnu.listarTudo();
	}

	public Usuario fazerLogin(String login, String senha) throws DAOException {
		return rnu.fazerLogin(login, senha);
	}

	public List<TiposUsuarios> tiposUsuarios() throws GeralException {
		return rnu.tiposUsuarios();
	}

}
