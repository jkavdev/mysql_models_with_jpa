package br.com.jkavdev.mysql.world.respositorios.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.jkavdev.mysql.world.respositorios.GenericDao;

public class HibernateGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	private Class<T> entidade;

	@SuppressWarnings("unchecked")
	public HibernateGenericDao() {
		this.entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void salvar(T entidade) {
		this.manager.merge(entidade);
	}

	@Override
	public void alterar(T entidade) {
		this.manager.merge(entidade);
	}

	@Override
	public void remover(T entidade) {
		this.manager.remove(entidade);
	}

	@Override
	public T buscarPorId(ID id) {
		return this.manager.find(entidade, id);
	}

	@SuppressWarnings("unused")
	@Override
	public List<T> buscarTodos() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(entidade);
		Root<T> root = criteriaQuery.from(entidade);

		return this.manager.createQuery(criteriaQuery).getResultList();
	}

	public EntityManager getManager() {
		return manager;
	}

}
