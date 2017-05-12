package com.epam.mentoring.webservices.bean;

import java.util.Set;

public class Seat extends AbstractVersionBean {

	private long seatID;
	private String row;
	private String place;
	private Set<SeatPerfomance> seatPerfomanceSet;
	
	@Override
	public long getID() {
		return getSeatID();
	}

	public long getSeatID() {
		return seatID;
	}

	public void setSeatID(long seatID) {
		this.seatID = seatID;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Set<SeatPerfomance> getSeatPerfomanceSet() {
		return seatPerfomanceSet;
	}

	public void setSeatPerfomanceSet(Set<SeatPerfomance> seatPerfomanceSet) {
		this.seatPerfomanceSet = seatPerfomanceSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
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
		Seat other = (Seat) obj;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		return true;
	}
	
}
