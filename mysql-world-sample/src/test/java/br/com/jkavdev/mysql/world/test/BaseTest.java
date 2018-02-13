package br.com.jkavdev.mysql.world.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void setUpBeforeTestClass() {
		factory = Persistence.createEntityManagerFactory("worldTestPU");
	}

	@Before
	public void setUpBeforeTestMethod() {
		manager = factory.createEntityManager();
	}

	@After
	public void tearDownAfterTestMethod() {
		manager.close();
	}

	@AfterClass
	public static void tearDownAfterTestClass() {
		// close connections, close browser as needed
		factory.close();
	}

	public EntityManager getManager() {
		return manager;
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

	public void commitTransaction() {
		manager.getTransaction().commit();
	}

}
