package br.com.jkavdev.mysql.world.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

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
		return Objects.hash(district, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (!(obj instanceof City)) {
            return false;
        }
        City user = (City) obj;
        return Objects.equals(name, user.name) &&
                Objects.equals(district, user.district);
	}
	
}
