package br.com.jkavdev.mysql.world.modelos.country;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@Column(name = "Code", columnDefinition = "char(3)", nullable = false)
	private String code;
	@Column(name = "Name", columnDefinition = "char(52)", nullable = false)
	private String name;

	@Convert(converter = ContinentConverter.class)
	@Column(name = "Continent", nullable = false, length = 25)
	private Continent continent;

	@Column(name = "Region", columnDefinition = "char(26)", nullable = false)
	private String region;
	@Column(name = "SurfaceArea", precision = 10, scale = 2, nullable = false)
	private Float surfaceArea;
	@Column(name = "IndepYear", columnDefinition = "smallint(6)", nullable = true)
	private Integer indepYear;
	@Column(name = "Population", columnDefinition = "int(11)", nullable = false)
	private Integer population;
	@Column(name = "LifeExpectancy", precision = 3, scale = 1, nullable = true)
	private Float lifeExpectancy;
	@Column(name = "GNP", precision = 10, scale = 2, nullable = true)
	private Float gnp;
	@Column(name = "GNPOld", precision = 10, scale = 2, nullable = true)
	private Float gnpold;
	@Column(name = "LocalName", columnDefinition = "char(60)", nullable = false)
	private String localname;
	@Column(name = "GovernmentForm", columnDefinition = "char(45)", nullable = false)
	private String governmentForm;
	@Column(name = "HeadOfState", columnDefinition = "char(60)", nullable = true)
	private String headOfState;
	@Column(name = "Capital", columnDefinition = "int(11)", nullable = true)
	private Integer capital;
	@Column(name = "Code2", columnDefinition = "char(2)", nullable = false)
	private String code2;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Integer getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Integer indepYear) {
		this.indepYear = indepYear;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Float getGnp() {
		return gnp;
	}

	public void setGnp(Float gnp) {
		this.gnp = gnp;
	}

	public Float getGnpold() {
		return gnpold;
	}

	public void setGnpold(Float gnpold) {
		this.gnpold = gnpold;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

}
