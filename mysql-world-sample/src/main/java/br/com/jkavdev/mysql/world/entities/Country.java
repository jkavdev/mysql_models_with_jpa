package br.com.jkavdev.mysql.world.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.immutables.builder.Builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.Sets;

import br.com.jkavdev.mysql.world.converters.jpa.ContinentConverter;

@Entity
@Table(name = "country")
@NamedQuery(name = Country.QUERY_FIND_BY_CONTINENT, query = "SELECT c FROM Country c WHERE c.continent = :" + Country.PARAM_CONTINENT)
public class Country {

	public static final String QUERY_FIND_BY_CONTINENT = "Country.findByContinent";
	public static final String PARAM_CONTINENT = "continent";

	@Builder.Factory
	public static Country country(String code, String name, Continent continent, String region, Float surfaceArea,
			Integer population, String localName, String governmentForm, String code2) {
		checkNotNull(code);
		checkNotNull(name);
		checkNotNull(continent);
		checkNotNull(region);
		checkNotNull(surfaceArea);
		checkNotNull(population);
		checkNotNull(localName);
		checkNotNull(governmentForm);
		checkNotNull(code2);
		return new Country(code, name, continent, region, surfaceArea, population, localName, governmentForm, code2);
	}

	@Id
	private String code;

	private String name;

	@Convert(converter=ContinentConverter.class)
	private Continent continent;

	private String region;

	private Float surfaceArea;

	private Integer IndepYear;

	private Integer population;

	private Float lifeExpectancy;

	private Float gnp;

	private Float gnpOld;

	private String localName;

	private String governmentForm;

	private String headOfState;

	private String capital;

	private String code2;

	@JsonIgnore // evitando lazy ao gerar json
	@ElementCollection
	@CollectionTable(
			name = "countrylanguage", 
			joinColumns={@JoinColumn(name = "countryCode", referencedColumnName="code")})
	private Set<CountryLanguage> languages = Sets.newLinkedHashSet();

	private Country() {
	}

	private Country(String code, String name, Continent continent, String region, Float surfaceArea, Integer population,
			String localName, String governmentForm, String code2) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.population = population;
		this.localName = localName;
		this.governmentForm = governmentForm;
		this.code2 = code2;
	}

	//rever gets, estao ai por causa da geracao do json, i dont need all of them, kkk
	//na verdade a maioria dos framerworks sao baseados em java beans, ai fica bem dificil, tem que gera-los
	//gerar um metodo que torne o estado do pais, em vez de expor tudo, vamos ver
	public Set<CountryLanguage> getLanguages() {
		return Collections.unmodifiableSet(languages);
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Continent getContinent() {
		return continent;
	}

	public String getRegion() {
		return region;
	}

	public Float getSurfaceArea() {
		return surfaceArea;
	}

	public Integer getIndepYear() {
		return IndepYear;
	}

	public Integer getPopulation() {
		return population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public Float getGnp() {
		return gnp;
	}

	public Float getGnpOld() {
		return gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public String getCapital() {
		return capital;
	}

	public String getCode2() {
		return code2;
	}
	
	public void adiciona(CountryLanguage language) {
		if(!languages.contains(language))
			languages.add(language);
	}
	
	@Override
	public String toString() {
		ToStringHelper helper = MoreObjects.toStringHelper(this)
			.add("code", code)
			.add("name", name)
			.add("continent", continent)
			.add("region", region)
			.add("surfaceArea", surfaceArea)
			.add("population", population)
			.add("localName", localName)
			.add("governmentForm", governmentForm)
			.add("code2", code2);
		return helper.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((code2 == null) ? 0 : code2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (code2 == null) {
			if (other.code2 != null)
				return false;
		} else if (!code2.equals(other.code2))
			return false;
		return true;
	}

}
