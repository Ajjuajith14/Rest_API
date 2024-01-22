package com.giri.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int c = 0;
	
	static {
		users.add(new User(++c,"Anu", LocalDate.now().minusYears(21)));
		users.add(new User(++c,"Adam", LocalDate.now().minusYears(24)));
		users.add(new User(++c,"Arun", LocalDate.now().minusYears(25)));
    }
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User save(User user)
	{
		user.setid(++c);
		users.add(user);
		return user;
		
	}
	
	public User findOne(int id)
	{
		
		Predicate<? super User> predicate = user -> user.getid().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);		
//		 for(int i = 0; i < users.size(); i++){
//			 
//		        if(users.get(i).getid() == id){
//		            return users.get(i);
//		        }
//		 
//		    }
//		 
//		    return null; 
	}
	
	
	public void deletebyID(int id)
	{
		
		Predicate<? super User> predicate = user -> user.getid().equals(id);
		users.removeIf(predicate);
		
	}
	

}
