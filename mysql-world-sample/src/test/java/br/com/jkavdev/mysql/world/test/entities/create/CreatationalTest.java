package br.com.jkavdev.mysql.world.test.entities.create;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.mysql.world.entities.Continent;
import br.com.jkavdev.mysql.world.entities.Country;
import br.com.jkavdev.mysql.world.entities.CountryBuilder;

public class CreatationalTest {
	
	private Logger log = Logger.getLogger(Country.class);
	
	@Test(expected = NullPointerException.class)
	public void shouldFailCreateCountryWithBuilder() {
		
		new CountryBuilder()
			.code(null)
			.code2(null)
			.continent(null)
			.governmentForm(null)
			.localName(null)
			.name(null)
			.population(null)
			.region(null)
			.surfaceArea(null)
			.build();
			
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldFailCreateCountry() {
		
		Country.of(null, null, null, null, null, null, null, null, null);
		
	}
	
	@Test
	public void shouldCreateCountryWithBuilder() {
		
		Country country = new CountryBuilder()
								.code("IO")
								.code2("IOA")
								.continent(Continent.ANTARCTICA)
								.governmentForm("Metodico")
								.localName("Lugar frio")
								.name("Ativdd")
								.population(112222)
								.region("Cold place")
								.surfaceArea(223232222f)
								.build();
		
		log.debug(country);
		
	}
	
	@Test
	public void shouldCreateCountry() {
		
		Country country = Country.of("IO", "IOA", Continent.ANTARCTICA, "Metodico", 223232222f, 112222, "Ativdd", "Cold place", "Lugar frio");
		
		log.debug(country);
	}

}
