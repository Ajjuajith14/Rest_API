package com.giri.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {
	
	@GetMapping("/v1/person")
	public Personv1 getfstperson()
	{
		return new Personv1("Giri Ajju");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getsecdperson()
	{
		return new Personv2(new Name("Giri", "Ajju"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public Personv1 getfstpersonReqPara()
	{
		return new Personv1("This is Version1");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public Personv2 getscndpersonReqPara() {
		return new Personv2(new Name("Bob", "Charlie"));
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public Personv1 getfstVersionOfPersonRequestHeader() {
		return new Personv1("Bob Charlie");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public Personv2 getscndVersionOfPersonRequestHeader() {
		return new Personv2(new Name("Bob", "Charlie"));
	}
	

}
