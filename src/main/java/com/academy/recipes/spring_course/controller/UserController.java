package com.academy.recipes.spring_course.controller;


import java.util.List;

import org.hibernate.param.ExplicitParameterSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.recipes.spring_course.model.User;
import com.academy.recipes.spring_course.repository.UserRepository;



@RestController
@RequestMapping("/app/masterchief")
@CrossOrigin
public class UserController {

	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping
	public List<User> userList() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/user")
	public User findCandidateByName(@RequestParam("name") String name) {
		return userRepository.findByName(name);
	}

	@PostMapping
	public User registerUser(@RequestBody User user) {
		return userRepository.saveAndFlush(user);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User findUserById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		User existingUser = userRepository.findOne(id);
		BeanUtils.copyProperties(user, existingUser);
		return userRepository.saveAndFlush(existingUser);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		User existingUser = userRepository.findOne(id);
		userRepository.delete(existingUser);
	}
	
}
