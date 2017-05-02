package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.Show;

public class ShowDAO extends BeanDAO<Show> {
	
	@Override
	public Class<?> getBeanClass() {
		return Show.class;
	}
}
