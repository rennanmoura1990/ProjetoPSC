package dao;

import model.Secretaria;

public interface IDAOSecretaria extends IDAOGenerico<Secretaria>{
	public Secretaria buscaSecretariaNome(String nome);
}
