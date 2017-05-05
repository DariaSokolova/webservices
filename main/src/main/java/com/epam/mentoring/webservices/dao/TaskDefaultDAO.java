package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.Task;

public class TaskDefaultDAO extends BeanDAO<Task> implements TaskDAO {

	@Override
	public Class<?> getBeanClass() {
		return Task.class;
	}
}
