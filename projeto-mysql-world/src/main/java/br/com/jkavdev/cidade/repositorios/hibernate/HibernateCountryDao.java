package br.com.jkavdev.cidade.repositorios.hibernate;

import br.com.jkavdev.cidade.modelos.Country;
import br.com.jkavdev.cidade.repositorios.CountryDao;

public class HibernateCountryDao extends HibernateGenericDao<Country, Integer> implements CountryDao {

	private static final long serialVersionUID = 1L;

}
