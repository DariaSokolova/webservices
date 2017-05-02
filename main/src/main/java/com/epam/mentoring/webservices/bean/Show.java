package com.epam.mentoring.webservices.bean;

public class Show extends AbstractBean {

	private long showID;
	private Theatre theatre;
	private String title;
	private String summary;
	
	@Override
	public long getID() {
		return getShowID();
	}

	public long getShowID() {
		return showID;
	}

	public void setShowID(long showID) {
		this.showID = showID;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
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
