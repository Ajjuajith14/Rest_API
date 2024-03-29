package com.giri.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.giri.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.giri.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserDaoService service;
	private UserRepository repository;
	private PostRepository postrepository;
	
	public UserJpaResource(UserDaoService service, UserRepository repository, PostRepository postrepository)
	{
		this.service = service;
		this.repository = repository;
		this.postrepository = postrepository;

	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
	   EntityModel<User> entityModel = EntityModel.of(user.get());
		return entityModel;
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrivePostsForusers(@PathVariable int id)
	{
        Optional<User> user = repository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
	  
		return user.get().getPosts();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
	
		User savedUser = repository.save(user);
		 
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(savedUser.getid())
	                .toUri();   
	    
	    return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForusers(@PathVariable int id,@Valid @RequestBody Post post)
	{
        Optional<User> user = repository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		 post.setUser(user.get());
		
		 Post savedPost = postrepository.save(post);
	  
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();   
    
    return ResponseEntity.created(location).build();
	}
	
	

}
