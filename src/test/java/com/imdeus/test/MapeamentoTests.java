package com.imdeus.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.imdeus.model.ComplementoPessoa;
import com.imdeus.model.Endereco;
import com.imdeus.model.Grupo;
import com.imdeus.model.Pessoa;

public class MapeamentoTests {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("ImDeusPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void insertPessoa() {
		ComplementoPessoa complemento = new ComplementoPessoa("Maria", "Lourival", "Complemento");
		Endereco endereco = new Endereco("15", "Qr 12 casa 15", "Planaltina", "GO");
		Pessoa pessoa = new Pessoa("Jhonatan", 21, "jhonatan@gmail.com", "6194331251", endereco, complemento);
		
		this.manager.getTransaction().begin();
		manager.persist(pessoa);
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void fetchPessoa() {
		manager.createQuery("from Pessoa", Pessoa.class).getResultList()
			.forEach(p -> System.out.println(p));
	}

	@Test
	public void problema() {
		Grupo gamGrupo1 = manager.find(Grupo.class, 1L);
		Grupo pomGrupo2 = manager.find(Grupo.class, 4L);
		Pessoa pessoa = new Pessoa("Jhonatan", 21, "jhonatan@gmail.com", "6194331251");
		pessoa.adicionar(gamGrupo1);
		pessoa.adicionar(pomGrupo2);
		this.manager.getTransaction().begin();
		manager.persist(pessoa);
		this.manager.getTransaction().commit();
	}

}
