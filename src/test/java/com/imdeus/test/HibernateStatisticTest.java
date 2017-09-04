package com.imdeus.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.junit.Test;

import com.imdeus.model.StatusGrupo;

public class HibernateStatisticTest extends TestParent {
	
	private static final Logger logger = Logger.getLogger(HibernateStatisticTest.class);
	
	@Test
	public void statusGrupoStatistics() {
		for (int i = 0; i < 10; i++) {
			StatusGrupo status = new StatusGrupo();
			status.setNomeStatus("Status: " + i);

			beginTransaction();
			getManager().persist(status);
			commitTransaction();
		}
		
		getManager().createQuery("from StatusGrupo").getResultList();
	}
	
	@Test
	public void streamHibernateQueriesTest() {
		Stream<StatusGrupo> stream = getManager().createQuery("from StatusGrupo", StatusGrupo.class)
			.setMaxResults(20)
			.getResultList()
			.stream();
		stream
			.map(s -> s.getNomeStatus())
			.forEach(m -> logger.info(m));
	}
	
	@Test
	public void multiEntitiesSelect() {
		List<Long> ids = Arrays.asList(1L, 2L, 3L);
		getManager().createQuery("from StatusGrupo where id in :ids", StatusGrupo.class)
			.setParameter("ids", ids)
			.getResultList()
			.stream()
			.forEach(System.out::println);
		
		Session session = getManager().unwrap(Session.class);
		MultiIdentifierLoadAccess<StatusGrupo> multi = session.byMultipleIds(StatusGrupo.class);
		
		List<StatusGrupo> statuses = multi.multiLoad(ids);
		statuses
			.stream()
			.forEach(s -> System.out.println(s.getNomeStatus()));
	}
	
}
