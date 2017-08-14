package com.imdeus.controller.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisarPessoaBean {

	private List<Integer> pessoasFiltrados;
	
	public PesquisarPessoaBean() {
		pessoasFiltrados = new ArrayList<>();
		for(int i=0; i < 50; i++) {
			pessoasFiltrados.add(i);
		}
	}
	
	public List<Integer> getGruposFiltrados(){
		return pessoasFiltrados;
	}
}
