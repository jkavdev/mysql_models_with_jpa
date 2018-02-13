package br.com.jkavdev.mysql.world.test.entities;

import org.junit.Test;

import br.com.jkavdev.mysql.world.entities.CountryLanguage;
import br.com.jkavdev.mysql.world.test.BaseTest;

public class CountryLanguageEntityTest extends BaseTest {
	
	@Test
	public void countryLanguageSelectTest() {
		//TODO: fazer a consulta em countrylanguage
		//manager.createQuery("select cl from CountryLanguage cl join fetch cl.id.country", CountryLanguage.class)
		
		getManager().createQuery("select language from Country cl join cl.languages language", CountryLanguage.class)
			.getResultList()
			.forEach(System.out::println);
	}
	
}
