package com.epam.mentoring.webservices.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Theatre;
import com.epam.mentoring.webservices.bean.TheatreOwner;
import com.epam.mentoring.webservices.bean.Ticket;
import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.dao.PerfomanceDAO;
import com.epam.mentoring.webservices.dao.ShowDAO;
import com.epam.mentoring.webservices.dao.TheatreDAO;
import com.epam.mentoring.webservices.dao.TheatreOwnerDAO;
import com.epam.mentoring.webservices.dao.UserDAO;

public class CollectionFetchingTest extends AbstractDBTest {

	@Autowired
	protected TheatreOwnerDAO theatreOwnerDAO;
	@Autowired
	protected TheatreDAO theatreDAO;
	@Autowired
	protected ShowDAO showDAO;
	@Autowired
	protected PerfomanceDAO perfomanceDAO;
	@Autowired
	protected UserDAO userDAO;

	private static final Logger logger = Logger
			.getLogger(CollectionFetchingTest.class);

	@Test
	public void testFetch_user_tickets() {
		prepareUserData();

		sessionFactory.getCurrentSession();

		long startTime = System.currentTimeMillis();

		List<User> list = userDAO.getAll();

		for (User bean : list) {
			Set<Ticket> set = bean.getTickets();

			for (Ticket ticket : set) {
				assertNotNull(ticket.getPrice());
			}
		}
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;

		logger.info("User-Tickets:lazy=false fetch=select batch-size=100");
		logger.info("Execute Time : " + executeTime + "ms");
	}

	@Test
	public void testFetch_owner_theatre() {
		prepareTheatreOwnerData();

		sessionFactory.getCurrentSession();

		long startTime = System.currentTimeMillis();

		List<TheatreOwner> list = theatreOwnerDAO.getAll();

		for (TheatreOwner theatreOwner : list) {
			Set<Theatre> set = theatreOwner.getTheatres();
			for (Theatre theatre : set) {
				assertNotNull(theatre.getSummary());
			}
		}
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;

		logger.info("TheatreOwner-Theatre:lazy=true fetch=join");
		logger.info("Execute Time : " + executeTime + "ms");
	}

	@Test
	public void testFetch_theatre_owner() {
		prepareTheatreData();
		long startTime = System.currentTimeMillis();

		sessionFactory.getCurrentSession().clear();
		List<Theatre> list = theatreDAO.getAll();

		for (Theatre theatre : list) {
			Set<TheatreOwner> set = theatre.getTheatreOwners();
			for (TheatreOwner theatreOwner : set) {
				assertNotNull(theatreOwner.getInfo());
			}
		}
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;

		logger.info("Theatre-TheatreOwner:lazy=true fetch=subselect");
		logger.info("Execute Time : " + executeTime + "ms");
	}

	public void prepareUserData() {
		List<User> users = TestUtil.createTestUsersWithTickets(100, 100);
		for (User user : users) {
			userDAO.save(user);
		}
	}

	public void prepareTheatreOwnerData() {
		Set<TheatreOwner> theatreOwners = TestUtil.createTestTheatreOwners(100);
		for (TheatreOwner theatreOwner : theatreOwners) {
			theatreOwner.setTheatres(TestUtil.createTestTheatres(100));
			theatreOwnerDAO.save(theatreOwner);
		}
	}

	public void prepareTheatreData() {
		Set<Theatre> theatres = TestUtil.createTestTheatres(10);
		for (Theatre theatre : theatres) {
			theatre.setTheatreOwners(TestUtil.createTestTheatreOwners(10));
			theatreDAO.save(theatre);
		}
	}
}
