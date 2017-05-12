package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.Theatre;

public interface TheatreDAO extends IBeanDAO<Theatre> {
	
	public Theatre findTheatreByTitle(String title);
	public void lockMethod(Theatre theatre);
}
