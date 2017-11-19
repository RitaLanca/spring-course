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

import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.repository.AuthorRepository;



@RestController
@RequestMapping("/masterchief")
@CrossOrigin
public class SearchRecipeController {

	
	@Autowired
	private AuthorRepository authorRepository;

	@RequestMapping
	public List<Author> userList() {
		return authorRepository.findAll();
	}
	
	@RequestMapping(value="/user")
	public Author findCandidateByName(@RequestParam("name") String name) {
		return authorRepository.findByName(name);
	}

	@PostMapping
	public Author registerUser(@RequestBody Author user) {
		return authorRepository.saveAndFlush(user);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Author findUserById(@PathVariable Long id) {
		return authorRepository.findOne(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Author updateUser(@PathVariable Long id, @RequestBody Author user) {
		Author existingUser = authorRepository.findOne(id);
		BeanUtils.copyProperties(user, existingUser);
		return authorRepository.saveAndFlush(existingUser);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		Author existingUser = authorRepository.findOne(id);
		authorRepository.delete(existingUser);
	}
	
}
