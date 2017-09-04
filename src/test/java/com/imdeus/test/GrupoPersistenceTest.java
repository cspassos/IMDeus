package com.imdeus.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.imdeus.repository.GrupoRepository;
import com.imdeus.util.cdi.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class GrupoPersistenceTest{
	
	@Inject
	private GrupoRepository grupoRepository;
	
	@Test
	public void retornaGruposTest() {
		grupoRepository.todos();
	}
	
}
