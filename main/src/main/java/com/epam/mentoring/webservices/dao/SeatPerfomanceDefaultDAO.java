package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.SeatPerfomance;

public class SeatPerfomanceDefaultDAO extends BeanDAO<SeatPerfomance> implements SeatPerfomanceDAO {

	@Override
	public Class<?> getBeanClass() {
		return SeatPerfomance.class;
	}
}
