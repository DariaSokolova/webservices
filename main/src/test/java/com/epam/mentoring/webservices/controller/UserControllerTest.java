package com.epam.mentoring.webservices.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.constant.ApplicationConstant;
import com.epam.mentoring.webservices.dao.UserDAO;
import com.epam.mentoring.webservices.test.AbstractMockitoTest;
import com.epam.mentoring.webservices.validator.UserControllerValidator;

public class UserControllerTest extends AbstractMockitoTest {
	
	@InjectMocks UserController controller;
	@Mock protected UserDAO userDAO;
	@Mock protected Model model;
	@Mock protected UserControllerValidator validator;
	
	private static final String PAGE_EDIT = "user/edit";
	private static final String PAGE_LIST = "user/list";
	private static final String PAGE_VIEW = "user/view";
	
	@Test
	public void testGetList() {
		List<User> users = new ArrayList<>();
		Mockito.when(userDAO.getAll()).thenReturn(users);
		
		String view = controller.getList(model);
		
		Mockito.verify(model).addAttribute("beans", users);
		assertEquals(PAGE_LIST, view);
	}
	
	@Test
	public void testAddNew() {		
		String view = controller.addNew(model);
		
		assertEquals(PAGE_EDIT, view);
	}
	
	@Test
	public void testEdit() {		
		long userID = 1;
		User user = new User();
		
		Mockito.when(userDAO.get(userID)).thenReturn(user);
		
		String view = controller.edit(model, userID);

		Mockito.verify(model).addAttribute("user", user);
		assertEquals(PAGE_EDIT, view);
	}
	
	@Test
	public void testSave_whenNoErrors() {		
		User user = new User();
	
		BindingResult result = Mockito.mock(BindingResult.class);
		
		Mockito.when(result.hasErrors()).thenReturn(false);
		
		String view = controller.save(user, result, model, null);

		Mockito.verify(userDAO).save(user);
		Mockito.verify(model).addAttribute("bean", user);
		assertEquals(PAGE_VIEW, view);
	}
	
	@Test
	public void testSave_whenErrors() {		
		User user = new User();
	
		BindingResult result = Mockito.mock(BindingResult.class);
		
		Mockito.when(result.hasErrors()).thenReturn(true);
		
		String view = controller.save(user, result, model, null);

		Mockito.verify(userDAO, Mockito.never()).save(user);

		assertEquals(PAGE_EDIT, view);
	}
	
	@Test
	public void testDelete() {			
		long userID = 1;
		String view = controller.delete(userID);
		
		Mockito.verify(userDAO).delete(userID);
		
		assertEquals(ApplicationConstant.PAGE_HOME, view);
	}	
}
