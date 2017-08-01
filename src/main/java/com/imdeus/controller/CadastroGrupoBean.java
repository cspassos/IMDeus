package com.imdeus.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.imdeus.model.Grupo;

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Grupo grupo;

	public CadastroGrupoBean() {
		grupo = new Grupo();
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
	
}
