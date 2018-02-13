package br.com.jkavdev.mysql.world.entities;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

public enum Continent {
	
	ASIA("Asia"),
	EUROPE("Europe"),
	NORTH_AMERICA("North America"),
	AFRICA("Africa"),
	OCEANIA("Oceania"),
	ANTARCTICA("Antarctica"),
	SOUTH_AMERICA("South America");
	
	private String description;

	private Continent(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Continent from(String value) {
		if(isNoneBlank(value))
			return Continent.valueOf(value.toUpperCase().replace(" ", "_"));
		throw new IllegalArgumentException("Unknown value: " + value);
	}
	
}
