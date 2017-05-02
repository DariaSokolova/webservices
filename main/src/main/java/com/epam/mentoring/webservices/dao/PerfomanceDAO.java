package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.Perfomance;

public class PerfomanceDAO extends BeanDAO<Perfomance> {

	@Override
	public Class<?> getBeanClass() {
		return Perfomance.class;
	}

}
