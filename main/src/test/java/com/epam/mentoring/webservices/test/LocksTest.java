package com.epam.mentoring.webservices.test;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.dao.TheatreDAO;
import com.epam.mentoring.webservices.dao.UserDAO;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@TestExecutionListeners({ DbUnitTestExecutionListener.class,
	DependencyInjectionTestExecutionListener.class })
public class LocksTest extends AbstractDBTest {

	@Autowired
	protected UserDAO userDAO;
	@Autowired
	protected TheatreDAO theatreDAO;
	
	private static final Logger logger = Logger.getLogger(LocksTest.class);

	@Test(expected = StaleObjectStateException.class)
	@DatabaseSetup("/data/user-data.xml")
	public void testOptimisticLocking_default() {	
		long userID = 1;
	
		User user1 = userDAO.get(userID);
		User user2 = userDAO.get(userID);

		user1.setName("Connor");
		user2.setName("Arnold");
		
		userDAO.save(user1);
		userDAO.save(user2);

		fail("Optimistic locking doesn't work");
		logger.error("Optimistic locking doesn't work");
	}
	
	@Test(timeout = 20000)
	@DatabaseSetup("/data/theatre-data.xml")
	public void testPessimistickLocking() throws InterruptedException {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				theatreDAO.lockMethod(2);
			}
		};
		Thread t1 = new Thread(runnable);
		t1.start();
		
		theatreDAO.lockMethod(2);
		
		t1.join();
	}
}
