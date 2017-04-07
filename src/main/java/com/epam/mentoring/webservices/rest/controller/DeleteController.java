package com.epam.mentoring.webservices.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentoring.webservices.dao.TaskDAO;
import com.epam.mentoring.webservices.dao.UserDAO;

@Api(value = "Delete API")
@RestController
@RequestMapping("/user/{userID}")
public class DeleteController {
	protected UserDAO userDAO;
	protected TaskDAO taskDAO;
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete User", notes = "Deletes a user with provided ID")
	public void deleteUser(@PathVariable long userID) {
		userDAO.delete(userID);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/task/{taskID}")
	@ApiOperation(value = "Delete Task", notes = "Deletes a task with provided ID")
	public void deleteTask(@PathVariable long userID, @PathVariable long taskID) {
		taskDAO.delete(taskID);
	}
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setTaskDAO(TaskDAO taskManager) {
		this.taskDAO = taskManager;
	}
}
