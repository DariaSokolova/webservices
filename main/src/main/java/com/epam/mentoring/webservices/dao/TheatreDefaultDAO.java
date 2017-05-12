package com.epam.mentoring.webservices.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoring.webservices.bean.Theatre;

public class TheatreDefaultDAO extends BeanDAO<Theatre> implements TheatreDAO {

	private static final Logger logger = Logger
			.getLogger(TheatreDefaultDAO.class);

	@Override
	public Class<?> getBeanClass() {
		return Theatre.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Theatre findTheatreByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Theatre where title = :title");
		query.setParameter("title", title);
		List<Theatre> list = query.list();
		return list.isEmpty() ? null : (Theatre) query.list().get(0);
	}

	@Override
	@Transactional
	public void lockMethod(Theatre theatre) {
		sessionFactory.getCurrentSession()
				.buildLockRequest(new LockOptions(LockMode.PESSIMISTIC_WRITE))
				.lock(theatre);
		logger.info(sessionFactory.getCurrentSession().hashCode()
				+ ": Session locks the object");
		try {
			logger.info(sessionFactory.getCurrentSession().hashCode()
					+ ": Session doing some work");
			Thread.sleep(5000);
			logger.info(sessionFactory.getCurrentSession().hashCode()
					+ ": Session release the objects");
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
	}
}
