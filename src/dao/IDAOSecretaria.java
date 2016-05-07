package dao;

import exception.DAOException;
import model.Secretaria;

public interface IDAOSecretaria extends IDAOGenerico<Secretaria>{
	public Secretaria buscaSecretariaNome(String nome) throws DAOException;
}
