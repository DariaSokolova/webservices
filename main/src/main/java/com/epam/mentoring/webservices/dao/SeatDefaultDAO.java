package com.epam.mentoring.webservices.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoring.webservices.bean.Seat;

public class SeatDefaultDAO extends BeanDAO<Seat> implements SeatDAO {

	@Override
	public Class<?> getBeanClass() {
		return Seat.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Seat> findSeatsUnderPriceForPerfomance(double price, long perfomanceID) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Seat.class);
		criteria.createAlias("seatPerfomanceSet", "seatPerfomance");
		criteria.add(Restrictions.le("seatPerfomance.price", price));
		criteria.add(Restrictions.le("seatPerfomance.perfomance.perfomanceID", perfomanceID));
		criteria.addOrder(Order.desc("seatPerfomance.price"));
		
		return criteria.list();
	}
}
