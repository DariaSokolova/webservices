package com.epam.mentoring.webservices.dao;

import com.epam.mentoring.webservices.bean.Show;

public interface ShowDAO extends IBeanDAO<Show> {

	public Show findShowByTitle(String title);
}
