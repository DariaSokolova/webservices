package com.epam.mentoring.webservices.bean;

public class ShowPerfomanceMap extends AbstractBean {

	private long showPerfomanceMapID;
	private Show show;
	private Perfomance perfomance;
	
	@Override
	public long getID() {
		return getShowPerfomanceMapID();
	}

	public long getShowPerfomanceMapID() {
		return showPerfomanceMapID;
	}

	public void setShowPerfomanceMapID(long showPerfomanceMapID) {
		this.showPerfomanceMapID = showPerfomanceMapID;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Perfomance getPerfomance() {
		return perfomance;
	}

	public void setPerfomance(Perfomance perfomance) {
		this.perfomance = perfomance;
	}
}
