package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.mentoring.webservices.bean.Seat;
import com.epam.mentoring.webservices.bean.SeatPerfomance;
import com.epam.mentoring.webservices.test.AbstractDBUnitTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;

public class SeatDefaultDAOTest extends AbstractDBUnitTest {

	@Autowired
	protected SeatDAO seatDAO;

	@Test
	@DatabaseSetup({ "/data/theatre-data.xml", "/data/show-data.xml", 
			"/data/perfomance-data.xml", "/data/seat-data.xml",
			"/data/seat-perfomance-data.xml" })
	public void testFindSeatsUnderPriceForPerfomance() {

		double price = 20;
		long perfomanceID = 1;

		List<Seat> actualSeats = seatDAO.findSeatsUnderPriceForPerfomance(
				price, perfomanceID);

		for (Seat seat : actualSeats) {
			for (SeatPerfomance seatPerfomance : seat.getSeatPerfomanceSet()) {
				assertTrue(seatPerfomance.getPrice() < price);
			}
		}
	}
}
