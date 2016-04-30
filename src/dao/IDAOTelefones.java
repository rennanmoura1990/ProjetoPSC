package dao;

import exception.DAOException;
import model.Telefones;

public interface IDAOTelefones extends IDAOGenerico<Telefones>{
	public Telefones buscaTelefonesUsuario(int pessoa_id,String telefone) throws DAOException;
	public Telefones buscaTelefone(String telefone) throws DAOException;
}
