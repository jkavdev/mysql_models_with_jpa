package br.com.jkavdev.mysql.world.modelos.language;

public enum Official {

	F("False"),
	T("True");

	private String description;

	private Official(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
