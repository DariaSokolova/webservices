package com.epam.mentoring.webservices.bean;

import java.util.Set;

public class TheatreOwner extends AbstractBean {
	
	private long theatreOwnerID;
	private String name;
	private String info;
	private Set<Theatre> theatres;
	
	@Override
	public long getID() {
		return getTheatreOwnerID();
	}

	public long getTheatreOwnerID() {
		return theatreOwnerID;
	}

	public void setTheatreOwnerID(long theatreOwnerID) {
		this.theatreOwnerID = theatreOwnerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(Set<Theatre> theatres) {
		this.theatres = theatres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TheatreOwner other = (TheatreOwner) obj;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
