package br.com.jkavdev.cidade.repositorios.hibernate;

import br.com.jkavdev.cidade.modelos.City;
import br.com.jkavdev.cidade.repositorios.CityDao;

public class HibernateCityDao extends HibernateGenericDao<City, Integer> implements CityDao {

	private static final long serialVersionUID = 1L;

}
