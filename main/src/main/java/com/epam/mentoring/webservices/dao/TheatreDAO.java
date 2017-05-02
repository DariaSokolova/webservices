package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.Theatre;

public class TheatreDAO extends BeanDAO<Theatre> {

	@Override
	public Class<?> getBeanClass() {
		return Theatre.class;
	}

}
