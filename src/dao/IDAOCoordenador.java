package dao;

import exception.DAOException;
import model.Coordenador;

public interface IDAOCoordenador extends IDAOGenerico<Coordenador>{
	public Coordenador buscaCoordenadorNome(String nome) throws DAOException;
}
