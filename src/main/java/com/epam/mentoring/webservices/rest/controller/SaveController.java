package com.epam.mentoring.webservices.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentoring.webservices.bean.Task;
import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.dao.TaskDAO;
import com.epam.mentoring.webservices.dao.UserDAO;

@Api(value = "Save and Update API")
@RestController
@RequestMapping("/user")
public class SaveController {

	protected UserDAO userDAO;
	protected TaskDAO taskDAO;

	@RequestMapping(method = RequestMethod.POST, consumes = {
			"application/xml", "application/json" })
	@ApiOperation(value = "Create User", notes = "Creates a user with provided parameters")
	public long createUser(@RequestBody User user) {
		userDAO.save(user);
		return user.getUserID();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{userID}", consumes = {
			"application/xml", "application/json" })
	@ApiOperation(value = "Update User", notes = "Updates a user with provided parameters")
	public long updateUser(@PathVariable long userID, @RequestBody User user) {
		user.setUserID(userID);
		if (userDAO.get(userID) != null) {
			userDAO.save(user);
			return userID;
		} else {
			return -1;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{userID}/task", consumes = {
			"application/xml", "application/json" })
	@ApiOperation(value = "Create Task", notes = "Creates a task with provided parameters")
	public long createTask(@PathVariable long userID, @RequestBody Task task) {
		User user = userDAO.get(userID);
		if (user != null) {
			task.setUser(user);
			taskDAO.save(task);
			return task.getTaskID();
		} else {
			return -1;
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{userID}/task/{taskID}", consumes = {
			"application/xml", "application/json" })
	@ApiOperation(value = "Update Task", notes = "Updates a task with provided parameters")
	public long updateTask(@PathVariable long userID,
			@PathVariable long taskID, @RequestBody Task task) {
		User user = userDAO.get(userID);
		if (user != null && taskDAO.get(taskID) != null) {
			task.setUser(user);
			task.setTaskID(taskID);
			taskDAO.save(task);
			return task.getTaskID();
		} else {
			return -1;
		}
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
