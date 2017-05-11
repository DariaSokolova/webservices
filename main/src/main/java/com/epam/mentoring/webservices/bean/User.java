package com.epam.mentoring.webservices.bean;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractBean {

	private long userID;
	
	private String name;
	private String surname;
	private String email;
	private Blob photo;
	@JsonManagedReference
	private Set<Task> tasks;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Set<Task> getTasks() {
		if (tasks == null) {
			tasks = new HashSet<>();
		}
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public long getID() {
		return getUserID();
	}
}
