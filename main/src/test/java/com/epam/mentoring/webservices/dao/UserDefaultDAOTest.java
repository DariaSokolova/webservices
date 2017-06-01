package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.test.AbstractDBUnitTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

public class UserDefaultDAOTest extends AbstractDBUnitTest {

	@Autowired
	protected UserDAO userDAO;

	@Test
	@DatabaseSetup("/data/user-data.xml")
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value ="/data/user-data.xml")
	public void testGetAll() {
		List<User> users = userDAO.getAll();
		assertEquals(3, users.size());
	}

	@Test
	@DatabaseSetup("/data/user-data.xml")
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value ="/data/user-data.xml")
	public void testGet() {
		User user = userDAO.get(2);
		
		assertNotNull(user);
		assertEquals("Evan", user.getName());
		assertEquals("Hansen", user.getSurname());
		assertEquals("evan@hansen.com", user.getEmail());
	}

	@Test
	@DatabaseSetup("/data/user-data.xml")
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value = "/data/user-data-after-delete.xml")
	public void testDelete() {
		userDAO.delete(1);
	}

	@Test
	@DatabaseSetup("/data/user-data.xml")
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value = "/data/user-data-after-save.xml")
	public void testSave_newBean() {
		User user = new User();
		user.setName("Amy");
		user.setSurname("Pond");
		user.setEmail("amy@pond.com");
		userDAO.save(user);
	}

	@Test
	@DatabaseSetup("/data/user-data.xml")
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value = "/data/user-data-after-update.xml")
	public void testSave_update() {
		User user = userDAO.get(3);
		user.setEmail("doctor@who.com");
		userDAO.save(user);
	}
}
