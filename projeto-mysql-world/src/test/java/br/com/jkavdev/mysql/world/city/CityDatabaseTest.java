package br.com.jkavdev.mysql.world.city;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.cidade.modelos.Country;
import br.com.jkavdev.mysql.world.config.AbstractDatabaseConfig;

public class CityDatabaseTest extends AbstractDatabaseConfig {

	@Test
	public void initCity() {

	}

	@Test
	public void buscarCountry() {
		List<Country> entities = getEntityManager().createQuery("from Country", Country.class).getResultList();

		for (Country someEntity : entities) {
			System.out.println(someEntity.getCode());
			System.out.println(someEntity.getContinent().getDescription());
		}
	}

}
