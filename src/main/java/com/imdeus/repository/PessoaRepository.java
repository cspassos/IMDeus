package com.imdeus.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.imdeus.model.Pessoa;

public class PessoaRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Pessoa salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}
}
