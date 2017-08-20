package com.imdeus.repository;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.imdeus.model.Grupo;

public class GrupoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	//Buscar o status do grupo pelo ID
	public Grupo porId(Long id) {
		return manager.find(Grupo.class, id);
	}
	
	public Grupo salvar(Grupo grupo) {
		return manager.merge(grupo);
	}

	public Optional<Grupo> porNome(String nome) {
		return manager.createQuery("from Grupo where nome = :nomeGrupo", Grupo.class)
				.setParameter("nomeGrupo", nome)
				.getResultList()
				.stream()
				.findFirst();
	}

}
