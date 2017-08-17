package com.imdeus.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.imdeus.model.Grupo;
import com.imdeus.repository.GrupoRepository;
import com.imdeus.util.jpa.Transactional;

public class GrupoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private GrupoRepository grupoRepository;
	
	@Transactional
	public Grupo salvar(Grupo grupo) {
		return grupoRepository.salvar(grupo);
	}
}
