package br.com.jkavdev.mysql.world.test.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import br.com.jkavdev.mysql.world.entities.Continent;
import br.com.jkavdev.mysql.world.entities.Country;
import br.com.jkavdev.mysql.world.entities.CountryLanguage;
import br.com.jkavdev.mysql.world.entities.Country_;
import br.com.jkavdev.mysql.world.entities.LanguageBuilder;
import br.com.jkavdev.mysql.world.entities.Status;
import br.com.jkavdev.mysql.world.test.BaseTest;

public class CountryEntityTest extends BaseTest {
	
	@Test
	public void countrySelectTest() {
		getManager().createQuery("from Country", Country.class)
			.getResultList()
			.forEach(System.out::println);
	}
	
	@Test
	public void countrySelectNamedTest() {
		getManager().createNamedQuery(Country.QUERY_FIND_BY_CONTINENT, Country.class)
			.setParameter(Country.PARAM_CONTINENT, Continent.ANTARCTICA)
			.getResultList()
			.forEach(System.out::println);
	}
	
	@Test
	public void countryCriteriaSelectTest() {
		CriteriaBuilder builder = getManager().getCriteriaBuilder();
		CriteriaQuery<Country> query = builder.createQuery(Country.class);
		
		Root<Country> country = query.from(Country.class);
		query.select(country);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(builder.equal(country.get(Country_.continent), Continent.SOUTH_AMERICA));
		predicates.add(builder.greaterThan(country.get(Country_.population), 10000000));
		query.where(predicates.toArray(new Predicate[0]));
		
		List<Order> orders = new ArrayList<>();
		orders.add(builder.desc(country.get(Country_.population)));
		query.orderBy(orders);
		
		getManager().createQuery(query)
			.getResultList()
			.forEach(System.out::println);
	}
	
	@Test
	public void insertCountryWithLanguage() {
		beginTransaction();
		CountryLanguage language = new LanguageBuilder()
				.language("Português-Latino")
				.status(Status.UNOFFICIAL)
				.percentage(53f).build();
		Country brasil = getManager().createQuery("SELECT c FROM Country c JOIN FETCH c.languages where c.code = :code", Country.class)
			.setParameter("code", "BRA")
			.getSingleResult();
		brasil.adiciona(language);
		
		brasil.getLanguages().forEach(System.out::println);
		List<CountryLanguage> languages = getManager().createQuery("SELECT language FROM Country c JOIN c.languages language where c.code = :code", CountryLanguage.class)
				.setParameter("code", "BRA")
				.getResultList();
		
		assertEquals(brasil.getLanguages().size(), languages.size());
		
		commitTransaction();
	}

	@Test(expected=IllegalStateException.class)
	public void shouldFailOnCreateACountryLanguage() {
		new LanguageBuilder()
			.language("Muito massa")
			.percentage(15f)
			//tem que falhar
//			.status(Status.OFFICIAL)
			.build();
	}
	
	@Test
	public void shouldCreateACountryLanguage() {
		CountryLanguage language = new LanguageBuilder()
		.language("Muito massa")
		.percentage(15f)
		.status(Status.OFFICIAL)
		.build();
	}
}
