package com.iqbaliitsmy.restapi.first_rest_api.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iqbaliitsmy.restapi.first_rest_api.user.jpa.PostRepository;
import com.iqbaliitsmy.restapi.first_rest_api.user.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		super();
		this.repository = repository;
		this.postRepository = postRepository;
	}

	// Get all users
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers() {
		return repository.findAll();
	}

	// Get user
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("id:" + id);
		}

		EntityModel<User> entityModel = EntityModel.of(user.get());

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}

	// post user
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	// Delete user
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

//--------------Post------------------
	// Get all post
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrivePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("id:" + id);
		}

		return user.get().getPosts();
	}

	// Get a post
//	@GetMapping("/jpa/users/{id}/posts")
//	public EntityModel<User> retriveAPostForUser(@PathVariable int id) {
//		Optional<User> user = repository.findById(id);
//
//		if (!user.isPresent()) {
//			throw new UserNotFoundException("id:" + id);
//		}
//
//		EntityModel<User> entityModel = EntityModel.of(user.get());
//
//		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
//		entityModel.add(link.withRel("all-users"));
//
//		return entityModel;
//	}

	// post user
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		
		Optional<User> user = repository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("id:" + id);
		}

		  post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

//	// Delete user
//	@DeleteMapping("/jpa/users/{id}/posts/{id}")
//	public void deletePost(@PathVariable int id) {
//		repository.deleteById(id);
//	}

}
