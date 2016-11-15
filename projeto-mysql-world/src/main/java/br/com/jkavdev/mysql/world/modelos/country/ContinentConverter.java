package br.com.jkavdev.mysql.world.modelos.country;

import javax.persistence.AttributeConverter;

public class ContinentConverter implements AttributeConverter<Continent, String> {

	@Override
	public String convertToDatabaseColumn(Continent attribute) {
		// Valor a ser inserido no banco será a descricao do enum
		return attribute.getDescription();
	}

	@Override
	public Continent convertToEntityAttribute(String dbData) {
		return Continent.fromDbValue(dbData);
	}
}
