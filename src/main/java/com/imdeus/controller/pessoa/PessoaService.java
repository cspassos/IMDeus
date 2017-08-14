package com.imdeus.controller.pessoa;

import java.io.Serializable;

import javax.inject.Inject;

import com.imdeus.model.Pessoa;
import com.imdeus.repository.PessoaRepository;

public class PessoaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvar(Pessoa pessoa){
		return pessoaRepository.salvar(pessoa);
	}
}
