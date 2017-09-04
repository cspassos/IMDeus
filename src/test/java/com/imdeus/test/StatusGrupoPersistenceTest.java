package com.imdeus.test;

import static org.junit.Assert.assertNotEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.imdeus.model.StatusGrupo;

public class StatusGrupoPersistenceTest extends TestParent{
	
	@Test
	public void retornaStatusTest() {
		List<StatusGrupo> status = getManager().createQuery("from StatusGrupo", StatusGrupo.class).getResultList();

		assertNotEquals(Collections.EMPTY_LIST, status);
	}

}
