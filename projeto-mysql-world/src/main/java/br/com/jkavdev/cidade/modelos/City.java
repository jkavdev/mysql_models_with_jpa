package br.com.jkavdev.cidade.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int(11)")
	private int id;
	@Column(name = "Name", columnDefinition = "char(35)", length = 35, nullable = false)
	private String name;
	@Column(name = "District", columnDefinition = "char(20)", length = 20, nullable = false)
	private String district;
	@Column(name = "Population", columnDefinition = "int(11)", nullable = false)
	private int population;

	@ManyToOne
	@JoinColumn(name = "CountryCode", columnDefinition = "char(3)")
	private Country country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}
