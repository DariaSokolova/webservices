package com.epam.mentoring.webservices.bean;

import java.util.Date;

public class Perfomance extends AbstractBean {

	private long perfomanceID;
	private Date startTime;
	private Date endTime;
	
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
}
