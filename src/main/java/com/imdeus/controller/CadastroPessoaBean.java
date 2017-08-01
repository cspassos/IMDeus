package com.imdeus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.imdeus.model.ComplementoPessoa;
import com.imdeus.model.Endereco;
import com.imdeus.model.Grupo;
import com.imdeus.model.Pessoa;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private List<String> grupo;
	
	public CadastroPessoaBean() {
		pessoa = new Pessoa();
		pessoa.setComplementoPessoa(new ComplementoPessoa());
		pessoa.setEndereco(new Endereco());
		//pessoa.setEnderecos(new Endereco());
		//grupo = new ArrayList<>();
		//grupo.add("GAM");
		//pessoa.setGrupo(new Grupo());
	}
	
	public void salvar() {
	}
	
//*********** GET E SET *****************************************************************
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
