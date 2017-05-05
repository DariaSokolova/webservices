package com.epam.mentoring.webservices.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.exception.ServiceException;

public class UserDefaultDAO extends BeanDAO<User> implements UserDAO {

	@Override
	public Class<?> getBeanClass() {
		return User.class;
	}

	@Override
	public byte[] getPhoto(long beanID) {
		byte[] bytes = null;

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User bean = (User) session.get(User.class, beanID);
		try {
			bytes = bean.getPhoto().getBytes(1, (int) bean.getPhoto().length());
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
		session.flush();
		transaction.commit();
		return bytes;
	}
}
