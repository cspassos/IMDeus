package com.imdeus.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.imdeus.model.Pessoa;
import com.imdeus.util.jpa.Transactional;

public class PessoaRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	//Buscar o status do pessoa pelo ID
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		manager.persist(pessoa);
		return pessoa;
	}
}
