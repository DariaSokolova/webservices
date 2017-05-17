package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Show;
import com.epam.mentoring.webservices.test.AbstractDBUnitTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class ShowDefaultDAOTest extends AbstractDBUnitTest {

	@Autowired
	protected ShowDAO showDAO;

	@Test
	@DatabaseSetup("/data/show-data.xml")
	public void testFindShowByTitle_existTitle() {
		String title = "Wicked";
		
		Show actualShow = showDAO.findShowByTitle(title);
		
		assertEquals(title, actualShow.getTitle());
	}
	
	@Test
	@DatabaseSetup("/data/show-data.xml")
	public void testFindShowByTitle_notExistTitle() {
		String title = "Les Mis";
		
		Show actualShow = showDAO.findShowByTitle(title);
		
		assertNull(actualShow);
	}
}
