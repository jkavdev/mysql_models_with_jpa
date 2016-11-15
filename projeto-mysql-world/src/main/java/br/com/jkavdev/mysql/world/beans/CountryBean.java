package br.com.jkavdev.mysql.world.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.mysql.world.modelos.country.Country;
import br.com.jkavdev.mysql.world.respositorios.CountryDao;

@Named
@ViewScoped
public class CountryBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CountryDao countryDao;

	private List<Country> countries;

	@PostConstruct
	public void init() {
		countries = countryDao.buscarTodos();
	}

	public List<Country> getCountries() {
		return countries;
	}

}
