package br.com.jkavdev.mysql.world.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jkavdev.mysql.world.entities.Country;

public class CountryRepository {

	@PersistenceContext
	private EntityManager manager;

	public List<Country> allCountries() {
		return manager.createQuery("from Country", Country.class).getResultList();
	}

}
