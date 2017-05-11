package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.User;

public interface UserDAO extends IBeanDAO<User> {
	public byte[] getPhoto(long beanID);
}
