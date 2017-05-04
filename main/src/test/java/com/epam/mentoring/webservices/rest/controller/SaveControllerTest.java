package com.epam.mentoring.webservices.rest.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.mentoring.webservices.bean.Task;
import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.dao.TaskDAO;
import com.epam.mentoring.webservices.dao.UserDAO;

public class SaveControllerTest {
//	@InjectMocks SaveController controller;
//	@Mock protected UserDAO userDAO;
//	@Mock protected TaskDAO taskDAO;
//	
//	@Before
//	public void setup() {
//	    MockitoAnnotations.initMocks(this);
//	}
//	
//	@Test
//	public void testUpdateUser_WhenUserExists() {
//		long id = 1;
//		User user = new User();
//		user.setUserID(id);
//		
//		Mockito.when(userDAO.get(id)).thenReturn(user);
//		
//		long actualID = controller.updateUser(id, user);
//		
//		assertEquals(user.getID(), actualID);
//	}
//	
//	@Test
//	public void testUpdateUser_WhenUserDoesntExist() {
//		long id = 1;
//		User user = new User();
//		
//		long actualID = controller.updateUser(id, user);
//		
//		assertEquals(-1, actualID);
//	}
//	
//	@Test
//	public void testCreateTask_WhenUserExists() {
//		long userID = 1;
//		long taskID = 1;
//		User user = new User();
//		user.setUserID(userID);
//		
//		Task task = new Task();
//		task.setTaskID(taskID);
//		
//		Mockito.when(userDAO.get(userID)).thenReturn(user);
//		
//		long actualID = controller.createTask(userID, task);
//		
//		assertEquals(task.getID(), actualID);
//	}
//	
//	@Test
//	public void testCreateTask_WhenUserDoesntExist() {
//
//		long userID = 1;
//		
//		Task task = new Task();
//		
//		long actualID = controller.createTask(userID, task);
//		
//		assertEquals(-1, actualID);
//		
//	}
}
