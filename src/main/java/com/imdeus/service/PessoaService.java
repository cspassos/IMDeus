package com.imdeus.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.imdeus.model.Pessoa;
import com.imdeus.repository.PessoaRepository;
import com.imdeus.repository.filter.PessoaFilter;
import com.imdeus.util.jpa.Transactional;

public class PessoaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa){
		return pessoaRepository.salvar(pessoa);
	}

	public List<Pessoa> todas(PessoaFilter filter) {
		return pessoaRepository.todasPessoas(filter);
	}
}
