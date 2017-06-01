package com.epam.mentoring.webservices.dao;

import java.util.List;

import com.epam.mentoring.webservices.bean.Seat;

public interface SeatDAO extends IBeanDAO<Seat> {
	
	public List<Seat> findSeatsUnderPriceForPerfomance(double price, long perfomanceID);
}
