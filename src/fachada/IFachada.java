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

public interface IFachada {

	public void inserirAluno(Aluno a) throws GeralException, DAOException;

	public void alterarAluno(Aluno a) throws GeralException, DAOException;

	public void excluirAluno(int id) throws DAOException;

	public Aluno buscarIdAluno(int id) throws DAOException;

	public List<Aluno> listaAluno() throws DAOException;

	public Aluno buscaAlunoNome(String nome) throws DAOException;

	public int NumeroFaltas(int id) throws DAOException;

	public void LancaFalta(Aluno a) throws DAOException;

	public List<Aluno> listaAlunoporTurma(int id_turma) throws GeralException;

	public void inserirCoordenador(Coordenador c) throws DAOException;

	public void alterarCoordenador(Coordenador c) throws DAOException, GeralException;

	public void excluirCoordenador(int id) throws DAOException;

	public Coordenador buscarIdCoordenador(int id) throws DAOException;

	public List<Coordenador> listaCoordenador() throws DAOException;

	public Coordenador buscaCoordenadorNome(String nome) throws DAOException;

	public void inserirDisciplina(Disciplina d) throws DAOException;

	public void alterarDisciplina(Disciplina d) throws DAOException, GeralException;

	public void excluirDisciplina(int id) throws DAOException;

	public Disciplina buscarIdDisciplina(int id) throws DAOException;

	public List<Disciplina> listaDisciplina() throws DAOException;

	public Disciplina buscaDisciplinaNome(String nome) throws DAOException;

	public List<Horarios> horarios() throws GeralException;

	public List<Dias_semana> diasSemana() throws GeralException;

	public List<Disciplina> listaDisciplinaPorProfessor(int id_professor) throws GeralException;

	public void inserirNota(Nota n) throws GeralException, DAOException;

	public void alterarNota(Nota n) throws DAOException, GeralException;

	public void excluirNota(int id) throws DAOException;

	public Nota buscarIdNota(int id) throws DAOException;

	public List<Nota> listaNota() throws DAOException;

	public String NotaFinal(int id_aluno, int id_disciplina) throws DAOException;

	public String NotaRecuperacao(int id_aluno, int id_disciplina) throws DAOException;

	public List<Unidades> unidades() throws GeralException;

	public void inserirProfessor(Professor p) throws GeralException, DAOException;

	public void alteraProfessor(Professor p) throws DAOException, GeralException;

	public void excluirProfessor(int id) throws DAOException;

	public Professor buscarIdProfessor(int id) throws DAOException;

	public List<Professor> listaProfessor() throws DAOException;

	public Professor buscaProfessorNome(String nome) throws DAOException;

	public void inserirSecretaria(Secretaria s) throws DAOException;

	public void alteraSecretaria(Secretaria s) throws DAOException, GeralException;

	public void excluirSecretaria(int id) throws DAOException;

	public Secretaria buscarIdSecretaria(int id) throws DAOException;

	public List<Secretaria> listaSecretaria() throws DAOException;

	public Secretaria buscaSecretariaNome(String nome) throws DAOException;

	public void inserirTelefone(Telefones t) throws DAOException, GeralException;

	public void alteraTelefone(Telefones t) throws DAOException, GeralException;

	public void excluirTelefone(int id) throws DAOException;

	public Telefones buscarIdTelefone(int id) throws DAOException;

	public List<Telefones> listaTelefones() throws DAOException;

	public Telefones buscaTelefonesUsuario(int pessoa_id, String telefone) throws DAOException;
	
	public List<Telefones> listaTelefonesPessoa(int pessoa_id) throws DAOException;

	public void inserirTurma(Turma t) throws DAOException, GeralException;

	public void alteraTurma(Turma t) throws DAOException, GeralException;

	public void excluirTurma(int id) throws DAOException;

	public Turma buscarIdTurma(int id) throws DAOException;

	public List<Turma> listaTurma() throws DAOException;

	public Turma buscaTurmaNome(String nome) throws DAOException;
	
	public List<Turma> listarTurmasAtivas();

	public void inserirUsuario(Usuario u) throws DAOException, GeralException;

	public void alteraUsuario(Usuario u) throws DAOException, GeralException;

	public void excluirUsuario(int id) throws DAOException;

	public Usuario buscarIdUsuario(int id) throws DAOException;

	public List<Usuario> listaUsuario() throws DAOException;

	public Usuario fazerLogin(String login, String senha) throws DAOException;

	public List<TiposUsuarios> tiposUsuarios() throws GeralException;

}
