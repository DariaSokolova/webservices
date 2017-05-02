package com.epam.mentoring.webservices.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.AbstractBean;

public abstract class BeanDAO<T extends AbstractBean> implements
		IBeanDAO<AbstractBean> {

	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(long beanID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		T bean = (T) session.get(getBeanClass(), beanID);
		session.flush();
		transaction.commit();
		return bean;
	}

	@Override
	public void save(AbstractBean bean) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(bean);
		session.flush();
		transaction.commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void delete(long beanID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		T bean = (T) session.load(getBeanClass(), beanID);
		if (bean.getID() != 0) {
			session.delete(bean);
			session.flush();
			transaction.commit();
		}
	}
}
