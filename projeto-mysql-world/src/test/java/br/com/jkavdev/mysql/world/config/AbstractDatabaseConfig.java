package br.com.jkavdev.mysql.world.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractDatabaseConfig {

	private static EntityManagerFactory factory;
	 EntityManager entityManager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("worldPU");
	}

	@Before
	public void setUp() {
		this.entityManager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.entityManager.close();
	}

	public void commit() {
		this.entityManager.getTransaction().commit();
	}

	public void beginTransaction() {
		this.entityManager.getTransaction().begin();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
