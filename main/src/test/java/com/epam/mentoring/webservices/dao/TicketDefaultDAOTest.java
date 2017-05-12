package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Show;
import com.epam.mentoring.webservices.bean.Ticket;
import com.epam.mentoring.webservices.bean.User;

public class TicketDefaultDAOTest extends AbstractTest {

	@Autowired
	protected TicketDAO ticketDAO;
	@Autowired
	protected UserDAO userDAO;

	@Test
	public void testFindTicketsByShowTitle() {
		String title = "Wicked";
		int count = 5;

		//creates user with 5 ticket for one show
		User user = TestUtil.createTestUsersWithTickets(1, count).get(0);
		Show templateShow = user.getTickets().iterator().next().getPerfomance()
				.getShow();
		templateShow.setTitle(title);
		for (Ticket ticket : user.getTickets()) {
			ticket.getPerfomance().setShow(templateShow);
		}
		
		//creates 1 ticket for the same user another show
		TestUtil.createTestTicket(user, 0);
		
		userDAO.save(user);

		int actualCount = ticketDAO.findTicketsByShowTitle(title).size();

		assertEquals(actualCount, count);
	}
}
