package br.com.jkavdev.mysql.world.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import org.immutables.builder.Builder;

import com.google.common.base.MoreObjects;

import br.com.jkavdev.mysql.world.converters.jpa.LanguageStatusConverter;

@Embeddable
public class CountryLanguage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Builder.Factory
	public static CountryLanguage language(String language, Status status, Float percentage) {
		return new CountryLanguage(language, status, percentage);
	}

	@Column(nullable = false)
	public String language;

	@Column(name = "IsOfficial")
	@Convert(converter = LanguageStatusConverter.class)
	public Status status;

	public Float percentage;

	private CountryLanguage() {
	}

	private CountryLanguage(String language, Status status, Float percentage) {
		checkNotNull(language);
		checkNotNull(status);
		checkNotNull(percentage);
		this.language = language;
		this.status = status;
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("language", language)
				.add("status", status)
				.add("percentage", percentage)
				.toString();
	}

	// Implementar hashCode e equals pode salvar sua performance com o Hibernate, kkkkk
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
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
		CountryLanguage other = (CountryLanguage) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
