package com.epam.mentoring.webservices.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.exception.FileUploadException;

public class UserDefaultDAO extends BeanDAO<User> implements UserDAO {

	@Override
	public Class<?> getBeanClass() {
		return User.class;
	}

	@Override
	public byte[] getPhoto(long beanID) {
		byte[] bytes = null;

		try {
			Session session = sessionFactory.getCurrentSession();
		//	Statistics stats = sessionFactory.getStatistics();
			
			Transaction transaction = session.beginTransaction();
			User bean = (User) session.get(User.class, beanID);
			bytes = bean.getPhoto().getBytes(1, (int) bean.getPhoto().length());
			session.flush();
			transaction.commit();
			
		//	stats.logSummary();
		} catch (SQLException e) {
			throw new FileUploadException(e);
		}
		return bytes;
	}
}
