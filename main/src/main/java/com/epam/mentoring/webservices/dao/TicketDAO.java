package com.epam.mentoring.webservices.dao;

import java.util.List;

import com.epam.mentoring.webservices.bean.Ticket;

public interface TicketDAO extends IBeanDAO<Ticket> {

	public List<Ticket> findTicketsByShowTitle(String title);
}
