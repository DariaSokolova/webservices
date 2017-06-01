package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Theatre;
import com.epam.mentoring.webservices.test.AbstractDBUnitTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class TheatreDefaultDAOTest extends AbstractDBUnitTest {

	@Autowired
	protected TheatreDAO theatreDAO;

	@Test
	@DatabaseSetup("/data/theatre-data.xml")
	public void testFindTheatreByTitle_existTitle() {
		String title = "Prince of Wales";
		
		Theatre actualTheatre = theatreDAO.findTheatreByTitle(title);

		assertEquals(title, actualTheatre.getTitle());
	}
	
	@Test
	@DatabaseSetup("/data/theatre-data.xml")
	public void testFindTheatreByTitle_notExistTitle() {
		String title = "National";
		
		Theatre actualTheatre = theatreDAO.findTheatreByTitle(title);

		assertNull(actualTheatre);
	}
}
