package com.academy.recipes.spring_course.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.recipes.spring_course.model.User;
import com.academy.recipes.spring_course.repository.UserRepository;



@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/candidate")
	public ResponseEntity<User> findCandidateByUsername(@RequestParam("name") String name) {

		return new ResponseEntity<User>(userRepository.findByName(name), HttpStatus.OK);
		
	}

	@PostMapping("/candidate")
	public ResponseEntity<User> registerUser(@RequestBody User user) {

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	
}
