package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Ticket;
import com.epam.mentoring.webservices.test.AbstractDBUnitTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class TicketDefaultDAOTest extends AbstractDBUnitTest {

	@Autowired
	protected TicketDAO ticketDAO;

	@Test
	@DatabaseSetup({ "/data/user-data.xml", "/data/show-data.xml",
			"/data/theatre-data.xml", "/data/perfomance-data.xml",
			"/data/ticket-data.xml" })
	public void testFindTicketsByShowTitle() {
		String title = "Wicked";
		int count = 5;

		List<Ticket> tickets = ticketDAO.getAll();
		tickets.size();

		int actualCount = ticketDAO.findTicketsByShowTitle(title).size();

		assertEquals(actualCount, count);
	}
}
