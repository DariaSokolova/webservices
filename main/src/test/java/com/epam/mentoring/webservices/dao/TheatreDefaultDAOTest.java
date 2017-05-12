package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Theatre;

public class TheatreDefaultDAOTest extends AbstractTest {

	@Autowired
	protected TheatreDAO theatreDAO;

	@Test
	public void testFindTheatreByTitle() {
		String title = "Prince of Wales";
		
		Theatre expectedTheatre = TestUtil.createTestTheatre(0);
		expectedTheatre.setTitle(title);;
		theatreDAO.save(expectedTheatre);
		
		Theatre anotherTheatre = TestUtil.createTestTheatre(1);
		anotherTheatre.setTitle("Apollo Victoria");
		theatreDAO.save(anotherTheatre);
		
		Theatre actualTheatre = theatreDAO.findTheatreByTitle(title);

		assertEquals(actualTheatre.getTitle(), expectedTheatre.getTitle());
	}
}
