package com.epam.mentoring.webservices.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoring.webservices.bean.Show;

public class ShowDefaultDAO extends BeanDAO<Show> implements ShowDAO {

	@Override
	public Class<?> getBeanClass() {
		return Show.class;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public Show findShowByTitle(String title) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery("findShowByTitle").setString("title", title);

		List<Show> list = query.list();
		return list.isEmpty() ? null : (Show) query.list().get(0);
	}
}
