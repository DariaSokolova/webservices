package com.epam.mentoring.webservices.bean;

import java.util.Date;
import java.util.Set;

public class Perfomance extends AbstractVersionBean {

	private long perfomanceID;
	private Show show;
	private Theatre theatre;
	private Date startTime;
	private Date endTime;
	private Set<SeatPerfomance> seatPerfomanceSet;
	private Set<Ticket> tickets;
	
	@Override
	public long getID() {
		return getPerfomanceID();
	}

	public long getPerfomanceID() {
		return perfomanceID;
	}

	public void setPerfomanceID(long perfomanceID) {
		this.perfomanceID = perfomanceID;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Set<SeatPerfomance> getSeatPerfomanceSet() {
		return seatPerfomanceSet;
	}

	public void setSeatPerfomanceSet(Set<SeatPerfomance> seatPerfomanceSet) {
		this.seatPerfomanceSet = seatPerfomanceSet;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((show == null) ? 0 : show.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((theatre == null) ? 0 : theatre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfomance other = (Perfomance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (seatPerfomanceSet == null) {
			if (other.seatPerfomanceSet != null)
				return false;
		} else if (!seatPerfomanceSet.equals(other.seatPerfomanceSet))
			return false;
		if (show == null) {
			if (other.show != null)
				return false;
		} else if (!show.equals(other.show))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (theatre == null) {
			if (other.theatre != null)
				return false;
		} else if (!theatre.equals(other.theatre))
			return false;
		return true;
	}
}
