package com.epam.mentoring.webservices.bean;

public class SeatPerfomance extends AbstractBean {

	private long seatPerfomanceID;
	private Seat seat;
	private Perfomance perfomance;
	private double price;
	private SeatStatus seatStatus;
	
	@Override
	public long getID() {
		return getSeatPerfomanceID();
	}

	public long getSeatPerfomanceID() {
		return seatPerfomanceID;
	}

	public void setSeatPerfomanceID(long seatPerfomanceID) {
		this.seatPerfomanceID = seatPerfomanceID;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Perfomance getPerfomance() {
		return perfomance;
	}

	public void setPerfomance(Perfomance perfomance) {
		this.perfomance = perfomance;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((perfomance == null) ? 0 : perfomance.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result
				+ ((seatStatus == null) ? 0 : seatStatus.hashCode());
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
		SeatPerfomance other = (SeatPerfomance) obj;
		if (perfomance == null) {
			if (other.perfomance != null)
				return false;
		} else if (!perfomance.equals(other.perfomance))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (seatStatus != other.seatStatus)
			return false;
		return true;
	}
}
