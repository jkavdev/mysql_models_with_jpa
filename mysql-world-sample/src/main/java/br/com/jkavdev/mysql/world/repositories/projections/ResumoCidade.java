package br.com.jkavdev.mysql.world.repositories.projections;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.jkavdev.mysql.world.entities.Continent;

public class ResumoCidade {

	private String countryName;

	private Continent continent;

	private String district;

	private String cityName;

	private Integer population;

	private String idiomaNativo;

	public ResumoCidade() {
	}

	public ResumoCidade(String countryName, Continent continent, String district, String cityName, Integer population,
			String idiomaNativo) {
		this.countryName = countryName;
		this.continent = continent;
		this.district = district;
		this.cityName = cityName;
		this.population = population;
		this.idiomaNativo = idiomaNativo;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getIdiomaNativo() {
		return idiomaNativo;
	}

	public void setIdiomaNativo(String idiomaNativo) {
		this.idiomaNativo = idiomaNativo;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
