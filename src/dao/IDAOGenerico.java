package dao;

import java.util.List;

import exception.DAOException;

public interface IDAOGenerico<T> {

	public void inserir(T t) throws DAOException;

	public void alterar(T t) throws DAOException;

	public void excluir(Class<T> objeto, int id) throws DAOException;

	public T buscarId(int id, Class<T> objeto) throws DAOException;

	public List<T> listaTudo(Class<T> objeto) throws DAOException;

}