package com.epam.mentoring.webservices.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentoring.webservices.bean.Task;
import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.dao.TaskDAO;
import com.epam.mentoring.webservices.dao.UserDAO;

@Api(value = "Get API")
@RestController
@RequestMapping("/user/{userID}")
public class GetController {
	protected UserDAO userDAO;
	protected TaskDAO taskDAO;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get User", notes = "Returns a user with the provided ID")
	public User getUser(@PathVariable long userID) {
		User user = userDAO.get(userID);
	//	setLinks(user);
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/task/{taskID}")
	@ApiOperation(value = "Get Task", notes = "Returns a task with the provided ID")
	public Task getTask(@PathVariable long userID, @PathVariable long taskID) {
		Task task = taskDAO.get(taskID);
		if (task != null) {
			User methodLinkBuilder = methodOn(GetController.class).getUser(
					userID);
			Link userLink = linkTo(methodLinkBuilder).withRel("getUser");
			task.add(userLink);
		}

		return task;
	}

	private void setLinks(User user) {
		if (user != null) {
			Link selfLink = linkTo(GetController.class).slash(user.getUserID())
					.withSelfRel();
			user.add(selfLink);
//			for (Task task : user.getTasks()) {
//				Task methodLinkBuilder = methodOn(GetController.class).getTask(
//						user.getUserID(), task.getID());
//				Link taskLink = linkTo(methodLinkBuilder).withRel("getTask");
//				user.add(taskLink);
//			}
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
