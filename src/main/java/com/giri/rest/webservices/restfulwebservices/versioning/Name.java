package com.giri.rest.webservices.restfulwebservices.versioning;

public class Name {

	private String fstname;
	private String lastname;
	
	public Name(String fstname, String lastname) {
		super();
		this.fstname = fstname;
		this.lastname = lastname;
	}

	public String getFstname() {
		return fstname;
	}

	public void setFstname(String fstname) {
		this.fstname = fstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Name [fstname=" + fstname + ", lastname=" + lastname + "]";
	}
	
	
}
