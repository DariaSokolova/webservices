package com.epam.mentoring.webservices.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.epam.mentoring.webservices.bean.Theatre;
import com.epam.mentoring.webservices.dao.TheatreDAO;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@TestExecutionListeners({ DbUnitTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
public class CacheTest extends AbstractDBTest {

	private static final Logger logger = Logger.getLogger(CacheTest.class);

	@Autowired
	protected TheatreDAO theatreDAO;

	@Test
	@DatabaseSetup("/data/theatre-data.xml")
	public void testCache() {
		long id = 1;

		Session session = sessionFactory.openSession();
		Statistics stat = sessionFactory.getStatistics();
		stat.clear();

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

		session.close();

		session = sessionFactory.openSession();

		startTime = System.currentTimeMillis();

		session.get(Theatre.class, id);
		endTime = System.currentTimeMillis();

		long executeTime2Cache = endTime - startTime;
		logger.info("2th level cache call. Execute Time : " + executeTime2Cache
				+ "ms");
		session.close();

		stat.logSummary();

		assertEquals(1, stat.getSecondLevelCacheHitCount());
		assertEquals(1, stat.getSecondLevelCacheMissCount());

		assertTrue(executeTimeDB > executeTime1Cache);
		assertTrue(executeTimeDB > executeTime2Cache);
	}
}
