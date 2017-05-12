package com.epam.mentoring.webservices.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.webservices.bean.Perfomance;
import com.epam.mentoring.webservices.bean.Seat;
import com.epam.mentoring.webservices.bean.SeatPerfomance;

public class SeatDefaultDAOTest extends AbstractTest {

	@Autowired
	protected SeatDAO seatDAO;
	@Autowired
	protected SeatPerfomanceDAO seatPerfomanceDAO;
	@Autowired
	protected PerfomanceDAO perfomanceDAO;

	@Test
	public void testFindSeatsUnderPriceForPerfomance() {
		double price = 10;
		double cof = 1;
		double expectedPrice = 20;

		Perfomance perfomance = TestUtil.createTestPerfomance(0);
		perfomanceDAO.save(perfomance);

		Set<Seat> seats = TestUtil.createTestSeats(3);
		Set<Seat> expectedSeats = new HashSet<>();
		Set<Seat> notExpectedSeats = new HashSet<>();
		for (Seat seat : seats) {
			seatDAO.save(seat);
			
			double currentPrice = price * cof++;
			SeatPerfomance seatPerfomance = TestUtil.createTestSeatPerfomance(
					currentPrice, seat, perfomance);

			seatPerfomanceDAO.save(seatPerfomance);
			if (currentPrice <= expectedPrice) {
				expectedSeats.add(seat);
			} else {
				notExpectedSeats.add(seat);
			}
		}

		List<Seat> actualSeats = seatDAO.findSeatsUnderPriceForPerfomance(
				expectedPrice, perfomance.getID());

		for (Seat seat : expectedSeats) {
			assertTrue(actualSeats.contains(seat));
		}
		
		for (Seat seat : notExpectedSeats) {
			assertFalse(actualSeats.contains(seat));
		}

	}
}
