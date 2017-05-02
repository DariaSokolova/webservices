package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.ShowPerfomanceMap;

public class ShowPerfomanceMapDAO extends BeanDAO<ShowPerfomanceMap> {

	@Override
	public Class<?> getBeanClass() {
		return ShowPerfomanceMap.class;
	}

}
