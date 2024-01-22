package com.giri.rest.webservices.restfulwebservices.versioning;

public class Personv1 {
	
	private String name;

//	public PersonV1(String name) {
//		
//	}


//	public PersonV1(String name) {
//		// TODO Auto-generated constructor stub
//		super();
//		this.name = name;
//	}


	public Personv1(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}


	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}


}
