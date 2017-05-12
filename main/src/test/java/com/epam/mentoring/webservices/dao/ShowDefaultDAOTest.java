package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Show;

public class ShowDefaultDAOTest extends AbstractTest {

	@Autowired
	protected ShowDAO showDAO;

	@Test
	public void testFindShowByTitle_existTitle() {
		String title = "Wicked";
		
		Show show = TestUtil.createTestShow(0);
		show.setTitle(title);
		showDAO.save(show);
		
		Show actualShow = showDAO.findShowByTitle(title);
		
		assertEquals(show, actualShow);
	}
	@Test
	public void testFindShowByTitle_notExistTitle() {
		String title = "Wicked";
		
		Show show = TestUtil.createTestShow(0);
		showDAO.save(show);
		
		Show actualShow = showDAO.findShowByTitle(title);
		
		assertNotEquals(show, actualShow);
	}
}
