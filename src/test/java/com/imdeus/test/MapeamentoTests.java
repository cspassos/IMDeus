package com.imdeus.test;

import org.junit.Test;

import com.imdeus.model.ComplementoPessoa;
import com.imdeus.model.Endereco;
import com.imdeus.model.Grupo;
import com.imdeus.model.Pessoa;

public class MapeamentoTests extends TestParent {

	@Test
	public void insertPessoa() {
		ComplementoPessoa complemento = new ComplementoPessoa("Maria", "Lourival", "Complemento");
		Endereco endereco = new Endereco("15", "Qr 12 casa 15", "Planaltina", "GO");
		Pessoa pessoa = new Pessoa("Jhonatan", 21, "jhonatan@gmail.com", "6194331251", endereco, complemento);

		getManager().getTransaction().begin();
		getManager().persist(pessoa);
		getManager().getTransaction().commit();
	}

	@Test
	public void fetchPessoa() {
		getManager().createQuery("from Pessoa", Pessoa.class).getResultList().forEach(p -> System.out.println(p));
	}

	@Test
	public void problema() {
		Grupo gamGrupo1 = getManager().find(Grupo.class, 1L);
		Grupo pomGrupo2 = getManager().find(Grupo.class, 4L);
		Pessoa pessoa = new Pessoa("Jhonatan", 21, "jhonatan@gmail.com", "6194331251");
		pessoa.adicionar(gamGrupo1);
		pessoa.adicionar(pomGrupo2);
		getManager().getTransaction().begin();
		getManager().persist(pessoa);
		getManager().getTransaction().commit();
	}

}
