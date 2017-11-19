package com.academy.recipes.spring_course.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.recipes.spring_course.model.Author;
import com.academy.recipes.spring_course.repository.AuthorRepository;
import com.academy.recipes.spring_course.service.impl.AuthorServiceImpl;
import com.academy.recipes.spring_course.service.interfaces.AuthorService;


@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorServiceImpl authorService;
	
	@PostMapping("/add")
	public Author registerAuthor (@RequestBody Author author) {
		return authorService.registerAuthor(author);

	
	}
	
	// @RequestParam means it is a parameter from the GET or POST request
	@PutMapping("/update")
	public Author updateAuthor (@RequestParam ("id") Long id, @RequestBody Author author) {
		return authorService.updateAuthor(id, author);
	}
	
	@GetMapping("/search")
	public Author findAuthorByName (@RequestParam("name") String name) {
	 return authorService.findAuthorByName(name);	
	
	}
	
	@DeleteMapping
	public void deleteAuthor (@RequestParam("name") String name) {
		authorService.deleteAuthor();	
	
	}
	
}
