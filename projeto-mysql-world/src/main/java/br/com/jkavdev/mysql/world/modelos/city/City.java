package br.com.jkavdev.mysql.world.modelos.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.jkavdev.mysql.world.modelos.country.Country;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int(11)")
	private Integer id;
	@Column(name = "Name", columnDefinition = "char(45)", nullable = false)
	private String name;
	@Column(name = "District", columnDefinition = "char(35)", nullable = false)
	private String district;
	@Column(name = "Population", columnDefinition = "int(11)", nullable = false)
	private Integer population;

	@ManyToOne
	@JoinColumn(name = "CountryCode", columnDefinition = "char(3)", foreignKey = @ForeignKey(name = "fk_city_country"))
	private Country country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

}
