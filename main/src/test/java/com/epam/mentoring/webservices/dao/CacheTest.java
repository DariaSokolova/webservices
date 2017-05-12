package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Theatre;

public class CacheTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(CacheTest.class);

	@Autowired
	protected TheatreDAO theatreDAO;

	@Test
	public void testCache_get() {
		Theatre theatre = prepareTestBean();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		long id = theatre.getID();

		long startTime = System.currentTimeMillis();
		session.get(Theatre.class, id);
		long endTime = System.currentTimeMillis();

		long executeTimeDB = endTime - startTime;
		logger.info("DB call. Execute Time : " + executeTimeDB + "ms");

		startTime = System.currentTimeMillis();
		session.get(Theatre.class, id);
		endTime = System.currentTimeMillis();

		long executeTime1Cache = endTime - startTime;
		logger.info("1th level cache call. Execute Time : " + executeTime1Cache
				+ "ms");

		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		startTime = System.currentTimeMillis();
		session.get(Theatre.class, id);
		endTime = System.currentTimeMillis();

		long executeTime2Cache = endTime - startTime;
		logger.info("2th level cache call. Execute Time : " + executeTime2Cache
				+ "ms");

		session.getTransaction().commit();
		session.close();

		Statistics stat = sessionFactory.getStatistics();
		stat.logSummary();

		assertEquals(1, stat.getSecondLevelCacheHitCount());
		assertEquals(1, stat.getSecondLevelCacheMissCount());

		assertTrue(executeTimeDB > executeTime1Cache);
		assertTrue(executeTimeDB > executeTime2Cache);
	}

	private Theatre prepareTestBean() {
		Theatre theatre = TestUtil.createTestTheatres(1).iterator().next();
		theatreDAO.save(theatre);
		sessionFactory.getCache().evictEntityRegion(Theatre.class);
		sessionFactory.getStatistics().clear();
		return theatre;
	}
}
