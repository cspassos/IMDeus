package com.imdeus.service;

import java.io.Serializable;
import java.util.List;

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

	public List<Grupo> comecadosCom(String nome) {
		return grupoRepository.gruposContendo(nome);
	}

	@Transactional
	public void deletar(Grupo grupo) {
		grupo = grupoRepository.porId(grupo.getId());
		//TODO: porque inferno está trazendo grupopessoa no delete
		if(grupo != null) 
			grupoRepository.deletar(grupo);
	}
}
