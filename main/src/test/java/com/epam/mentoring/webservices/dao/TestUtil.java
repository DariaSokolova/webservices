package com.epam.mentoring.webservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epam.mentoring.webservices.bean.Perfomance;
import com.epam.mentoring.webservices.bean.Seat;
import com.epam.mentoring.webservices.bean.SeatPerfomance;
import com.epam.mentoring.webservices.bean.SeatStatus;
import com.epam.mentoring.webservices.bean.Show;
import com.epam.mentoring.webservices.bean.Theatre;
import com.epam.mentoring.webservices.bean.TheatreOwner;
import com.epam.mentoring.webservices.bean.Ticket;
import com.epam.mentoring.webservices.bean.User;

public class TestUtil {

	private static Date DEFAULT_DATE = new Date();

	protected static List<User> createTestUsers(int count) {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			users.add(createTestUser(i));
		}
		return users;
	}

	protected static User createTestUser(int i) {
		User user = new User();
		user.setName("name " + i);
		user.setSurname("surname" + i);
		user.setEmail("email " + i);
		return user;
	}

	protected static List<User> createTestUsersWithTickets(int userCount,
			int ticketCount) {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < userCount; i++) {
			User user = createTestUser(i);
			user.setTickets(createTestTickets(user, ticketCount));
			users.add(user);
		}
		return users;
	}

	protected static Set<Ticket> createTestTickets(User user, int count) {
		Set<Ticket> tickets = new HashSet<>();
		for (int i = 0; i < count; i++) {
			tickets.add(createTestTicket(user, i));
		}
		return tickets;
	}

	protected static Ticket createTestTicket(User user, int i) {
		Ticket ticket = new Ticket();
		ticket.setUser(user);
		ticket.setPrice(i);
		ticket.setPurchaseDate(DEFAULT_DATE);
		ticket.setPerfomance(createTestPerfomance(i));
		return ticket;
	}

	protected static Perfomance createTestPerfomance(int i) {
		Perfomance perfomance = new Perfomance();
		perfomance.setShow(createTestShow(i));
		perfomance.setTheatre(createTestTheatre(i));
		perfomance.setStartTime(DEFAULT_DATE);
		perfomance.setEndTime(DEFAULT_DATE);
		return perfomance;
	}

	protected static Set<Perfomance> createTestPerfomancesForShow(Show show,
			int count) {
		Set<Perfomance> perfomances = new HashSet<>();
		for (int i = 0; i < count; i++) {
			Perfomance perfomance = new Perfomance();
			perfomance.setShow(show);
			perfomance.setTheatre(createTestTheatre(i));
			perfomance.setStartTime(DEFAULT_DATE);
			perfomance.setEndTime(DEFAULT_DATE);
			perfomances.add(perfomance);
		}
		return perfomances;
	}

	protected static Set<Theatre> createTestTheatres(int count) {
		Set<Theatre> theatres = new HashSet<>();
		for (int i = 0; i < count; i++) {
			theatres.add(createTestTheatre(i));
		}
		return theatres;
	}

	protected static Theatre createTestTheatre(int i) {
		Theatre theatre = new Theatre();
		theatre.setSummary("summary" + i);
		theatre.setTitle("title" + i);
		return theatre;
	}

	protected static List<Show> createTestShows(int count) {
		List<Show> shows = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			shows.add(createTestShow(i));
		}
		return shows;
	}

	protected static Show createTestShow(int i) {
		Show show = new Show();
		show.setSummary("summary" + i);
		show.setTitle("title" + i);
		return show;
	}

	protected static Set<TheatreOwner> createTestTheatreOwners(int count,
			int subCount) {
		Set<TheatreOwner> theatreOwners = new HashSet<>();
		for (int i = 0; i < count; i++) {
			theatreOwners.add(createTestTheatreOwner(i, subCount));
		}
		return theatreOwners;
	}

	protected static TheatreOwner createTestTheatreOwner(int i, int subCount) {
		TheatreOwner theatreOwner = new TheatreOwner();
		theatreOwner.setInfo("info" + i);
		theatreOwner.setName("name" + i);
		theatreOwner.setTheatres(createTestTheatres(subCount));
		return theatreOwner;
	}

	protected static Set<Seat> createTestSeats(int count) {
		Set<Seat> seats = new HashSet<>();
		for (int i = 0; i < count; i++) {
			seats.add(createTestSeat(i));
		}
		return seats;
	}

	protected static Seat createTestSeat(int i) {
		Seat seat = new Seat();
		seat.setPlace("place" + i);
		seat.setRow("row" + i);
		return seat;
	}

	protected static SeatPerfomance createTestSeatPerfomance(double price,
			Seat seat, Perfomance perfomance) {
		SeatPerfomance seatPerfomance = new SeatPerfomance();
		seatPerfomance.setPerfomance(perfomance);
		seatPerfomance.setSeat(seat);
		seatPerfomance.setSeatStatus(SeatStatus.AVAILABLE);
		seatPerfomance.setPrice(price);
		return seatPerfomance;
	}
}
