package br.com.jkavdev.mysql.world.converters.jpa;

import javax.persistence.AttributeConverter;

import br.com.jkavdev.mysql.world.entities.Status;

public class LanguageStatusConverter implements AttributeConverter<Status, String> {

	@Override
	public String convertToDatabaseColumn(Status value) {
		return value.getValue();
	}

	@Override
	public Status convertToEntityAttribute(String dbData) {
		return Status.of(dbData);
	}

}
