package br.com.jkavdev.mysql.world.city;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.mysql.world.config.AbstractDatabaseConfig;
import br.com.jkavdev.mysql.world.modelos.country.Country;
import br.com.jkavdev.mysql.world.modelos.language.Language;

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
	
	@Test
	public void buscarLanguage() {
		List<Language> entities = getEntityManager().createQuery("select l from Language l join l.countryCode", Language.class).getResultList();

		for (Language someEntity : entities) {
			System.out.println(someEntity.getLanguage());
			System.out.println(someEntity.getOfficial().getDescription());
		}
	}

}
