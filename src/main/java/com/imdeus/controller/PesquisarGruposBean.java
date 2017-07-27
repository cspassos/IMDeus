package com.imdeus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisarGruposBean {

	private List<Integer> gruposFiltrados;
	
	public PesquisarGruposBean() {
		gruposFiltrados = new ArrayList<>();
		for(int i=0; i < 50; i++) {
			gruposFiltrados.add(i);
		}
	}
	
	public List<Integer> getGruposFiltrados(){
		return gruposFiltrados;
	}
}
