package br.com.jkavdev.mysql.world.converters.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.jkavdev.mysql.world.entities.Continent;

@Converter(autoApply = true)
public class ContinentConverter implements AttributeConverter<Continent, String> {

	@Override
	public String convertToDatabaseColumn(Continent vehicle) {
		return vehicle.getDescription();
	}

	@Override
	public Continent convertToEntityAttribute(String dbData) {
		return Continent.of(dbData);
	}

}
