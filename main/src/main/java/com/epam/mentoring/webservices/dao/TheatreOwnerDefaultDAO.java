package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.TheatreOwner;

public class TheatreOwnerDefaultDAO extends BeanDAO<TheatreOwner> implements TheatreOwnerDAO {

	@Override
	public Class<?> getBeanClass() {
		return TheatreOwner.class;
	}
}
