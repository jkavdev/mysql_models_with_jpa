package br.com.jkavdev.mysql.world.modelos.country;

import java.util.HashMap;
import java.util.Map;

public enum Continent {

	ASIA("Asia"), 
	EUROPE("Europe"), 
	NORTH_AMERICA("North America"), 
	AFRICA("Africa"), 
	OCEANIA("Oceania"), 
	ANTARCTICA("Antarctica"), 
	SOUTH_AMERICA("South America");

	private final String description;

	private Continent(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static final Map<String, Continent> dbValues = new HashMap<>();

	static {
		for (Continent value : values()) {
			dbValues.put(value.description, value);
		}
	}

	public static Continent fromDbValue(String dbData) {
		return dbValues.get(dbData);
	}

}
