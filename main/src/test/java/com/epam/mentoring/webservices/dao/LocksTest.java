package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Theatre;
import com.epam.mentoring.webservices.bean.User;

public class LocksTest extends AbstractTest {

	@Autowired
	protected UserDAO userDAO;
	@Autowired
	protected TheatreDAO theatreDAO;
	
	private static final Logger logger = Logger.getLogger(LocksTest.class);

	@Test(expected = StaleObjectStateException.class)
	@Ignore
	public void testOptimisticLocking_default() {	
		User user = prepareUserBean();
	
		User user1 = userDAO.get(user.getID());
		User user2 = userDAO.get(user.getID());

		user1.setName("test 1");
		user2.setName("test 2");
		
		userDAO.save(user1);
		userDAO.save(user2);

		fail("Optimistic locking doesn't work");
		logger.error("Optimistic locking doesn't work");
	}
	
	@Test(timeout = 20000)
	public void testPessimistickLocking() throws InterruptedException {
		Theatre theatre = prepareTheatreBean();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				theatreDAO.lockMethod(theatre);
			}
		};
		Thread t1 = new Thread(runnable);
		t1.start();
		
		theatreDAO.lockMethod(theatre);
		
		t1.join();
	}
	
	private User prepareUserBean() {
		User user = TestUtil.createTestUsers(1).get(0);
		userDAO.save(user);
		return user;
	}
	
	private Theatre prepareTheatreBean() {
		Theatre theatre = TestUtil.createTestTheatre(0);
		theatreDAO.save(theatre);
		return theatre;
	}
}
