package com.epam.mentoring.webservices.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.epam.mentoring.webservices.bean.User;

public class UserDAO extends BeanDAO<User> {

	@Override
	public Class<?> getBeanClass() {
		return User.class;
	}
	
	public byte[] getPhoto(long beanID) {
		byte[] bytes = null;
		
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User bean = (User) session.get(User.class, beanID);
		try {
			int blobLength = (int) bean.getPhoto().length();  
			bytes = bean.getPhoto().getBytes(1, blobLength);
		} catch (SQLException e) {
			e.getMessage();
		}
		session.flush();
		transaction.commit();
		return bytes;
	}
}
