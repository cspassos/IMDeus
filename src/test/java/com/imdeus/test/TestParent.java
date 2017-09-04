package com.imdeus.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestParent {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("ImDeusTestPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	public EntityManager getManager() {
		return manager;
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	public void beginTransaction() {
		manager.getTransaction().begin();
	}
	
	public void commitTransaction() {
		manager.getTransaction().commit();
	}

}
