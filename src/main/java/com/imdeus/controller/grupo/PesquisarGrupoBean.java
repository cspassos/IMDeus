package com.imdeus.controller.grupo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisarGrupoBean {

	private List<Integer> gruposFiltrados;
	
	public PesquisarGrupoBean() {
		gruposFiltrados = new ArrayList<>();
		for(int i=0; i < 50; i++) {
			gruposFiltrados.add(i);
		}
	}
	
	public List<Integer> getGruposFiltrados(){
		return gruposFiltrados;
	}
}
