package com.epam.mentoring.webservices.bean;

public abstract class AbstractVersionBean extends AbstractBean {
	
	private int version;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
