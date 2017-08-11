package com.imdeus.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.imdeus.model.Grupo;
import com.imdeus.util.jpa.Transactional;

public class GrupoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(Grupo grupo) {
		manager.persist(grupo);
	}

}
