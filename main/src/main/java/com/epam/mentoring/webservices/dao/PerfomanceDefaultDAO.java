package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.Perfomance;

public class PerfomanceDefaultDAO extends BeanDAO<Perfomance> implements PerfomanceDAO {

	@Override
	public Class<?> getBeanClass() {
		return Perfomance.class;
	}
}
