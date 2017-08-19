package com.imdeus.controller.pessoa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.imdeus.model.Pessoa;
import com.imdeus.repository.filter.PessoaFilter;
import com.imdeus.service.PessoaService;

@Named
@ViewScoped
public class PesquisarPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaService pessoaService;
	
	private PessoaFilter filtro;
	
	private List<Pessoa> pessoasFiltrados;
	
	@PostConstruct
	public void init() {
		filtro = new PessoaFilter();
	}
	
	public void consultaPessoa() {
		pessoasFiltrados = pessoaService.todas(filtro);
	}
	
	public PessoaFilter getFiltro() {
		return filtro;
	}
	
	public void setFiltro(PessoaFilter filtro) {
		this.filtro = filtro;
	}
	
	public List<Pessoa> getTodasPessoas(){
		return pessoasFiltrados;
	}
}
