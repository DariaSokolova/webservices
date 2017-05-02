package com.epam.mentoring.webservices.bean;

public class Theatre extends AbstractBean {
	
	private long theatreID;
	private String title;
	private String summary;
	
	@Override
	public long getID() {
		return getTheatreID();
	}

	public long getTheatreID() {
		return theatreID;
	}

	public void setTheatreID(long theatreID) {
		this.theatreID = theatreID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
