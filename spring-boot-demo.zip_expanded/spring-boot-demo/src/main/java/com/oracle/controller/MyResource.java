package com.oracle.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.business.UserService;
import com.oracle.dao.entities.User;

/*
 * @RestController is used to mark the webservice
 * @RequestMapping is used to mention the URL of the webservice
 * @GetMapping, @PostMapping, @PutMapping, @DeleteMapping to handle http methods
 * ResponseEntity<T> to generate the response
 * @RequestBody is used to extract the request data in the body and map to java object
 * @PathVariable is used to extract the path parameter that is dynamic
 * 
 */
@RestController
@RequestMapping("/v1/api")
public class MyResource {

	/*
	 * Autowire the UserService
	 * Create methods that perform operations on the User entity using HTTP methods
	 */
	@Autowired
	private UserService service;
	// storing the user -> request POST : body 
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> store(@RequestBody User user) {
		User created = service.createUser(user);
		return ResponseEntity.ok(created);
	}
	@GetMapping
	public ResponseEntity<Object> fetchAll() {
		return ResponseEntity.ok(service.fetchUsers());
	}
	@GetMapping(path = "/{idx}")
	public ResponseEntity<Object> fetchUser(@PathVariable("idx") int id) {
		try {
			return ResponseEntity.ok(service.fetchUser(id));
		} catch(RuntimeException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	
	
	@GetMapping(path = "/greet")
	public ResponseEntity<Object> test() {
		// for simple JSON you can use Map<K, V>
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("message", "Welcome to REST Webservice");
		responseMap.put("username", "Kishor");
		ResponseEntity<Object> response = ResponseEntity.ok(responseMap);
		return response;
	}
}
