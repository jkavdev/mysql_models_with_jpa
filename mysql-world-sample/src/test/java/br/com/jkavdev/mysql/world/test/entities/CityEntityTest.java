package br.com.jkavdev.mysql.world.test.entities;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.mysql.world.entities.City;
import br.com.jkavdev.mysql.world.entities.CityBuilder;
import br.com.jkavdev.mysql.world.entities.Country;
import br.com.jkavdev.mysql.world.entities.Status;
import br.com.jkavdev.mysql.world.repositories.projections.ResumoCidade;
import br.com.jkavdev.mysql.world.test.BaseTest;

public class CityEntityTest extends BaseTest {
	
	@Test
	public void citySelectTest() {
		long millis = System.currentTimeMillis();
		
		getManager().createQuery("select c from City c "
				//agora precisamos trazer os relacionamentos devidos ao toString
				+ "join fetch c.country cc "
				+ "join fetch cc.languages language "
				,City.class)
			.setMaxResults(10)
			.getResultList()
			.forEach(System.out::println);
		
		millis = System.currentTimeMillis() - millis;
		System.out.println(millis);
	}
	
	
	@Test
	public void selectingACityBidirectionalProjection() {
		getManager().createQuery("select new br.com.jkavdev.mysql.world.repositories.projections"
				+ ".ResumoCidade(country.name, country.continent, c.district, c.name, c.population, cl.language)"
				+ " from City c"
				+ " inner join c.country country"
				+ " inner join country.languages cl"
				+ " where cl.status = :status", ResumoCidade.class)
			.setParameter("status", Status.OFFICIAL)
			.setMaxResults(3)
			.getResultList()
			.forEach(System.out::println);
	}
	
	@Test
	public void selectingACityWithoutBidirectionalProjection() {
		getManager().createQuery("select new br.com.jkavdev.mysql.world.repositories.projections"
				+ ".ResumoCidade(country.name, country.continent, c.district, c.name, c.population, cl.language)"
//				caso nao houvesse mapeamento bidirecional
				+ " from City c"
				+ " inner join c.country country"
				+ " inner join country.languages cl"
//				caso nao houvesse mapeamento bidirecional
				+ " where cl.status = :status", ResumoCidade.class)
		.setParameter("status", Status.OFFICIAL)
		.setMaxResults(3)
		.getResultList()
		.forEach(System.out::println);
	}
	
	@Test
	public void selectingNameAndPopulationOfACityScalarValues() {
		@SuppressWarnings("unchecked")
		List<Object[]> resultado = getManager().createQuery("select city.name, city.population from City city")
				.getResultList();
		
		for (Object[] objects : resultado) {
			System.out.println(objects[0] + " - " + objects[1]);
		}
	}
	
	@Test
	public void selectingACityWithFind() {
		//Ao utilizar o find o hibernate ja verifica o cache de 1 e 2 nivel, e atribui o valor da chave primaria
		//como parametro, evitando sql injection
		City city = getManager().find(City.class, 1);
		System.out.println(city);
	}
	
	@Test
	public void selectCitiesFromBrazil() {
		List<City> BrazilianCities = getManager().createQuery("from City where country.code = :countryCode", City.class)
			.setParameter("countryCode", "BRA")
			.getResultList();
		
		BrazilianCities.stream()
			.map(c -> c.getName())
			.forEach(System.out::println);
	}
	
	@Test
	public void createACity() {
		beginTransaction();
		Country brasil = getManager().find(Country.class, "BRA");
		
		City riachoFundo = new CityBuilder()
			.country(brasil)
			.district("DF")
			.name("Riacho Fundo")
			.population(12236)
			.build();
		getManager().persist(riachoFundo);
		
		City citySaved = getManager().createQuery("from City where name = :name", City.class)
			.setParameter("name", "Riacho Fundo")
			.getSingleResult();
		
		assertTrue(citySaved.equals(riachoFundo));
		commitTransaction();
	}
	
}
