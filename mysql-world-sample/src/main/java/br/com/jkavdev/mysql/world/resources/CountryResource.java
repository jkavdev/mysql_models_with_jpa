package br.com.jkavdev.mysql.world.resources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import br.com.jkavdev.mysql.world.entities.Country;
import br.com.jkavdev.mysql.world.repositories.CountryRepository;

@Path("countries")
@RequestScoped
public class CountryResource {

	private static final Logger log = Logger.getLogger(Country.class);

	@Inject
	private CountryRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries() {
		log.info("requesting all countries......");
		return repository.allCountries();
	}

}
