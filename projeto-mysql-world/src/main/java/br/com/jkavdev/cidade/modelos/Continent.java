package br.com.jkavdev.cidade.modelos;

public enum Continent {
	
	ASIA("Asia"),
	EUROPE("Europe"),
	NORTH_AMERICA("North America"), 
	AFRICA("Africa"),
	OCEANIA("Oceania"),
	ANTARcTICA("Antarctica"),
	SOUTH_AMERICA("South America");
	
	private String description;

	private Continent(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
