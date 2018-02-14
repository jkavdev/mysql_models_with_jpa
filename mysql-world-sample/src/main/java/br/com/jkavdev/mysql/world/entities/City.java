package br.com.jkavdev.mysql.world.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.immutables.builder.Builder;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "city")
public class City {

	//ainda a analisar, @Builder.Factory criara um builder do tipo
	@Builder.Factory
	public static City city(Country country, String name, String district, Integer population) {
		return new City(country, name, district, population);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "CountryCode")
	private Country country;

	private String name;

	private String district;

	private Integer population;

	private City() {
	}

	private City(Country country, String name, String district, Integer population) {
		//aplicando fail fast, se for pra da pau, da logo, kkk
		checkNotNull(country);
		checkNotNull(name);
		checkNotNull(district);
		checkNotNull(population);
		this.country = country;
		this.name = name;
		this.district = district;
		this.population = population;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass())
				.add("name", name)
				.add("district", district)
				.add("population", population)
				.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		City other = (City) obj;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
