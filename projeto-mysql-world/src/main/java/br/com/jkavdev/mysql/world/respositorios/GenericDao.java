package br.com.jkavdev.mysql.world.respositorios;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> extends Serializable{

	public void salvar(T entidade);

	public void alterar(T entidade);

	public void remover(T entidade);

	public T buscarPorId(ID id);

	public List<T> buscarTodos();

}
