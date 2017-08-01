package com.imdeus.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.imdeus.model.Endereco;
import com.imdeus.model.Pessoa;

public class teste {

	public static void main(String[] args) {
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("ImDeusPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Passos");
		pessoa.setCelular(("(61) 96082398"));
		pessoa.setEmail("caic.souzapassossdas");
		
		Endereco endereco = new Endereco();
		
		endereco.setCep("1312-313");
		endereco.setCidade("Cristopolis");
		endereco.setComplemento("varejão");
		endereco.setLogradouro("Qnn 20");
		endereco.setNumero("12321");
		endereco.setUf("BA");
		endereco.setPessoa(pessoa);
		
		//pessoa.getEndereco().add(endereco);
		
		manager.persist(pessoa);
		
		trx.commit();
	}
}
