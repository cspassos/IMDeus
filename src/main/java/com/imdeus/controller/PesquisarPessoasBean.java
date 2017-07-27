package com.imdeus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisarPessoasBean {

	private List<Integer> pessoasFiltrados;
	
	public PesquisarPessoasBean() {
		pessoasFiltrados = new ArrayList<>();
		for(int i=0; i < 50; i++) {
			pessoasFiltrados.add(i);
		}
	}
	
	public List<Integer> getGruposFiltrados(){
		return pessoasFiltrados;
	}
}
