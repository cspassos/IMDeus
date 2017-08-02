package com.imdeus.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.imdeus.model.Grupo;
import com.imdeus.model.StatusGrupo;

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	private Grupo grupo;
	
	private List<StatusGrupo> statusGrupoRaizes;

	public CadastroGrupoBean() {
		grupo = new Grupo();
	}
	
	public void inicializar() {
		
		statusGrupoRaizes = manager.createQuery("from StatusGrupo", StatusGrupo.class).getResultList();
		
	}
	
	public void salvar() {
	}
	
//** GET E SET ************************************************************************
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<StatusGrupo> getStatusGrupoRaizes() {
		return statusGrupoRaizes;
	}

	public void setStatusGrupoRaizes(List<StatusGrupo> statusGrupoRaizes) {
		this.statusGrupoRaizes = statusGrupoRaizes;
	}
	
}
