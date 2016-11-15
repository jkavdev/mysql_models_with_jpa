package br.com.jkavdev.mysql.world.modelos.language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.modelos.country.Country;

@Entity
@Table(name = "countrylanguage")
@IdClass(LanguagePK.class)
public class Language {

	@Id
	@Column(name = "Language", columnDefinition = "char(30)", nullable = false)
	private String language;

	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CountryCode", columnDefinition = "char(3)", foreignKey = @ForeignKey(name = "fk_language_country"))
	private Country countryCode;

	@Enumerated(EnumType.STRING)
	@Column(name = "IsOfficial", nullable = false, length = 2)
	private Official Official;
	@Column(name = "Percentage", precision = 4, scale = 1, nullable = false)
	private Float percentage;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Country getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Country country) {
		this.countryCode = country;
	}

	public Official getOfficial() {
		return Official;
	}

	public void setOfficial(Official official) {
		Official = official;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

}
