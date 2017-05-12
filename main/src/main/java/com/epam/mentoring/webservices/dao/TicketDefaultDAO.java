package com.epam.mentoring.webservices.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoring.webservices.bean.Ticket;

public class TicketDefaultDAO extends BeanDAO<Ticket> implements TicketDAO {

	@Override
	public Class<?> getBeanClass() {
		return Ticket.class;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Ticket> findTicketsByShowTitle(String title) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery("findTicketsByShowTitle")
				.setString("title", title);

		return query.list();
	}
}
