package dao;

import java.util.List;

import exception.DAOException;
import model.Telefones;

public interface IDAOTelefones extends IDAOGenerico<Telefones>{
	public Telefones buscaTelefonesUsuario(int pessoa_id,String telefone)throws DAOException;
	public Telefones buscaTelefone(String telefone)throws DAOException;;
	public List<Telefones> listaTelefonesPessoa(int pessoa_id)throws DAOException;;
}
