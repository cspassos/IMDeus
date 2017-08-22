package com.imdeus.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

@ApplicationScoped
public class EntityManagerProducer {

	private static final Logger logger = Logger.getLogger(EntityManager.class);

	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		factory = Persistence.createEntityManagerFactory("ImDeusPU");
	}

	// com a nova versao do hibernate e cdi, o escopo request gera erro
	// para resolver utilizaremos o dependent
	// no qual pego o escopo que quem o chama
	@Produces
	@RequestScoped
	public EntityManager createEntyManager() {
		logger.info("Criando manager........");
		return factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		logger.info("Fechando manager........");
		manager.close();
	}
}