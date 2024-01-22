package com.giri.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messagesource;
	
	public HelloWorldController(MessageSource messagesource)
	{
		this.messagesource = messagesource;
	}
	
	@GetMapping(path = "/helloworld")
	public String helloworld()
	{
		return "Hello_Planet";
	}
	
	@GetMapping(path = "/helloworldbean")
	public HelloworldBean hellowoldbean()
	{
		return new HelloworldBean("hello_Universe");
	}

	@GetMapping(path = "/helloworld/pathvariable/{name}")
	public HelloworldBean helloworldpathvariable(@PathVariable String name)
	{
		return new HelloworldBean("Helloworld + name");
	}
	
	@GetMapping("/helloworld-i18n")
	public String HelloworldInternatioanlized()
	{
		Locale locale = LocaleContextHolder.getLocale();
		return messagesource.getMessage("good.morning.message", null, "Default Message", locale);
		// "Internatioanalization-i18n";
		
	}
}
